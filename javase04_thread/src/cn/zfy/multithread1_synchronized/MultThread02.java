package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized��ʲô��
 * �����󣺷���4�ͷ���5���Ķ���MultThread2.class�������
 * ���е�������Ӧ���ڸ߲��������У�Ϊ�˱�֤��Դ�Ĳ���ͻ��
 * @author DELL
 *
 */
public class MultThread02 {
	private static int staticCount=0;
	
	public static synchronized void testSync4() {
			System.out.println(Thread.currentThread().getName()+"staticCount="+staticCount++);
	}
	
	public void testSync2() {
		synchronized (MultThread02.class) {
			System.out.println(Thread.currentThread().getName()+"count="+staticCount++);
		}

	}
	
	public static void main(String[] args) {
		 MultThread02 mt=new MultThread02();
		 //mt����ֵ��ǰ����
	}
	

}
