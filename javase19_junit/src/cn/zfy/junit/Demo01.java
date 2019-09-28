package cn.zfy.junit;

public class Demo01 {
	public int add(int a,int b) {
		return a+b;
	}

	public static void main(String[] args) {
		Demo01 demo=new Demo01();
		System.out.println(demo.add(3, 5));
	}
}
