package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * �ļ��ַ����������ַ����ļ��ͳ���֮��Ĵ��䣻+��������
 * 1���ļ��ַ���������File->bufferReader(FileReader)->����
 *   ����Դ��
 *   ѡ������
 *   ������
 *   �ͷ���Դ��
 *   
 *2���ļ��ַ������������->bufferWriter(FileWriter)->File��
 *   ����Դ��
 *   ѡ������
 *   ������д�����ݣ�
 *   �ͷ���Դ��
 *   
 *  
 *   
 * @author DELL
 *
 */
public class IOTest06 {

	public static void main(String[] args) {
		test1();
	}
	
	//�ļ�->���� 
	public static void test1() {
		File file=new File("F:/aaa.txt");
		System.out.println(file.exists());
		//ʹ��������������Ҫʹ�ö�̬��
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(file));
			//ֱ�Ӷ�ȡ��String�У�
			String line=null;
			//ʹ���������������ж�ȡ��
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
			
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ļ���ȡʧ�ܣ�");
			}finally {
				if(null!=reader) {
					try {
						reader.close();//9���ر�����
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("�ļ��ر�ʧ�ܣ�");
					}
			}
		}
	}
	
	//����->�ļ���
	public static void test2() {
			File file=new File("F:/aaa.txt");
			System.out.println(file.exists());
			//����ʹ�ö�̬��Ҫʹ������������
			BufferedWriter writer=null;
			try {
				writer=new BufferedWriter(new FileWriter(file));
				//������
				//д��1
/*				String msg="Hellow,world! \r\n";
				char[] datas=msg.toCharArray();
				writer.write(datas, 0, datas.length);*/
				
				//д������
				/*String msg="Hellow,world! \r\n";
				writer.write(msg);
				writer.write("add");
				writer.flush();*/
				
				//д������
				/*writer.append("Hellow,world! \\r\\n").append("add");
				writer.flush();*/
				//����д����
				writer.append("Hellow,world! \\r\\n");
				writer.newLine();
				writer.append("add");
				writer.flush();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(null!=writer) {
					try {
						writer.close();//8���ر���
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}

