package cn.zfy.files;
/**
 * 1��������ϵ��
 * 2��File���Ա�ʾ�ļ���Ҳ���Ա�ʾ�ļ��У�
 * 3���ļ��Ĳ�����
 */
import java.io.File;

public class Dome2 {
	public static void main(String[] args) {
		String path="E:/04-java";
		String name="aaa.txt";
		File file=new File(path,name);
		System.out.println(file.getPath());
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
		File file2=new File("E:/04-java/aaa.txt");
		System.out.println(file2.getPath());
		System.out.println(file2.getName());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getParentFile());
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
		File file3=new File("java");
		System.out.println(file3.getPath());
		System.out.println(file3.getName());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getParentFile());
	
}
}
