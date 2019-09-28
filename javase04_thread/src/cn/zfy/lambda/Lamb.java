package cn.zfy.lambda;

/**
 * 1.lambda���ʽ�����̵߳�ʹ�ã�ǰ���Ǹ��߳�ʹ��һ�λ���ٵĴ�����
 * �ⲿ��->��̬�ڲ�����->�ֲ��ڲ���->�����ڲ���->lambda���ʽ
 * 	jdk8�������ԣ����ڼ򻯼򵥵��߳��ࣻ
 * @author DELL
 *
 */
public class Lamb {
	
	public static class LambdaIn implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				if(0==i%2) {
					System.out.println("static in,iΪż����");
				}else {
					System.out.println("static in,iΪ������");
				}
			}
		}
	}

	public static void main(String[] args) {
		//�ֲ��ڲ��ࣻ
		class LambdaFun implements Runnable{
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					if(0==i%2) {
						System.out.println("fun,iΪż����");
					}else {
						System.out.println("fun,iΪ������");
					}
				}
			}
		}
		
		//�����ⲿ�ࣻ
		//new Thread(new LambdaOut()).start();
		//��̬�ڲ��ࣻ�ŵ㣻��ʹ�ò�����룻
		//new Thread(new LambdaIn()).start();
		//�ֲ��ڲ��࣬�ڷ������棬��ʱû�о�̬�ĸ���������Ǿֲ��ģ�
		//new Thread(new LambdaFun()).start();
		//�����ڲ��ڣ�����������ֻʹ��һ��ʱ������ʹ�ø���ͽӿڣ���ӻ����ţ������壻
		//�ӿڲ�����new�����Ժ���Ӵ��룻
		//��������ֶ�����ʡ�ԣ�
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					if(0==i%2) {
						System.out.println("niming,iΪż����");
					}else {
						System.out.println("niming,iΪ������");
					}
				}
			}
		}).start();
		
		//lambda���ʽ��jdk8������м򻯣�
		//ֻ��ע�߳��壻���ӿڶ�����ȥ����
		new Thread(()->{
				for(int i=0;i<10;i++) {
					if(0==i%2) {
						System.out.println("lamb,iΪż����");
					}else {
						System.out.println("lamb,iΪ������");
					}
				}
			}
		).start();
		
		
		
		
		
	}
}

//�ⲿ�ࣻ
class LambdaOut implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			if(0==i%2) {
				System.out.println("out,iΪż����");
			}else {
				System.out.println("out,iΪ������");
			}
		}
	}
}
