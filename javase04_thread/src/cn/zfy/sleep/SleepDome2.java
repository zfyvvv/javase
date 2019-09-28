package cn.zfy.sleep;
/**
 * 1、系统倒计时，延时1秒打印出来
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepDome2 {
		public static void main(String[] args) {
			/*for(int i=10;i>0;i--) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}*/
			/*int i=10;
		while(true) {
			if(i<=0) {break;}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i--);
		}*/
			Date star=new Date(System.currentTimeMillis());
			Date d=new Date(System.currentTimeMillis()+10*1000);//不断的走，
			Long l=d.getTime();//定值
			boolean flag=true;
			while(flag) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(new SimpleDateFormat("mm:ss").format(d));//打印当前d的时间；
				d=new Date(d.getTime()-1000);//时间d不断的减小1s；
				if(l-10000>d.getTime()) {//时间d开始的时间-10s,d减小到比这个值还小，就break;
					flag=false;
				}
			}
			Date end=new Date(System.currentTimeMillis());
			Long ia=end.getTime()-star.getTime();
			System.out.println(ia);
				
		
	}
}

