package cn.zfy.implement;
/**
 * 1���ӿڵĶ��弰ʵ�֣�
 * 2���ص����������ݴ������Ĳ�ͬ��ò�ͬ�Ľ����
 * @author DELL
 *
 */
public class Printframe {
	//����һ����Ҫ����ӿڵĶ���
	public static void drawFrame(IMyframe f/*�������*/) {
		System.out.println("1�����߳�");
		System.out.println("2����ѭ��");
		System.out.println("3�鿴��Ϣ��");
		//�����ڣ�
		f.paint();
		System.out.println("5�������棬����Ч��");
		
	}
	public static void main(String[] args) {
		//Myframe a= new Myframe();
		//drawFrame(a);
		//drawFrame(Myframe f);
		//GameFrame01 a=new GameFrame01();
		//drawFrame(a);
		//���ݴ���Ķ���ͬ����ò�ͬ�ĳ�������
		drawFrame(new GameFrame02());
}

}

//����һ���ӿڣ�
interface IMyframe{
	void paint();
}
	 

//�ӿڵ�����ʵ�֣�
 class GameFrame01 implements IMyframe {
	 public void paint() { 
		 System.out.println("GameFrame01.paint()");
		 System.out.println("����Ϸ����11��");
	 }	 
 }
		 
 class GameFrame02 implements IMyframe {
	 public void paint() { 
		 System.out.println("GameFrame02.paint()");
		 System.out.println("����Ϸ����22��");
	 }	 
 }		 
		 





