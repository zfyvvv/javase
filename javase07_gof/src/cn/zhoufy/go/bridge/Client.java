package cn.zhoufy.go.bridge;

public class Client {
	public static void main(String[] args) {
		//����С����ƽ��
		Computer cp=new Laptop(new Mi());
		cp.sale();
		//���۴�������������ԣ�
		Computer cp1=new Desklop(new Dell());
		cp1.sale();
		
	}

}
