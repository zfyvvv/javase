package cn.zfy.lambda;

/**
 * 1.lambda���ʽ��labmdad�Ƶ�+�������в�����
 * 
 * @author DELL
 *
 */
public class Lamb3 {

	public static void main(String[] args) {
		//���������
		Lam lam=new Lam1();
		lam.la(1);
		//lambda���ʽ��
		Lam lam2=(int a)->{
			System.out.println("this is la2"+"-->"+a);
		};
		lam2.la(2);
		//lambda���ʽ��ʡ�Բ������� ��
		Lam lam3=(a)->{
			System.out.println("this is la3"+"-->"+a);
		};
		lam3.la(3);
		//lambda���ʽ��������ֻ��һ��ʱ������Ҳ����ʡ�ԣ�
		Lam lam4=a->{
			System.out.println("this is la4"+"-->"+a);
		};
		lam4.la(4);
		//lambda���ʽ�����ֻ��һ�д��룻������Ҳ����ʡ�ԣ�
		//����Ƕ��д��룬����ӻ����ţ������������ӷֺţ�
		Lam lam5=a->System.out.println("this is la5"+"-->"+a);
		lam5.la(5);
	}
}

//�ⲿ�ࣻ
class Lam1 implements Lam{
	@Override
	public void la(int a) {
		System.out.println("this is la1"+"-->"+a);
	}
}

//����ӿڣ�
interface Lam{
	void la(int a);
}
