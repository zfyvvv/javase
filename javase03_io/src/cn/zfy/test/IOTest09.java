package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;


/**
 *打印流；
 *1、system.out；
 *2、print.writer；
 *
 *   
 * @author DELL
 *
 */
public class IOTest09 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		test1();
	}
	//
	public static void test1() throws IOException, ClassNotFoundException {
		PrintStream ps=System.out;
		ps.println("zfy");
		ps.println(4);
		
		//把信息指定到文件；
		ps=new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(
								new File("F:/print.txt"))),true);
		ps.println("zfy");
		ps.println(4);
		//重定向输出端；
		System.setOut(ps);
		System.out.println("i have changed!");
		
		//重定向回来；
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("i am backing");
		ps.flush();
		ps.close();
		
	}
	
	//对象流+缓冲流；一层套一层；写出到文件，从文件里面读取；
	public static void test2() throws IOException, ClassNotFoundException {
		
	}
}


