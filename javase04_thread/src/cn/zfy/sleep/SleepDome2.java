package cn.zfy.sleep;
/**
 * 1��ϵͳ����ʱ����ʱ1���ӡ����
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
			Date d=new Date(System.currentTimeMillis()+10*1000);//���ϵ��ߣ�
			Long l=d.getTime();//��ֵ
			boolean flag=true;
			while(flag) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(new SimpleDateFormat("mm:ss").format(d));//��ӡ��ǰd��ʱ�䣻
				d=new Date(d.getTime()-1000);//ʱ��d���ϵļ�С1s��
				if(l-10000>d.getTime()) {//ʱ��d��ʼ��ʱ��-10s,d��С�������ֵ��С����break;
					flag=false;
				}
			}
			Date end=new Date(System.currentTimeMillis());
			Long ia=end.getTime()-star.getTime();
			System.out.println(ia);
				
		
	}
}

