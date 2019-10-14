package com.zfy.stackqueen;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1.使用队列，进行十进制转二进制；
 * @author DELL
 *
 */
public class stack {
	
	public static void main(String[] args) {
		//convert1(13);
		convert2(16);
	}
	//采用原始数组；
	 public static void convert1(int i) {
		 int t=i;
		 String str="";
		 do {
			 //除以2求余数；
			 int mod=t%2;
			 //输出余数；
			//System.out.println(mod);
			 //先出结果的，拼接在后面；
			 //str=str+mod;
			 //先出结果的，拼接在前面；
			 str=mod+str;
			 //除以2得到商；
			 /*int result=t/2;
			 //使用商做被除数；
			 t=result;*/
			//二步合二唯一；
			 t=t/2;
		 }while(t>0);//商大于0；
		 System.out.println(i+"-->"+str);
	 }
	 
	//采用队列；
	 public static void convert2(int i) {
		 int t=i;
		 Deque stack=new LinkedList<>();
		 do {
			 //除以2求余数；
			 int mod=t%2;
			 //输出余数；
			stack.push(mod);
			 t=t/2;
		 }while(t>0);//商大于0；
		 System.out.print(i+"-->"); 
		 //通过循环输出数据；非空就一直输出；
		 while(!stack.isEmpty()) {
			 System.out.print(stack.pop());
		 }
	 }
}
