package cn.zfy.a;
/**
 * 1����ļ���ȫ������⣺���أ����ӣ���֤��׼��������������ʼ������̬��ʼ����ȣ�
 * 2����������������÷�ʽ��
 * 3��������ֱ������÷�ʽ��
 * @author DELL
 *
 */
public class Dome1 {
	static {System.out.println("��̬��ʼ��Dome1�࣡��");}
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("����Dome1��main��������");
		//�������õ����ַ�ʽ��
		//A a=new A();
		//System.out.println(a.width);
		//Class.forName("cn.zhouyfy.classloader.a.A");
		//System.out.println("@@@@@@@@@@@@@@@");
		//A a2=new A();//��ֻ�����һ�Σ��Ϳ��Զ�ε��ã�
		//System.out.println(a2.width);
		//��������
		//System.out.println(A.MAX);
		//A[] as=new A[10];
		
	}
}

class A extends A_Father{
	public static int width=100;//��̬��������̬�򣬾�̬���ԣ�field��
	public static final int MAX=200;
	static {
		System.out.println("��̬��ʼ����A����");
		width=500;
	}
	public A(){
		System.out.println("����A��Ķ��󣡣�");
	}
}
class A_Father{
	static {
		System.out.println("��̬��ʼ��A_Father�࣡��");
	}
}
