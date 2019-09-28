package cn.zhoufy.g.chainofrespond;

public class LeaveRequest {
	private String name;
	private int days;
	private String cause;
	
	public LeaveRequest(String name, int days, String cause) {
		super();
		this.name = name;
		this.days = days;
		this.cause = cause;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	

}
