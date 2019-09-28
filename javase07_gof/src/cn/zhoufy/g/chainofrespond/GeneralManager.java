package cn.zhoufy.g.chainofrespond;

public class GeneralManager extends Leader{
	public GeneralManager(String name) {
		super(name);
	}
	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getDays()<15) {
			System.out.println("员工："+request.getName()+",请假天数："+request.getDays()+",请假理由："+request.getCause());
			System.out.println("总经理："+this.name+"通过了！");
		}else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
