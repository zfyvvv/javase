package com.zfy.serach;

import java.awt.RenderingHints.Key;

/**
 * 1.功能：给定value，返回该value的索引；前提，该数组已经排好序了；
 * 
 * 2.T(n)=O(log2N);S(n)=O();
 * 
 * 
 * @author DELL
 *
 */
public class TestBinarySerach {
	public static void main(String[] args) {
		//给定分数数组；
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		//给定查找的分数；
		int value=10;
		//完成查找；
		//int index=bianrySerach(arr, value);
		int index=bianrySerachByRecursive(arr, value, 0, arr.length-1);
		//输出结果；
		if(index==-1) {
			System.out.println("not found! no exit!");
		}else {
			System.out.println("found! the index is: "+index);
		}
	}
	
	//非递归实现方式；
	public static int bianrySerach(int[] arr,int value) {
		//指定low和high;
		int low=0;
		int high=arr.length-1;
		//折半查找；
		//循环什么时候结束：1找到了，返回mid；2当high--，low++，然后low>high时，循环结束；
		while(low<=high) {
			//
			int mid=(low+high)/2;
			if(value==arr[mid]) {
				return mid;
			}else if(value<arr[mid]){
				high=mid-1;
			}else {//value>arr[mid]
				low=mid+1;
			}
		}
		return -1;
	}
	
	//递归实现方式；
		public static int bianrySerachByRecursive(int[] arr,int value,int low,int high) {
			//递归结束条件；
			if(low>high) {
				return -1;
			}
			int mid=(low+high)/2;
			if(value==arr[mid]) {
				return mid;
			}else if (value<arr[mid]) {
				return bianrySerachByRecursive(arr, value, low, mid-1);
			}else {//value>arr[mid]
				return bianrySerachByRecursive(arr, value, mid+1, high);
			}
		}
}
