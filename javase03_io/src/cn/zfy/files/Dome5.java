package cn.zfy.files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Dome5 {
	public static void main(String[] args) {
		File file=new File("E:/python");
		printName(file,1);
		}
	
	//fileΪָ�����ļ���level�ǿ��ƴ�ӡ��������
	static void printName(File file,int levle) {
		
		//�ݹ�ͷ��
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

