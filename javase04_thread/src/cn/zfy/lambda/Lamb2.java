package cn.zfy.lambda;

/**
 * 1.lambda���ʽ���Զ������lambda���ʽ��labmdad�Ƶ����̣�
 * @author DELL
 *
 */
public class Lamb2 {
	
	public static class La2 implements La{

		@Override
		public void la() {
			// TODO Auto-generated method stub
			System.out.println("this la2");
		}
		
	}

	public static void main(String[] args) {
		//�ֲ��ڲ��ࣻ
		class La3 implements La{
			@Override
			public void la() {
				// TODO Auto-generated method stub
				System.out.println("this is la3");
			}
			
		}
		
		//�����ⲿ�ࣻ
		La la1=new La1();
		la1.la();
		//��̬�ڲ��ࣻ�ŵ㣻��ʹ�ò�����룻
		La la2=new La2();
		la2.la();
		//�ֲ��ڲ��࣬
		La la3=new La3();
		la3.la();
		//�����ڲ��ڣ�
		La la4=new La() {
			@Override
			public void la() {
				// TODO Auto-generated method stub
				System.out.println("this la niming");
			}
		};
		la4.la();
		//lambda���ʽ��jdk8������м򻯣�
		//������Ҫһ�����ͣ�ǰ������һ�����û�һ���β�(һ������)
		La la5=()->{
				// TODO Auto-generated method stub
				System.out.println("this lambda!");
			};
			la5.la();
			
		//����������
		/*()->{
			// TODO Auto-generated method stub
			System.out.println("this lambda!");
		}.la();	*/
			
	}
}

//�ⲿ�ࣻ
class La1 implements La{
	@Override
	public void la() {
		System.out.println("this is la1");
	}
}

//����ӿڣ�
interface La{
	void la();
}
