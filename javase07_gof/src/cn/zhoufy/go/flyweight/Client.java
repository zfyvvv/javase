package cn.zhoufy.go.flyweight;

public class Client {
	public static void main(String[] args) {
		ChessFlyWeight c1=ChessFlyWeightFactory.getChess("��ɫ");
		ChessFlyWeight c2=ChessFlyWeightFactory.getChess("��ɫ");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("-----�����ⲿ״̬�Ĵ���-----");
		c1.display(new Coordinate(10,10));
		c2.display(new Coordinate(30,30));
		
	}

}
