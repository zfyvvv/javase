package com.zfy.serach;

/**
 * 1.功能：顺序查找；给定数组，给定value，返回该value的索引；
 * 
 * 2.T(n)=O(n);S(n)=O(1);
 * 
 * 
 * @author DELL
 *
 */
public class TestLineSerach {
	public static void main(String[] args) {
		//给定分数数组；
		int[] arr= {56,89,25,45,78,96,100,26};
		//给定查找的分数；
		int value=42;
		//完成查找；
		int index=lineSerach(arr, value);
		//输出结果；
		if(index==-1) {
			System.out.println("not found! no exit!");
		}else {
			System.out.println("found! the index is: "+index);
		}
	}
	
	public static int lineSerach(int[] arr,int value) {
		int index=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==value) {
				index=i;
				break;
			}
		}
		return index;
	}

}
