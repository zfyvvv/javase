package cn.zhoufy.gof.prototype;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 1.深克隆：使用对象的序列化和反序列化实现!
 * 2.
 */
import java.util.Date;

public class Client4 {
	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Date d=new Date(123123123L);
//		Sheep2 s1=new Sheep2("zfy",d);
//		Sheep2 s2=(Sheep2) s1.clone();
		Sheep1 s1=new Sheep1("zfy",d);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(s1);
		byte[] bt=bos.toByteArray();
		
		ByteArrayInputStream bis=new ByteArrayInputStream(bt);
		ObjectInputStream ois=new ObjectInputStream(bis);
		Sheep1 s2=(Sheep1) ois.readObject();
		
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		d.setTime(123123123123L);
		System.out.println("------>"+d);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
	}

}
