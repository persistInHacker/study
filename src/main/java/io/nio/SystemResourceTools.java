package io.nio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * User: zhangke
 * Date: 18-5-23
 * Time: 上午10:24
 * Description: 系统资源配置
 *
 * @author zhangke
 */
public class SystemResourceTools {

    private static final Logger logger = LoggerFactory.getLogger(SystemResourceTools.class);

    /**
     * 获取当前进程id
     *
     * @return
     */
    public static int getPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        return Integer.parseInt(pid);
    }

    /**
     * 设置打开文件数
     *
     * @param pid
     * @param value
     */
    public static void setOpenfilesLimit(int pid, int value) {
        String cmd = "prlimit --pid " + pid + " --nofile=" + value;
        logger.info("设置文件描述符限制： " + cmd);
        String[] cmds = {"/bin/sh", "-c", cmd};
        try {
            Runtime.getRuntime().exec(cmds).waitFor(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error("设置文件描述符出错： ", e);
        } catch (IOException e) {
            logger.error("设置文件描述符出错： ", e);
        }
    }

    /**
     * 读取文件描述符配置
     *
     * @param pid
     */
    public static void getOpenfilesLimit(int pid) {
        String[] cmds = {"/bin/sh", "-c", "prlimit --pid " + pid + " | grep \"open files\""};
        String ret = exec(cmds);
        logger.warn("读取文件描述符配置：" + ret);
    }

    /**
     * 执行命令
     *
     * @param cmds
     * @return
     */
    private static String exec(String[] cmds) {
        StringBuilder sb = new StringBuilder();
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmds);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            p.waitFor();
            is.close();
            reader.close();
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 获取主机名
     *
     * @return
     */
   /* public static String getHostName() {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (hostname == null) {
            //执行hostname命令获取
            String[] cmds = {"hostname"};
            String ret = exec(cmds);
            if (!StringUtil.isNullOrEmpty(ret)) {
                hostname = ret;
            }
        }
        return hostname;
    }*/
}
