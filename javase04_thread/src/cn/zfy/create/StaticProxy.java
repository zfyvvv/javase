package cn.zfy.create;
/**
 * 1-��̬����
 * 2-��ʵ��ɫ��
 * 3-�����ɫ��������ʵ��ɫ�����ã�
 * 4-�����������ͬ�Ľӿڣ�
 * 
 * @author DELL
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		People p=new People();
		//���濴��company�Ľ�飬ʵ���Ǹ�people���н��
		//������Ϊ�����ߵ����ǣ��ǲ�֪��people�ľ�����̵ģ�ֻ��company���нӴ���
		Company c=new Company(p);//������ݵĶ���Ϊ�գ������д��ݵĶ���ķ�����
		c.getMarry();
	}
}

/**
 * 1���ӿڣ���������ͬ�Ľӿڣ�
 * @author DELL
 *
 */
interface Marry{
	void getMarry();
}

/**
 * 1����ʵ����
 * @author DELL
 *
 */
class People implements Marry{
	@Override
	public void getMarry() {
		System.out.println("�ҿ��Խ���ˣ�����");
		
	}
} 
/**
 * 1��������󣻳�����ʵ��������ã�
 * @author DELL
 *
 */
class Company implements Marry{
	private People you;
	
	public Company() {
		super();
	}

	public Company(People you) {
		super();
		this.you = you;
	}
	public void before() {
		System.out.println("before......");
	}
	public void after() {
		System.out.println("after.............");
	}
	@Override
	public void getMarry() {
		before();
		you.getMarry();
		after();
	}
}


