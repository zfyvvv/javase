package cn.zfy.array;

import java.util.Arrays;

/**
 * 1����������򣻼�����
 * 
 * @author DELL
 *
 */
public class Test03 {
	public static void main(String[] args) {
		int[] arr=new int[] {9,1,2,4,8};
		select(arr);
	
	}
	
	public static void select(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int value=arr[i];
			int position=i;
			for(int j=i+1;j<arr.length;j++) {
				//����Сֵ��λ�ã������ǰarr[j]����Сֵ���Ͳ��û����������ͨ��value����ָ��
				//�������������
				if(arr[j]<value) {
					value=arr[j];
					position=j;
				}
			}
			arr[position]=arr[i];
			arr[i]=value;
		}
		System.out.println(Arrays.toString(arr));
	}
}
