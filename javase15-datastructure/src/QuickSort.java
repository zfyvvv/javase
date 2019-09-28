import java.util.Arrays;

public class QuickSort {
	private static void quickSort(int[] arr) {
		int low=0;
		int high=arr.length-1;
		quickSort(arr,low,high);
		
	}
	private static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int index=partition(arr,low,high);
			quickSort(arr,low,index-1);
			quickSort(arr,index+1,high);
		}
	}
	private static int partition(int[] arr, int low, int high) {
		int i=low;
		int j=high;
		int x=arr[low];
		while(i<j) {
			while(arr[j]>=x&& i<j) {//�ұߵ���ֵͨ��j--һֱ��x�Ƚϣ�������С��x����ʱ��ֹͣѭ������ʱjָ�����
				j--;
			}
			if(i<j) {//ǰ����i<j����С��x�������ŵ�i����ط���i-->low ,cС����ֵ�ŵ�������ͬʱ�ƶ�j��
				arr[i]=arr[j];
				i++;
			}
			while(arr[i]<x && i<j) {//��ߵ���ͨ��i--�ƶ�����x�Ƚϣ������ִ���x��ֵʱ��ֹͣѭ������ʱiָ�������
				i++;
			}
			if(i<j) {//i���ǵ�С��j���Ѵ���x�����ŵ�������
				arr[j]=arr[i];
			}
		}
		arr[i]=x;
		return i;
	}
	public static void main(String[] args) {
		int[] arr= {2,86,45,99,23,15,105,56,63};
		System.out.println("ahead sort:"+Arrays.toString(arr));
		quickSort(arr);
		System.out.println("after sort:"+Arrays.toString(arr));
	}
}
