package cn.zhoufy.g.chainofrespond;

public class Detector extends Leader{
	public Detector(String name) {
		super(name);
	}
	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getDays()<3) {
			System.out.println("Ա����"+request.getName()+",���������"+request.getDays()+",������ɣ�"+request.getCause());
			System.out.println("���Σ�"+this.name+"ͨ���ˣ�");
		}else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
