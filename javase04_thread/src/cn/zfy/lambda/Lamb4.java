package cn.zfy.lambda;

/**
 * 1.lambda���ʽ��labmdad�Ƶ�+�������в���+����ֵ��
 * 
 * @author DELL
 *
 */
public class Lamb4 {

	public static void main(String[] args) {
		//lambda���ʽ��
		Lambda lam=(int a,int c)->{
			return a+c;
		};
		System.out.println(lam.la(2, 3));
		//lambda���ʽ�����Ϳ���ʡ�ԣ����Ų�����ʡ�ԣ���Ϊ������������
		lam=(a,d)->{
			return a+d;
		};
		System.out.println(lam.la(4, 3));
		//lambda���ʽ�����ֻ��һ�д��룻������Ҳ����ʡ�ԣ��з���ֵ��returnҲ����ʡ�ԣ�
		//����Ƕ��д��룬����ӻ����ţ������������ӷֺţ�
		lam=(a,d)->a+d;
		System.out.println(lam.la(10, 10));
	}
}


//����ӿڣ�
interface Lambda{
	int la(int a,int b);
}
