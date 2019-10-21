package com.zfy.sort;

import java.util.Arrays;
/**
 * 1.bubble：
 * 2.bubble的改进版；减少交换次数；
 * @author DELL
 *
 */
public class Test01 {
	private static int count;
	public static void main(String[] args) {
		//count=5;交换了五次；
		int[] arr= {5,2,6,3,4,8,9,12,56,59};
		arr=bubleSort(arr);
		System.out.println(Arrays.toString(arr));
		
		//count=1;交换了一次；
		/*int[] arr1= {5,2,6,8,12,56,59};
		arr1=bubleSort2(arr1);
		System.out.println(Arrays.toString(arr1));*/
		
		
	}

	//bubble sort;
	public static int[] bubleSort(int[] arr) {
		count=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					count++;
				}
			}
		}
		System.out.println(count);
		return arr;
	}
	
	public static int[] bubleSort2(int[] arr) {
		boolean flag=true;
		count=0;
		for(int i=0;i<arr.length-1&&flag;i++){
			flag=false;
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					flag=true;
					count++;
				}
			}
		}
		System.out.println(count);
		return arr;
	}

}
