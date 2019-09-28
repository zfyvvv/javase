package cn.zfy.array;

import java.util.Arrays;

/**
 * 1、数组的排序；bubble，优化后的bubble；考虑顺序后的bubble；
 * 
 * @author DELL
 *
 */
public class Test02 {
	public static void main(String[] args) {
		int[] arr=new int[] {9,1,2,4,8};
		//排序次数为16次；
//		simpleBubble(arr);
		//排序次数为10次；
//		betterBubble(arr);
		//排序次数为7次；
		bestBubble(arr);
	}
	//简单版bubble
	public static void simpleBubble(int[] arr) {
		int ms=0;
		for(int i=0;i<arr.length-1;i++) {//每一个元素都要和后面的比较；躺数；
			System.out.println("i="+i);
			for(int j=0;j<arr.length-1;j++) {//取数组第一个到最后一个元素进行比较，大的放在后面；
				System.out.println("  "+"j="+j);
				if(arr[j]>arr[j+1]) {
					//左边是变量，右边是数值；=为指向；
					int temp=arr[j];//临时变量temp->大值；
					arr[j]=arr[j+1];//下标j的数组元素->小的值；
					arr[j+1]=temp;//下标j+1的数组元素->temp->大值；
				}
				ms+=1;
				System.out.println("  "+Arrays.toString(arr));
			} 
		}
		System.out.println("ms="+ms);
	}
	
	//优化版bubble
	public static void betterBubble(int[] arr) {
		int mb=0;
		for(int i=0;i<arr.length-1;i++) {
			System.out.println("i="+i);
			//经过i=0这一趟后，数组的最后一个值肯定是最大值，故后面减少该1次的比较；
			//经过i=0和i=1这两趟后，数组的最后一个值和倒数第二个值可以不用比较；
			//所以j的循环次数可以减少；
			for(int j=0;j<arr.length-1-i;j++) {
				System.out.println("  "+"j="+j);
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				mb+=1;
				System.out.println("  "+Arrays.toString(arr));
			}
		}
		System.out.println("mb="+mb);
	}
	
	//考虑顺序版&优化版bubble;{9123456}
		public static void bestBubble(int[] arr) {
			int mb=0;
			boolean flag=true;
			for(int i=0;i<arr.length-1;i++) {
				flag=true;
				System.out.println("i="+i);
				for(int j=0;j<arr.length-1-i;j++) {
					System.out.println("  "+"j="+j);
					//如果有元素的位置交换，就把flag值为false，需要继续循环；
					//如果没有元素位置交换，说明此时的后面数组元素已经排序；flag=false;
					//即arr[i]都要小于arr[i+1]，故直接跳出循环，后续的躺输不用执行；
					if(arr[j]>arr[j+1]) {
						int temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
						flag=false;
					}
					mb+=1;
					System.out.println("  "+Arrays.toString(arr));
				}
				if(flag) {break;}
			}
			System.out.println("mb="+mb);
		}
}
