package cn.zfy.exception;
/**
 * 1�������쳣��
 * 2�������쳣��
 * @author DELL
 *
 */
public class Textexception {
	public static void main(String[] args) {
		try {
			//���ֿ�ָ���쳣��
			Computer a=null;
			a.star();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//������ʾ�����쳣��
			System.out.println("have catched the nullpoiterexception!");
		}
	
		
	}
	

}


class Computer{
	public void star() {
		System.out.println("����һ��������࣡");
	}
}
