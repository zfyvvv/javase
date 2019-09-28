package cn.zhoufy.gof.prototype;
/**
 * 1.����new()��ʽ��clone()��ʽ�Ĳ���
 * 2.��ʱ������Ҫ������������ʱ�����Կ�����ʹ��ԭ��ģʽ����¡��������
 * @author DELL
 *
 */
public class Client5 {
	
	public static void textNew(int num) {
		long start=System.currentTimeMillis();
		for(int i=0;i<num;i++) {
			Student s=new Student();
		}
		long end=System.currentTimeMillis();
		System.out.println("new:"+(end-start));
	}
	public static void textClone(int num) throws CloneNotSupportedException {
		long start=System.currentTimeMillis();
		Student t=new Student();
		for(int i=0;i<num;i++) {
			Student s=(Student) t.clone();
		}
		long end=System.currentTimeMillis();
		System.out.println("clone:"+(end-start));
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		textNew(1000);
		textClone(1000);
		
	}
	

}
class Student implements Cloneable{

	public Student() {
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
