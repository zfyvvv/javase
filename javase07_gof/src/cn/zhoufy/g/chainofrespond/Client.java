package cn.zhoufy.g.chainofrespond;

public class Client {
	public static void main(String[] args) {
		Leader a=new Detector("����");
		Leader b=new Manager("����");	
		Leader c=new GeneralManager("����");
		//��֯��������ϵ����
		a.setNextLeader(b);
		b.setNextLeader(c);
		//��ʼ������ٲ�����
		LeaveRequest lr=new LeaveRequest("zfy",17,"��ְ����");
		a.handleRequest(lr);
		
		
	}

}
