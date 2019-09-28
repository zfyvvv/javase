package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 *数据流；
 *1、先写出后读取；
 *2、写出顺序和读取顺序一致；  
 *3、可以查看一个文件的字节大小或字符串的大小；
 *   
 * @author DELL
 *
 */
public class IOTest08 {

	public static void main(String[] args) throws IOException {
		test1();
	}
	
	// 数据流
	public static void test1() throws IOException {
		//写出
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		//操作数据类型+数据；
		//数据通过DataOutputStream写到字节数组baos中；
		//数据+类型->dos->baos->datas->dis->打印出来；
		dos.writeUTF("周方杨");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChars("c");
		dos.flush();
		byte[] datas=baos.toByteArray();
		//读取；
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(datas));
		//读取和写出顺序一致；
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
	}
	
	//数据流+缓冲流；一层套一层；
	public static void test2() throws IOException {
		//写出
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		//操作数据类型+数据；
		//数据通过DataOutputStream写到字节数组baos中；
		//数据+类型->dos->baos->datas->dis->打印出来；
		dos.writeUTF("周方杨");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChars("c");
		dos.flush();
		byte[] datas=baos.toByteArray();
		//读取；
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(datas)));
		//读取和写出顺序一致；
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
	}
}

