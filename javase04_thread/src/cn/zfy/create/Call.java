package cn.zfy.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用第三种方法创建线程：可以抛出异常，可以有返回值！了解即可；
 * 1-借助Callable()接口+实现call()方法；
 * 2-借助执行调度服务ExecutorService获取Future对象；
 * 		ExecutorService ser=Executors.newFixedThreadPool(2);
 * 		Future result1=ser.submit(实现类对象);
 * 3-获取值result.get();
 * 4-停止服务：ser.shutdownNow();
 * `
 * @author DELL
 *
 */
public class Call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程
		ExecutorService ser=Executors.newFixedThreadPool(2);
		Race ra=new Race("tuzi",500);
		Race to=new Race("wugui",1000);
		//获取值
		Future<Integer> result1=ser.submit(ra);
		Future<Integer> result2=ser.submit(to);
		
		Thread.sleep(2000);//延时2秒
		ra.setFlag(false);//停止线程体循环；
		to.setFlag(false);
		
		int num1=result1.get();
		int num2=result2.get();
		System.out.println("tuzi:"+num1);
		System.out.println("wugui:"+num2);
		ser.shutdownNow();//停止服务；
		
	}

}

	class Race implements Callable<Integer>{
		private String name ;//名称
		private long time;//时间
		private int step;//步数
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
				Thread.sleep(time);//延迟时间
				step++;
			}
			return step;
		}
		
		
	}
