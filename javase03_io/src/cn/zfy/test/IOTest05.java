package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
 * 1���ļ��ַ���������File->FileReader->����
 *   ����Դ��
 *   ѡ������
 *   ������
 *   �ͷ���Դ��
 *   
 *2���ļ��ַ������������->FileWriter->File��
 *   ����Դ��
 *   ѡ������
 *   ������д�����ݣ�
 *   �ͷ���Դ��
 *   
 *  ���׻��㣬��������
 *   
 * @author DELL
 *
 */
public class IOTest05 {

	public static void main(String[] args) {
		test1();
	}
	
	//�ļ�->���� 
	public static void test1() {
		File file=new File("F:/aaa.txt");
		System.out.println(file.exists());
		Reader reader=null;
		try {
			reader=new FileReader(file);
			//����������
			char[] flush=new char[1024];
			int len=-1;
			try {
				while(-1!=(len=reader.read(flush))) {
					String str=new String(flush,0,len);
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
			Writer writer=null;
			try {
				writer=new FileWriter(file);
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

