package cn.zhoufy.g.observer2;

import java.util.Observable;

public class ConcreteSubject extends Observable{
	private int state;
	
	public void set(int i) {
		state=i;//state have changed!
		setChanged();//subject object has changed !
		notifyObservers(state);//notify others observer!
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
