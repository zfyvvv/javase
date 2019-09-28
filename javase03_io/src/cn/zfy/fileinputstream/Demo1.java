package cn.zfy.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 1���ļ��ڵ����������ⲿ�ļ�->�ļ��ڵ���->car->�����ַ���->�����ӡ����
 * 2��������룻
 * @author DELL
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		//1��ѡ�����������ļ�λ�ã�in
		File file=new File("E:/04-java/aaa.txt");
		System.out.println(file.exists());
		//2��ѡ��������ѡ���ҹ�˾��
		InputStream is=null;
		try {
			//3��������ϵ��λ�ú�����Ŀ�ĵأ�
			is=new FileInputStream(file);
			//4����ζ��룺һ�ֽڵķ�ʽ���룻һ�ζ�ȡ1024���ֽڣ�һֱ����������ȡ
			byte[] car=new byte[2];
			int len=0;
			try {
				//����һֱ��ȡ�����ļ����ֽڣ�����û��Ϊֹ����ʱis.readΪ-1�������Թ涨���ȵĶ�ȡ����
				//��ȡ���ļ����ݷŵ�car����ȥ��Ȼ��car����ͨ��������ת�����ַ�������ת���ַ�����
				while(-1!=(len=is.read(car))) {
					//5������ȡ���ֽ�ת���ַ���
					String str=new String(car,0,len);
					//�����6���ڳ���������ʾ������
					System.out.println(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ļ���ȡʧ�ܣ�");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ������ڣ�");
		}finally {
			if(null!=is) {
				try {
					is.close();//9���ر�����
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ļ��ر�ʧ�ܣ�");
				}
			}
		}
	}
}
