package cn.zfy.extend;
/**
 * ��̬��
 * 1���̳У�
 * 2��������д��
 * 3����������ָ���������
 * @author DELL
 *
 */
public class test01 {
	public static void main(String[] args) {
		Animal a=new Animal();
		a.voice();
		Animal b=new Cat();
		b.voice();
		Animal c=new Dog();
		c.voice();
	}
}

class Animal{
	public void voice(){
		System.out.println("the voice of anemal!");
	}
}
class Cat extends Animal{
	public void voice(){
		System.out.println("miao miao miao!");
	}
}
class Dog extends Animal{
	public void voice(){
		System.out.println("wang wang wang!");
	}
}
