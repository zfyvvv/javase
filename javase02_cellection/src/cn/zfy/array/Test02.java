package cn.zfy.array;

import java.util.Arrays;

/**
 * 1�����������bubble���Ż����bubble������˳����bubble��
 * 
 * @author DELL
 *
 */
public class Test02 {
	public static void main(String[] args) {
		int[] arr=new int[] {9,1,2,4,8};
		//�������Ϊ16�Σ�
//		simpleBubble(arr);
		//�������Ϊ10�Σ�
//		betterBubble(arr);
		//�������Ϊ7�Σ�
		bestBubble(arr);
	}
	//�򵥰�bubble
	public static void simpleBubble(int[] arr) {
		int ms=0;
		for(int i=0;i<arr.length-1;i++) {//ÿһ��Ԫ�ض�Ҫ�ͺ���ıȽϣ�������
			System.out.println("i="+i);
			for(int j=0;j<arr.length-1;j++) {//ȡ�����һ�������һ��Ԫ�ؽ��бȽϣ���ķ��ں��棻
				System.out.println("  "+"j="+j);
				if(arr[j]>arr[j+1]) {
					//����Ǳ������ұ�����ֵ��=Ϊָ��
					int temp=arr[j];//��ʱ����temp->��ֵ��
					arr[j]=arr[j+1];//�±�j������Ԫ��->С��ֵ��
					arr[j+1]=temp;//�±�j+1������Ԫ��->temp->��ֵ��
				}
				ms+=1;
				System.out.println("  "+Arrays.toString(arr));
			} 
		}
		System.out.println("ms="+ms);
	}
	
	//�Ż���bubble
	public static void betterBubble(int[] arr) {
		int mb=0;
		for(int i=0;i<arr.length-1;i++) {
			System.out.println("i="+i);
			//����i=0��һ�˺���������һ��ֵ�϶������ֵ���ʺ�����ٸ�1�εıȽϣ�
			//����i=0��i=1�����˺���������һ��ֵ�͵����ڶ���ֵ���Բ��ñȽϣ�
			//����j��ѭ���������Լ��٣�
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
	
	//����˳���&�Ż���bubble;{9123456}
		public static void bestBubble(int[] arr) {
			int mb=0;
			boolean flag=true;
			for(int i=0;i<arr.length-1;i++) {
				flag=true;
				System.out.println("i="+i);
				for(int j=0;j<arr.length-1-i;j++) {
					System.out.println("  "+"j="+j);
					//�����Ԫ�ص�λ�ý������Ͱ�flagֵΪfalse����Ҫ����ѭ����
					//���û��Ԫ��λ�ý�����˵����ʱ�ĺ�������Ԫ���Ѿ�����flag=false;
					//��arr[i]��ҪС��arr[i+1]����ֱ������ѭ�������������䲻��ִ�У�
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
