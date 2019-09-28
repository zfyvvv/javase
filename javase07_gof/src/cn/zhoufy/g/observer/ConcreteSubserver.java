package cn.zhoufy.g.observer;

public class ConcreteSubserver extends Subject{
	private int sate;

	public int getSate() {
		return sate;
	}

	public void setSate(int sate) {
		this.sate = sate;
		this.notifyAllObserver();
	}
	
	

}
