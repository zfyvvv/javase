package cn.zfy.lambda;

/**
 * 1.lambda���ʽ��labmdad�Ƶ�+�������в���+����ֵ��
 * 2.Ӧ�ã�
 * 
 * @author DELL
 *
 */
public class Lamb5 {

	public static void main(String[] args) {
		//��jdk8�Ժ�İ汾�о������֣�
		new Thread(()-> {
			System.out.println("111111");
		}).start();
	
	//����ֻ��һ��ʱ������ʡ�Դ����ţ�
	new Thread(()-> System.out.println("22222")).start();
	
	//����ֻ�ж���ʱ������ʡ�ԣ�
	new Thread(()-> {
		System.out.println("111111");
		for(int i=0;i<3;i++) {
			System.out.println("bukeugl-->"+i);
		}
	}).start();
	
	
}
}


