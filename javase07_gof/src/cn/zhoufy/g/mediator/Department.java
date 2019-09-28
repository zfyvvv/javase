package cn.zhoufy.g.mediator;

public interface Department {
	void selfAction();//说明自己的工作
	void outAction();//对外，通过调用具体的中介中调用；

}
