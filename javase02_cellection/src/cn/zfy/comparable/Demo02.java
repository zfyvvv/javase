package cn.zfy.comparable;

import java.util.Arrays;
/**
 * 1、冒泡排序&字符串比较大小；
 * @author DELL
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String[] arr= {"abc","a","abcd","def"};
		boolean sorted;
		sorted=true;
		for(int i=0;i<arr.length-1;i++) {//两个数比较的次数，为元素个数-1；把最大的数放到后面去了；
			sorted=true;
			System.out.println("第"+(i+1)+"躺：");
			for(int j=0;j<arr.length-1-i;j++) {//两个数比较的数，
				System.out.print("第"+(j+1)+"次：");
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {//如果前面的比后面的大；大的数值往后移动；即：前面的值往后移动，
				String temp=arr[j];  //前面的值给temp;
				arr[j]=arr[j+1];//后面的值数值给前面值，此时后面的小值给到前面篮子去了；
				arr[j+1]=temp;//然后把大的值temp给后面的篮子；
				sorted=false;}//91234
				System.out.println(Arrays.toString(arr));
			}	
			if(sorted) {break;}//如果没有交换，每一个arr[i]都要小于arr[i+1]；说明前面的数组已经有序，两个大的数字已经排序，所以后面的躺数不用再执行；//
	}

}

}
