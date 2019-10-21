package com.zfy.sort;

import java.util.Arrays;
/**
 * 1.简单选择排序：时间复杂度是O(n2),但是交换次数上减少，性能上还是优于冒泡排序；
 * @author DELL
 *
 */
public class Test02 {
	public static void main(String[] args) {
		int[] arr= {5,2,6,8,12,56,59};
		arr=simpleSelectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//simpleSelectionSort sort;
	public static int[] simpleSelectionSort(int[] arr) {
		int min;
		for(int i=0;i<arr.length-1;i++){
			min=i;
			for(int j=i+1;j<arr.length-1;j++) {
				if(arr[min]>arr[j]) {
					min=j;
				}
				if(min!=i) {
					int temp=arr[i];
					arr[i]=arr[min];//arr[i]=arr[j],
					arr[min]=temp;
				}
			}
		}
		return arr;
	}
}
