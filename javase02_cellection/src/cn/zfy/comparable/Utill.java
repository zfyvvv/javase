package cn.zfy.comparable;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/**
 * 1、模拟collections类，对数组进行操作；
 * 2、list排序的原理；
 * 3、体现封装的原理；
 * @author DELL
 *
 */
public class Utill {
	
	//对指定list以指定的方法进行排序；
	public static<T> void sort(List<T> list,Comparator<T> com) {
		Object[] arr=list.toArray();
		sort(arr,new StringComp());
		for(int i=0;i<arr.length;i++) {
			list.set(i, (T)arr[i]);
		}
	}
	
	
	//对list进行排序，本质是先将list中的元素通过list.toArray();转换成数组元素，然后进行排序操作；
	public static<T extends Comparable<T>> void sort(List<T> list) {
		Object[] arr=list.toArray();
		sort(arr);
		for(int i=0;i<arr.length;i++) {
			list.set(i, (T)arr[i]);
		}
	}
	
	//冒泡排序&Comparator接口方法下的自定义排序规则；
		public static void sort(Object[] arr,Comparator com) {
			boolean sorted;
			sorted=true;
			for(int i=0;i<arr.length-1;i++) {
				sorted=true;
				for(int j=0;j<arr.length-1-i;j++) {
					if(com.compare(arr[j],arr[j+1])>0) {
					Object temp=arr[j];  
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					sorted=false;}//91234
				}	
				if(sorted) {break;}
		}
		}
	
	//冒泡排序&Comparable接口方法下的自定义排序规则；
	public static<T extends Comparable<T>> void sort(T[] arr) {
		boolean sorted;
		sorted=true;
		for(int i=0;i<arr.length-1;i++) {
			sorted=true;
			for(int j=0;j<arr.length-1-i;j++) {//两个数比较的数，
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {//如果前面的比后面的大；大的数值往后移动；即：前面的值往后移动，
				T temp=arr[j];  //前面的值给temp;
				arr[j]=arr[j+1];//后面的值数值给前面值，此时后面的小值给到前面篮子去了；
				arr[j+1]=temp;//然后把大的值temp给后面的篮子；
				sorted=false;}//91234
			}	
			if(sorted) {break;}//如果没有交换，每一个arr[i]都要小于arr[i+1]；说明前面的数组已经有序，两个大的数字已经排序，所以后面的躺数不用再执行；//
	}

}
	
	
	
	
	
	//冒泡排序；
	public static void sort(Object[] arr) {
		boolean sorted;
		sorted=true;
		for(int i=0;i<arr.length-1;i++) {//两个数比较的次数，为元素个数-1；把最大的数放到后面去了；
			sorted=true;
			for(int j=0;j<arr.length-1-i;j++) {//两个数比较的数，
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {//如果前面的比后面的大；大的数值往后移动；即：前面的值往后移动，
				Object temp=arr[j];  //前面的值给temp;
				arr[j]=arr[j+1];//后面的值数值给前面值，此时后面的小值给到前面篮子去了；
				arr[j+1]=temp;//然后把大的值temp给后面的篮子；
				sorted=false;}//91234
			}	
			if(sorted) {break;}//如果没有交换，每一个arr[i]都要小于arr[i+1]；说明前面的数组已经有序，两个大的数字已经排序，所以后面的躺数不用再执行；//
	}

}

}
