package cn.zfy.files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Dome5 {
	public static void main(String[] args) {
		File file=new File("E:/python");
		printName(file,1);
		}
	
	//file为指定的文件，level是控制打印的缩进；
	static void printName(File file,int levle) {
		
		//递归头；
		if(null==file||!file.exists()) {
			return;
		}
		for(int i=0;i<levle;i++) {
		System.out.print("##");}
		System.out.println(file.getAbsolutePath());
		if(file.isDirectory()) {
		for(File temp:file.listFiles()) {
			printName(temp,levle+1);
		}
	}}
		
}

