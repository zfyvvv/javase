package com.zfy.stackqueen;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1.ʹ�ö��У�����ʮ����ת�����ƣ�
 * @author DELL
 *
 */
public class stack {
	
	public static void main(String[] args) {
		//convert1(13);
		convert2(16);
	}
	//����ԭʼ���飻
	 public static void convert1(int i) {
		 int t=i;
		 String str="";
		 do {
			 //����2��������
			 int mod=t%2;
			 //���������
			//System.out.println(mod);
			 //�ȳ�����ģ�ƴ���ں��棻
			 //str=str+mod;
			 //�ȳ�����ģ�ƴ����ǰ�棻
			 str=mod+str;
			 //����2�õ��̣�
			 /*int result=t/2;
			 //ʹ��������������
			 t=result;*/
			//�����϶�Ψһ��
			 t=t/2;
		 }while(t>0);//�̴���0��
		 System.out.println(i+"-->"+str);
	 }
	 
	//���ö��У�
	 public static void convert2(int i) {
		 int t=i;
		 Deque stack=new LinkedList<>();
		 do {
			 //����2��������
			 int mod=t%2;
			 //���������
			stack.push(mod);
			 t=t/2;
		 }while(t>0);//�̴���0��
		 System.out.print(i+"-->"); 
		 //ͨ��ѭ��������ݣ��ǿվ�һֱ�����
		 while(!stack.isEmpty()) {
			 System.out.print(stack.pop());
		 }
	 }
}
