package cn.zfy.files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
/**
 * 1、使用递归打印指定文件夹的树形目录；
 * @author DELL
 *
 */
public class Dome4 {
	public static void main(String[] args) {
		File file=new File("E:/python");
		if(file.isDirectory()) {
			String[] filename=file.list();
			for(String temp:filename) {
				System.out.println(temp);
			}}
			System.out.println("######################");
			if(file.isDirectory()) {
				File[] files=file.listFiles();
				for(File temp:files) {
					System.out.println(temp);
				}}
			System.out.println("######################");
			if(file.isDirectory()) {
				File[] files=file.listFiles(new FilenameFilter() {

					@Override
					public boolean accept(File files, String name) {
						
						return new File(files,name).isFile() ;//new File(files,name).isFile()&&name.endsWith(".java");
					}
					
				});
				for(File temp:files) {
					System.out.println(temp);
				}}
		}
		
}

