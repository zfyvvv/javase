package com.zfy.sort;

import java.util.Arrays;
/**
 * 1.������ʱ�临�Ӷ���O(n2),���ǽ��������ϼ��٣������ϻ�������ð������
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
