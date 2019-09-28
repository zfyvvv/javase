package cn.zfy.syn;
/**
 * 1��synchronizedʵ�ֵ������ģʽ��
 *   synchronized���ĵط���λ�ã�����Ч�ʺͰ�ȫ��
 *2���������ģ�ĶԱȺ��Ż���
 *  ����ʽ��
 *  ����ʽ��
 *  �Ż��������ʽ��
 *  
 * @author DELL
 *
 */
public class SynD2 {
	public static void main(String[] args) {
		JvmThread jt1=new JvmThread(200); 
		JvmThread jt2=new JvmThread(500); 
		jt1.setName("zfy");
		jt2.setName("lt");
		jt1.start();
		jt2.start();
	}
}

class JvmThread extends Thread{
	private long time;
	public JvmThread() {
		super();
	}
	public JvmThread(long time) {
		super();
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->"+Jvm.getInstance(time));
		super.run();
	}
}



/**
 * �������ģʽ��ȷ��һ����ֻ��һ������
 * һ������ʽ��
 * 1-˽�л��������������ⲿֱ�ӷ��ʣ�
 * 2-����һ��˽�еľ�̬��������
 * 3-����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
 * 
 * ����3��ʵ�ַ�ʽ�ıȽϣ�
 *   ��ȫ��Ч�ʣ�
 * @author DELL
 *
 */
//����ʽ�������ʱ��һ����������instance��ֻ�е��÷���ʱ�Żᴴ����
class Jvm{
	private static Jvm instance=null;
	
	private Jvm() {};
	
	public static  Jvm getInstance(long time) {
		//��ȫ������Ч����Խϸߣ�����Ѿ����ڶ��������Ч�ʣ������ж���ʱ��ֱ��������������ö���
		//���Ѿ��ж���ʱ�����Բ��õȵȴ���ֱ�ӷ��ؾ�̬��������
		//���û�У���ȥ�����������ʱ��Żῼ���̰߳�ȫ�����������飻
		//����synchronized{}������Ҳ��Ҫ�ж�һ�Σ��ж��������Ƿ����ظ������
		if(null==instance) {
		//dzouble checking!!!	               
		synchronized(Jvm.class) {
		if(null==instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance= new Jvm();
		}
			
	}
		}
		return instance;
}
	//��̬������û�ж����޷�������ͨ��������ֽ�����Ϣ�����Ʋ�����synchronized(��.class){}��
	/*public static  Jvm getInstance(long time) {
	 //��ȫ������Ч��Ҳ���ߣ�  
		synchronized(Jvm.class) {
		if(null==instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance= new Jvm();
		}
			return instance;
	}}*/
	
	//ֱ������̬��������ȫ����Ч�ʲ��ߣ�
	/*public static synchronized Jvm getInstance(long time) {
		if(null==instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance= new Jvm();
		}
			return instance;
	}*/
}

/**
 * �������ģʽ��ȷ��һ����ֻ��һ������
 * һ������ʽ��
 * 1-˽�л��������������ⲿֱ�ӷ��ʣ�
 * 2-����һ��˽�еľ�̬��������ͬʱ�����ö���
 * 3-����һ������Ĺ����ľ�̬�������ʸñ���;
 * @author DELL
 *
 */
//���ظ���ʱ����̬�����;�̬����ֱ�Ӽ��أ��ͻᴴ��һ������
//����|���ظ���ʱ���������������ʱ������һ���ᱻ����������
class Jvm2{

	//����һ��˽�о�̬�������������ʱ���Ѿ�����������ʽ��
	private static Jvm2 instance=new Jvm2();
	//˽�л���������
	private Jvm2() {};
	//�����ṩ��ȡ˽�о�̬�����ķ�����
	public Jvm2 getInstance() {
		return instance;
	}
	
}
/**
 * �������ģʽ��ȷ��һ����ֻ��һ������
 * һ������ʽ�����Ч��
 * 1-˽�л��������������ⲿֱ�ӷ��ʣ�
 * 2-����һ��˽�еľ�̬��������ͬʱ�����ö���
 * 3-����һ������Ĺ����ľ�̬�������ʸñ���;
 * @author DELL
 *
 */
//����|���ظ���ʱ��ֻ���ظ���ľ�̬�����;�̬���ԣ�
//�ڲ��࣬�ڲ���ľ�̬���Ժͷ�����Jvm3���ع����в�һ�����أ�ֻ�е���ʱ�Ż���أ��ӻ�����ʱ�������Ч�ʣ�
//�����ʱ��������һ�����أ��ڲ���Ҳ��һ�����أ�

class Jvm3{
	
	//˽�л���������
	private Jvm3() {};
	//�����ṩ��ȡ�����������ڵ���|���ظ���ʱ�������ɣ�
	public Jvm3 getInstance() {
		//��ʱ��һ��������ȡ��
		return JvmHolder.instance;
	}
	
	//��̬�ڲ��࣬��һ���������أ�ֻ�е���getInstance()ʱ�Ż���أ�
	private static class JvmHolder{
		private static Jvm3 instance=new Jvm3();
		}
	
}