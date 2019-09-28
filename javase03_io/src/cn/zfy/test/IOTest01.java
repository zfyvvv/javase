package cn.zfy.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ��ֽ������ֽ����Ķ�̬����ʽ���ֽڣ�Ŀ�ĵ����ļ��ͳ���
 * 1���ļ��ֽ���������File->��FileInputStream)->����
 *   ����Դ��
 *   ѡ������
 *   ������
 *   �ͷ���Դ��
 *   
 *2���ļ��ֽ������������->��FileOutputStream��->File
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
public class IOTest01 {

	public static void main(String[] args) {
		test1();
	}
	
	//
	public static void test1() {
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
	
	//�ֽ�����->�ַ�����
	public static void test2() {
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

