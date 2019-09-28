package cn.zhoufy.g.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	protected List<Observer> list=new ArrayList<Observer>();
	
	void addObserver(Observer o) {
		list.add(o);
	}
	void removerObserver(Observer o) {
		list.remove(o);
	}
	void notifyAllObserver() {
		for(Observer temp:list) {
			temp.update(this);
		}
	}

}
