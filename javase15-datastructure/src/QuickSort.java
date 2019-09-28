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
			while(arr[j]>=x&& i<j) {//右边的数值通过j--一直和x比较，当出现小于x的数时，停止循环，此时j指向大数
				j--;
			}
			if(i<j) {//前提是i<j，把小于x的数，放到i这个地方，i-->low ,c小的数值放到左区；同时移动j，
				arr[i]=arr[j];
				i++;
			}
			while(arr[i]<x && i<j) {//左边的数通过i--移动，和x比较，当出现大于x的值时，停止循环；此时i指向大数；
				i++;
			}
			if(i<j) {//i还是得小于j，把大于x的数放到右区；
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
