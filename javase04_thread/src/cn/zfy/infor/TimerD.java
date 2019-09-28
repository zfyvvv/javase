package cn.zfy.infor;
/**
 * 1、任务调度
 *
 * 
 */
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerD {
	public static void main(String[] args) {
		Timer t=new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("so easy......");
			}
		}, new Date(System.currentTimeMillis()+2000), 1000);
	}
}
