package cn.zfy.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *�ļ��ַ����������ַ����ļ��ͳ���֮��Ĵ��䣻
 * 1���ļ��ֽ���������File->bufferInputStream��FileInputStream)->���򣻼��뻺�壻
 *   ����Դ��
 *   ѡ������
 *   ������
 *   �ͷ���Դ���ر�����㼴�ɣ�
 *   
 *2���ļ��ֽ������������->bufferoutputStream��FileOutputStream��->File�����뻺�壻
 *   ����Դ��
 *   ѡ������
 *   ������д�����ݣ�
 *   �ͷ���Դ���ر�����㼴�ɣ�
 *   
 *  ���׻��㣬��������
 *   
 * @author DELL
 *
 */
public class IOTest04 {

	public static void main(String[] args) {
		test1();
	}
	
	//�ļ�->���� BufferedInputStream
	public static void test1() {
		File file=new File("E:/04-java/aaa.txt");
		System.out.println(file.exists());
		InputStream is=null;
		try {
			is=new BufferedInputStream(new FileInputStream(file));
			byte[] car=new byte[1024];
			int len=0;
			try {
				while(-1!=(len=is.read(car))) {
					String str=new String(car,0,len);
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
	
	//�ֽ�����->�ַ�����BufferedOutputStream
	public static void test2() {
			File file=new File("E:/04-java/ccc.txt");
			System.out.println(file.exists());
			OutputStream os=null;
			try {
				os=new BufferedOutputStream(new FileOutputStream(file));
				String str="Hellow,world! \r\n";
				byte[] data=str.getBytes();
				os.write(data, 0, data.length);
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

