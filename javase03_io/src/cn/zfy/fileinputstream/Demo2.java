package cn.zfy.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1���ļ��ֽ�������������ַ���->data->������ڵ���д�����ļ�λ�ú�����->�ⲿ�ļ���
 * 2��������룻
 * @author DELL
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		//1������д����Ŀ�ĵأ�
		File file=new File("E:/04-java/ccc.txt");
		System.out.println(file.exists());
		//2��ѡ������
		OutputStream os=null;
		try {
			//3��������ϵ��λ�ú���
			os=new FileOutputStream(file,true);
			//4��д��ʲô��
			String str="Hellow,world! \r\n";
			//5������Ҫд�� ���ַ�ת���ֽڣ�һ���Զ��꣬
			byte[] data=str.getBytes();
			//6��ʹ���ֽ���д����
			os.write(data, 0, data.length);
			//7��ˢ�£�
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null!=os) {
				try {
					os.close();//8���ر���
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
