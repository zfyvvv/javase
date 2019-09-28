package cn.zfy.files;
/**
 * 1、路径创建 的三种方式；
 * 
 */
import java.io.File;

public class Dome1 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		//路径表示形式
		String path1="E:\\04-java\\aaa.txt";
		String path2="E:"+File.separator+"04-java"+File.separator+"aaa.txt";
		String path3="E:/04-java/aaa.txt";
		System.out.println(path2.equals(path1));
		System.out.println(path2.equals(path3));
	
}
}
