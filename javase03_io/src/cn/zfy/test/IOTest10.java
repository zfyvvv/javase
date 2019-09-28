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
 *��������
 *1����д�����ȡ��
 *2��д��˳��Ͷ�ȡ˳��һ�£�  
 *3���ö������ʵ��Serializable��
 *
 *4��д��Ϊ���л���Ҳ�г־û���
 *   ��ȡδ�����л���
 *   
 *5�����ڲ������л�����Ϣ������ʹ��transient��
 *   
 * @author DELL
 *
 */
public class IOTest10 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		test2();
	}
	//������+��������һ����һ�㣻д���ַ����飻
	public static void test1() throws IOException, ClassNotFoundException {
		//д��
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		//������������+���ݣ�
		//����ͨ��DataOutputStreamд���ֽ�����baos�У�
		//����+����->dos->baos->datas->dis->��ӡ������
		oos.writeUTF("�ܷ���");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChars("c");
		//��������
		oos.writeObject("lqting!");
		Student s=new Student("��", 16, 92);
		oos.writeObject(s);
		oos.flush();
		byte[] datas=baos.toByteArray();
		//��ȡ��
		ObjectInputStream ois=new ObjectInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(datas)));
		//��ȡ��д��˳��һ�£�
		System.out.println(ois.readUTF());
		System.out.println(ois.readInt());
		System.out.println(ois.readBoolean());
		System.out.println(ois.readChar());
		System.out.println(ois.readObject());
		System.out.println(ois.readObject().toString());
	}
	
	//������+��������һ����һ�㣻д�����ļ������ļ������ȡ��
		public static void test2() throws IOException, ClassNotFoundException {
			//д��
			ObjectOutputStream oos=new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("F:/io.txt"))));
			oos.writeUTF("�ܷ���");
			oos.writeInt(18);
			oos.writeBoolean(false);
			oos.writeChars("c");
			//��������
			oos.writeObject("lqting!");
			Student s=new Student("��", 16, 92);
			oos.writeObject(s);
			oos.flush();
			oos.close();
			//��ȡ��
			ObjectInputStream ois=new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(new File("F:/io.txt"))));
			//��ȡ��д��˳��һ�£�
			System.out.println(ois.readUTF());
			System.out.println(ois.readInt());
			System.out.println(ois.readBoolean());
			System.out.println(ois.readChar());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject().toString());
			
		}
}
//javabean,��װ���ݣ�pojo�ࣻ
class Student implements Serializable{
	//�����ݲ���Ҫ���л���
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





