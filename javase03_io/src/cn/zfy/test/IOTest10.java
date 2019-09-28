package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 *对象流；
 *1、先写出后读取；
 *2、写出顺序和读取顺序一致；  
 *3、该对象的类实现Serializable；
 *
 *4、写出为序列化；也叫持久化；
 *   读取未反序列化；
 *   
 *5、对于不想序列化的信息，可以使用transient；
 *   
 * @author DELL
 *
 */
public class IOTest10 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		test2();
	}
	//对象流+缓冲流；一层套一层；写到字符数组；
	public static void test1() throws IOException, ClassNotFoundException {
		//写出
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		//操作数据类型+数据；
		//数据通过DataOutputStream写到字节数组baos中；
		//数据+类型->dos->baos->datas->dis->打印出来；
		oos.writeUTF("周方杨");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChars("c");
		//操作对象
		oos.writeObject("lqting!");
		Student s=new Student("杨", 16, 92);
		oos.writeObject(s);
		oos.flush();
		byte[] datas=baos.toByteArray();
		//读取；
		ObjectInputStream ois=new ObjectInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(datas)));
		//读取和写出顺序一致；
		System.out.println(ois.readUTF());
		System.out.println(ois.readInt());
		System.out.println(ois.readBoolean());
		System.out.println(ois.readChar());
		System.out.println(ois.readObject());
		System.out.println(ois.readObject().toString());
	}
	
	//对象流+缓冲流；一层套一层；写出到文件，从文件里面读取；
		public static void test2() throws IOException, ClassNotFoundException {
			//写出
			ObjectOutputStream oos=new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("F:/io.txt"))));
			oos.writeUTF("周方杨");
			oos.writeInt(18);
			oos.writeBoolean(false);
			oos.writeChars("c");
			//操作对象
			oos.writeObject("lqting!");
			Student s=new Student("杨", 16, 92);
			oos.writeObject(s);
			oos.flush();
			oos.close();
			//读取；
			ObjectInputStream ois=new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(new File("F:/io.txt"))));
			//读取和写出顺序一致；
			System.out.println(ois.readUTF());
			System.out.println(ois.readInt());
			System.out.println(ois.readBoolean());
			System.out.println(ois.readChar());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject().toString());
			
		}
}
//javabean,封装数据；pojo类；
class Student implements Serializable{
	//该数据不需要序列化；
	private transient String name;
	private int age;
	private double score;
	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
	
}





