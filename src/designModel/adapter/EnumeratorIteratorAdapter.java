package designModel.adapter;

import java.util.Enumeration;
import java.util.Iterator;
/**
 * 适配器 使得Enumeration适配Iterator
 * @author yuhao
 *
 * @param <T>
 */
public class  EnumeratorIteratorAdapter<T> implements Iterator<T>{

	private Enumeration<T> e;
	
	public EnumeratorIteratorAdapter(Enumeration<T> e) {
		super();
		this.e = e;
	}

	@Override
	public boolean hasNext() {
		return e.hasMoreElements();
	}

	@Override
	public T next() {
		return e.nextElement();
	}

	@Override
	public void remove() {
		Iterator.super.remove();
	}
	

}
