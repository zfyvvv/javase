package cn.zfy.array;

import java.util.Arrays;

/**
 * 1������Ķ���ͳ�ʼ����
 * 2���鿴����ĳ��ȣ���ʱ�ĳ���Ϊ��������ԣ�
 * 3��ȷ���������Ƿ���ĳ��ֵ|���ֵ|��Сֵ��
 * 4�����鲻һ���������飬��������ͬһ�������飻
 * 5��ͬһ�����Ƚϴ�С������ʹ�������ӿڵ�����������
 * 6��Arrays.toString(arr5)������int����ת��Ϊstring���飬����ֱ�ӽ�Ԫ��չʾ������
 * @author DELL
 *
 */
public class Test01 {
	public static void main(String[] args) {
		/*//��̬��ʼ����
		int[] arr= {100,200,300};
		int[] arr2=new int[] {101,102,103};
		
		//��̬��ʼ����
		int[] arr3=new int[3];
		arr3[0]=30;
		arr3[1]=10;
		arr3[2]=20;
		
		//��̬��ʼ���Ż���
		int[] arr4=new int[3];
		for(int i=0;i<arr4.length;i++) {			
			arr4[i]=1000+i;
		}
		//��ӡ����ĳ��ȣ�
		System.out.println(arr4.length);
		//��ӡ���飻
		for(int i=0;i<arr4.length;i++) {			
			System.out.println(arr4[i]);
		}*/
		
		int[] arr5=new int[] {9,8,2,4,5};
		findInt(arr5, 8);
		findMaxMin(arr5);
		//��int����ת��Ϊstring���飬����ֱ�ӽ�Ԫ��չʾ������
		System.out.println(Arrays.toString(arr5));
		
		//�����������飻
		/*Animal[] b=new Animal[3];
		b[0]=new Animal("è��");
		b[1]=new Animal("С��");
		System.out.println(b[0].name);
		System.out.println(b[1].name);
	
		Car[] cars=new Car[3];	
		cars[0]=new Car("2");
		System.out.println(cars[0].name);
		System.out.println(cars[1]);
		System.out.println(cars[2]);*/
	}
	
	//������arr������ֵa��
	public static void findInt(int[] arr,int a) {
		boolean have5=false;
		for(int i=0;i<arr.length;i++) {
			if(a==arr[i]) {
				have5=true;
				break;
			}
		}
		if(have5) {
			System.out.println("have "+a+"!");
		}else {
			System.out.println("have no "+a+"!");
		}
	}
	
	//����ֵ
	public static void findMaxMin(int[] arr) {
		int min=arr[0];
		int max=arr[0];
		for(int i=0;i<arr.length;i++) {
			
			if(min>arr[i]) {
				min=arr[i];
			}
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		System.out.println("min="+min);
		System.out.println("max="+max);
	}
	
}










class Animal {
	String name;
	public Animal(String name) {
		this.name = name;
	}
}

class Car {
	String name;
	public Car(String name) {
		this.name =name;
		
	}
}




