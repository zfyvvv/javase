package cn.zfy.array;

import java.util.Arrays;

/**
 * 1、数组的定义和初始化；
 * 2、查看数组的长度；此时的长度为数组的属性；
 * 3、确定数组中是否有某个值|最大值|最小值；
 * 4、数组不一定是数的组，还可以是同一类对象的组；
 * 5、同一类对象比较大小，可以使用两个接口的两个方法；
 * 6、Arrays.toString(arr5)；将将int数组转换为string数组，可以直接将元素展示出来；
 * @author DELL
 *
 */
public class Test01 {
	public static void main(String[] args) {
		/*//静态初始化；
		int[] arr= {100,200,300};
		int[] arr2=new int[] {101,102,103};
		
		//动态初始化；
		int[] arr3=new int[3];
		arr3[0]=30;
		arr3[1]=10;
		arr3[2]=20;
		
		//动态初始化优化；
		int[] arr4=new int[3];
		for(int i=0;i<arr4.length;i++) {			
			arr4[i]=1000+i;
		}
		//打印数组的长度；
		System.out.println(arr4.length);
		//打印数组；
		for(int i=0;i<arr4.length;i++) {			
			System.out.println(arr4[i]);
		}*/
		
		int[] arr5=new int[] {9,8,2,4,5};
		findInt(arr5, 8);
		findMaxMin(arr5);
		//将int数组转换为string数组，可以直接将元素展示出来；
		System.out.println(Arrays.toString(arr5));
		
		//其他类型数组；
		/*Animal[] b=new Animal[3];
		b[0]=new Animal("猫咪");
		b[1]=new Animal("小狗");
		System.out.println(b[0].name);
		System.out.println(b[1].name);
	
		Car[] cars=new Car[3];	
		cars[0]=new Car("2");
		System.out.println(cars[0].name);
		System.out.println(cars[1]);
		System.out.println(cars[2]);*/
	}
	
	//在数组arr中找数值a；
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
	
	//找最值
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




