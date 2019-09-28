package cn.zhoufy.g.observer;

public class ObserverA implements Observer{
	private int myState;

	@Override
	public void update(Subject subject) {//obtain subject's state
		myState=((ConcreteSubserver)subject).getSate();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
}
