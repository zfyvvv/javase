package cn.zhoufy.innerclass.a;

public class Dome1 {
	public static void main(String[] args) {
		Car c=new Car() {//�̳�ʽ
			@Override
			void run() {
				System.out.println("�̳��ܣ�");
			}
		};
		c.run();
		
	}
	
	
	
	
	public static class StaticInnerClass{//��̬�ڲ���
	}
	public class FileClass{//��Ա�ڲ���|��ͨ�ڲ���
	}
	
	void text1() {
		class LocalClass{//�ֲ��ڲ���|�����ڲ���
		}
		Runnable run=new Runnable() {//�����ڲ��ࣺ������һ�������ڲ�������壬�����������ڲ��� ��һ��ʵ�������ڷ����ڲ���|�����ڲ���
			@Override
			public void run() {
			}
		};//
	}
		Runnable run1=new Runnable() {//�����ڲ��ࣺ���ڷ����ⲿ��|��Ա�ڲ���
		@Override
		public void run() {
			// TODO Auto-generated method stub
		}
		};
		
		
	
}
class Car{
	
	void run() {
		System.out.println("�����ܣ�");
	}
}
