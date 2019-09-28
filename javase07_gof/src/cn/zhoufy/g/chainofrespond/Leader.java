package cn.zhoufy.g.chainofrespond;

public abstract class Leader {
	protected String name;
	protected Leader nextLeader;
	
	public Leader(String name) {
		super();
		this.name = name;
	}

	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	//处理业务的核心方法，
	public abstract void handleRequest(LeaveRequest request);

}
