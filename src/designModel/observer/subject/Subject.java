package designModel.observer.subject;

import designModel.observer.observer.Observer;
/**
 * 主题		
 *
 */
public interface Subject {

	void registerObserver(Observer os);
	void removeObserver(Observer os);
	void notifyAllObserver();
}
