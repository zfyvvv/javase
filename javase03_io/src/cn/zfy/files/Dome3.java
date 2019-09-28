package cn.zfy.files;

import java.io.File;
import java.io.IOException;
/**
 * 1、文件的常见操作；
 * 2、创建临时文件夹；并延时销毁；
 * @author DELL
 *
 */
public class Dome3 {
	public static void main(String[] args) throws IOException, InterruptedException {
		String path="E:/04-java";
		String name="aaa.txt";
		File file=new File(path,name);
		File file2=new File("E:/04-java/a");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file2.isDirectory());
		System.out.println(file2.isFile());
		System.out.println("############################");
		System.out.println(file.length());
		System.out.println(file2.length());//只有文件才有长度；
		File file3=new File("E:/04-java/bbb.txt");
		if(!file3.exists()) {//创建文件
			boolean flag=file3.createNewFile();
			System.out.println(flag?"成功":"失败");
		}
		boolean flag=file3.delete();
		System.out.println(flag);
		
		File temp=File.createTempFile("aaaaa", ".temp", new File("E:/04-java"));
		Thread.sleep(5000);//延时
		temp.deleteOnExit();//退出即删除
		
		
}
}
