package cn.zhoufy.g.chainofrespond;

public class Client {
	public static void main(String[] args) {
		Leader a=new Detector("张三");
		Leader b=new Manager("李四");	
		Leader c=new GeneralManager("王五");
		//组织责任链关系对象！
		a.setNextLeader(b);
		b.setNextLeader(c);
		//开始处理请假操作！
		LeaveRequest lr=new LeaveRequest("zfy",17,"求职面试");
		a.handleRequest(lr);
		
		
	}

}
