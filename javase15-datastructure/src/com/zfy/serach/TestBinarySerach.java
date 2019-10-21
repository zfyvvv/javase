package com.zfy.serach;

import java.awt.RenderingHints.Key;

/**
 * 1.���ܣ�����value�����ظ�value��������ǰ�ᣬ�������Ѿ��ź����ˣ�
 * 
 * 2.���ֲ��ң�
 * 
 * 
 * @author DELL
 *
 */
public class TestBinarySerach {
	public static void main(String[] args) {
		//�����������飻
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		//�������ҵķ�����
		int value=10;
		//��ɲ��ң�
		//int index=bianrySerach(arr, value);
		int index=bianrySerachByRecursive(arr, value, 0, arr.length-1);
		//��������
		if(index==-1) {
			System.out.println("not found! no exit!");
		}else {
			System.out.println("found! the index is: "+index);
		}
	}
	
	//�ǵݹ�ʵ�ַ�ʽ��
	//T(n)=O(log2N);S(n)=O(1);
	public static int bianrySerach(int[] arr,int value) {
		//ָ��low��high;
		int low=0;
		int high=arr.length-1;
		//�۰���ң�
		//ѭ��ʲôʱ�������1�ҵ��ˣ�����mid��2��high--��low++��Ȼ��low>highʱ��ѭ��������
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
	
	//�ݹ�ʵ�ַ�ʽ��
	//T(n)=O(log2N);S(n)=O(1*log2N)=O(log2N);
	public static int bianrySerachByRecursive(int[] arr,int value,int low,int high) {
		//�ݹ����������
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
	
	//��ֵ���ң�
	//�����Ǹı�ÿ��low��hight��ֵ�ı仯��Χ��
	
	//쳲��������ң�
	//�����Ǹı�ÿ��low��hight��ֵ������仯��
	
	
	
	
}
