package cn.zfy.b;
/**
 * 1��������ּ���������νṹ��
 * 2�����������˫��ί�ɻ��ƣ�
 * 
 * @author DELL
 *
 */
public class Dome2 {
	public static void main(String[] args){
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		System.out.println(System.getProperty("java.class.path"));
		
	}
}

