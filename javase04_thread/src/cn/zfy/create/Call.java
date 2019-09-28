package cn.zfy.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ʹ�õ����ַ��������̣߳������׳��쳣�������з���ֵ���˽⼴�ɣ�
 * 1-����Callable()�ӿ�+ʵ��call()������
 * 2-����ִ�е��ȷ���ExecutorService��ȡFuture����
 * 		ExecutorService ser=Executors.newFixedThreadPool(2);
 * 		Future result1=ser.submit(ʵ�������);
 * 3-��ȡֵresult.get();
 * 4-ֹͣ����ser.shutdownNow();
 * `
 * @author DELL
 *
 */
public class Call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//�����߳�
		ExecutorService ser=Executors.newFixedThreadPool(2);
		Race ra=new Race("tuzi",500);
		Race to=new Race("wugui",1000);
		//��ȡֵ
		Future<Integer> result1=ser.submit(ra);
		Future<Integer> result2=ser.submit(to);
		
		Thread.sleep(2000);//��ʱ2��
		ra.setFlag(false);//ֹͣ�߳���ѭ����
		to.setFlag(false);
		
		int num1=result1.get();
		int num2=result2.get();
		System.out.println("tuzi:"+num1);
		System.out.println("wugui:"+num2);
		ser.shutdownNow();//ֹͣ����
		
	}

}

	class Race implements Callable<Integer>{
		private String name ;//����
		private long time;//ʱ��
		private int step;//����
		private boolean flag=true;
		
		public Race() {
			super();
		}
		public Race(String name, long time) {
			super();
			this.name = name;
			this.time = time;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getTime() {
			return time;
		}
		public void setTime(long time) {
			this.time = time;
		}
		public int getStep() {
			return step;
		}
		public void setStep(int step) {
			this.step = step;
		}
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		@Override
		public Integer call() throws Exception {
			//flag=true;
			while(flag) {
				Thread.sleep(time);//�ӳ�ʱ��
				step++;
			}
			return step;
		}
		
		
	}
