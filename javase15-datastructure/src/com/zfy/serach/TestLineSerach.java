package com.zfy.serach;

/**
 * 1.���ܣ�˳����ң��������飬����value�����ظ�value��������
 * 
 * 2.T(n)=O(n);S(n)=O(1);
 * 
 * 
 * @author DELL
 *
 */
public class TestLineSerach {
	public static void main(String[] args) {
		//�����������飻
		int[] arr= {56,89,25,45,78,96,100,26};
		//�������ҵķ�����
		int value=42;
		//��ɲ��ң�
		int index=lineSerach(arr, value);
		//��������
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
