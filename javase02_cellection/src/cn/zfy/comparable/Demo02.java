package cn.zfy.comparable;

import java.util.Arrays;
/**
 * 1��ð������&�ַ����Ƚϴ�С��
 * @author DELL
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String[] arr= {"abc","a","abcd","def"};
		boolean sorted;
		sorted=true;
		for(int i=0;i<arr.length-1;i++) {//�������ȽϵĴ�����ΪԪ�ظ���-1�����������ŵ�����ȥ�ˣ�
			sorted=true;
			System.out.println("��"+(i+1)+"�ɣ�");
			for(int j=0;j<arr.length-1-i;j++) {//�������Ƚϵ�����
				System.out.print("��"+(j+1)+"�Σ�");
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {//���ǰ��ıȺ���Ĵ󣻴����ֵ�����ƶ�������ǰ���ֵ�����ƶ���
				String temp=arr[j];  //ǰ���ֵ��temp;
				arr[j]=arr[j+1];//�����ֵ��ֵ��ǰ��ֵ����ʱ�����Сֵ����ǰ������ȥ�ˣ�
				arr[j+1]=temp;//Ȼ��Ѵ��ֵtemp����������ӣ�
				sorted=false;}//91234
				System.out.println(Arrays.toString(arr));
			}	
			if(sorted) {break;}//���û�н�����ÿһ��arr[i]��ҪС��arr[i+1]��˵��ǰ��������Ѿ�����������������Ѿ��������Ժ��������������ִ�У�//
	}

}

}
