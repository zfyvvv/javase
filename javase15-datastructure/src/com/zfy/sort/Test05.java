package com.zfy.sort;

import java.util.Arrays;
/**
 * 1.堆排序：时间复杂度是O(n2),但是交换次数上减少，性能上还是优于冒泡排序；
 * @author DELL
 *
 */
public class Test05 {
	public static void main(String[] args) {
		int[] arr= {5,2,6,8,12,56,59};
		arr=straightInsertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//simpleSelectionSort sort;
	public static int[] straightInsertionSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
}
