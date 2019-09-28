package cn.zfy.multithread1_synchronized;
/**
 * 1.synchronized����Ŀ�ģ�
 * ͬ��������ԭ���ԣ�
 * ������Ŀ�ľ���Ϊ�˱�֤������ԭ���ԣ�
 * ԭ���ԣ�������count++��ԭ���Եģ����Ǵ���ӿ�ʼִ�е�����������ԭ���Եģ�
 * ĳһ����Χ�ڵĴ������ʱ���ɷָ�ģ�
 * 2.���ĸ��
 * ������ջ֡���棬ջ֡����ִ�д��룬������ʵ�ڶ�������ߴ�������
 * �ѿռ������ж��󣬴�������������������Ǽ������Ƕ���������
 * ����֮�󣬷��ʶ���ʱû������ģ����Ǹ������ٴμ����ǲ��еģ�
 * ����֮�󣬲����������������ķ��������ã�
 *
 * @author DELL
 *
 */
public class MultThread03 implements Runnable{
	private int count=0;

	//������֮�󣬰���˳���ӡ��
	@Override
	public /*synchronized*/ void run() {
		System.out.println(Thread.currentThread().getName()+"count="+count++);
	}
	public static void main(String[] args) {
		MultThread03 mt3 = new MultThread03();
		for(int i=0;i<5;i++) {
			new Thread(mt3,"Thread-"+i).start();
		}
		
		//���ȫ����0����Ϊÿ�ζ���new MultThread3���󣬵���ÿ��count����0��
		/*for(int i=0;i<5;i++) {
			new Thread(new MultThread3(),"Thread-"+i).start();
		}*/
		
	}
}
