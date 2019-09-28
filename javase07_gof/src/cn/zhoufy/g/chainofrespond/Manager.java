package cn.zhoufy.g.chainofrespond;

public class Manager extends Leader{
	public Manager(String name) {
		super(name);
	}
	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getDays()<10) {
			System.out.println("Ա����"+request.getName()+",���������"+request.getDays()+",������ɣ�"+request.getCause());
			System.out.println("����"+this.name+"ͨ���ˣ�");
		}else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
