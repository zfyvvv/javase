package cn.zfy.array;

import java.util.Arrays;
/**
 * 1������system���System.arraycopy(src, srcPos, dest, destPos, length);
 *   ��һ�����鿽��������һ�����飻�ײ�ʵ��������forѭ����
 * 2��array�����кܶ������Ĳ������������������
 * 3�����
 * @author DELL
 *
 */
public class Test04 {
	
	public static void main(String[] args) {
		int[] arr=new int[] {2,5,4,7,8};
		int[] arr2=new int[3];
		
		System.arraycopy(arr, 0, arr2, 0, 3);
		System.out.println(Arrays.toString(arr2));
		//[2, 5, 4]
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		//[2, 4, 5, 7, 8]
		
		Arrays.fill(arr, 0, 2, 10);
		System.out.println(Arrays.toString(arr));
		//[10, 10, 5, 7, 8]
		
		String[] str= {"other"};
		//[other]
		//str=Arrays.copyOf(str, 2);
		//[other, null]
		System.out.println(Arrays.toString(str));
		
		
		
		
	}
	
	

}
