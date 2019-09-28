package cn.zfy.comparable;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
/**
 * 1��ģ��collections�࣬��������в�����
 * 2��list�����ԭ��
 * 3�����ַ�װ��ԭ��
 * @author DELL
 *
 */
public class Utill {
	
	//��ָ��list��ָ���ķ�����������
	public static<T> void sort(List<T> list,Comparator<T> com) {
		Object[] arr=list.toArray();
		sort(arr,new StringComp());
		for(int i=0;i<arr.length;i++) {
			list.set(i, (T)arr[i]);
		}
	}
	
	
	//��list�������򣬱������Ƚ�list�е�Ԫ��ͨ��list.toArray();ת��������Ԫ�أ�Ȼ��������������
	public static<T extends Comparable<T>> void sort(List<T> list) {
		Object[] arr=list.toArray();
		sort(arr);
		for(int i=0;i<arr.length;i++) {
			list.set(i, (T)arr[i]);
		}
	}
	
	//ð������&Comparator�ӿڷ����µ��Զ����������
		public static void sort(Object[] arr,Comparator com) {
			boolean sorted;
			sorted=true;
			for(int i=0;i<arr.length-1;i++) {
				sorted=true;
				for(int j=0;j<arr.length-1-i;j++) {
					if(com.compare(arr[j],arr[j+1])>0) {
					Object temp=arr[j];  
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					sorted=false;}//91234
				}	
				if(sorted) {break;}
		}
		}
	
	//ð������&Comparable�ӿڷ����µ��Զ����������
	public static<T extends Comparable<T>> void sort(T[] arr) {
		boolean sorted;
		sorted=true;
		for(int i=0;i<arr.length-1;i++) {
			sorted=true;
			for(int j=0;j<arr.length-1-i;j++) {//�������Ƚϵ�����
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {//���ǰ��ıȺ���Ĵ󣻴����ֵ�����ƶ�������ǰ���ֵ�����ƶ���
				T temp=arr[j];  //ǰ���ֵ��temp;
				arr[j]=arr[j+1];//�����ֵ��ֵ��ǰ��ֵ����ʱ�����Сֵ����ǰ������ȥ�ˣ�
				arr[j+1]=temp;//Ȼ��Ѵ��ֵtemp����������ӣ�
				sorted=false;}//91234
			}	
			if(sorted) {break;}//���û�н�����ÿһ��arr[i]��ҪС��arr[i+1]��˵��ǰ��������Ѿ�����������������Ѿ��������Ժ��������������ִ�У�//
	}

}
	
	
	
	
	
	//ð������
	public static void sort(Object[] arr) {
		boolean sorted;
		sorted=true;
		for(int i=0;i<arr.length-1;i++) {//�������ȽϵĴ�����ΪԪ�ظ���-1�����������ŵ�����ȥ�ˣ�
			sorted=true;
			for(int j=0;j<arr.length-1-i;j++) {//�������Ƚϵ�����
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {//���ǰ��ıȺ���Ĵ󣻴����ֵ�����ƶ�������ǰ���ֵ�����ƶ���
				Object temp=arr[j];  //ǰ���ֵ��temp;
				arr[j]=arr[j+1];//�����ֵ��ֵ��ǰ��ֵ����ʱ�����Сֵ����ǰ������ȥ�ˣ�
				arr[j+1]=temp;//Ȼ��Ѵ��ֵtemp����������ӣ�
				sorted=false;}//91234
			}	
			if(sorted) {break;}//���û�н�����ÿһ��arr[i]��ҪС��arr[i+1]��˵��ǰ��������Ѿ�����������������Ѿ��������Ժ��������������ִ�У�//
	}

}

}
