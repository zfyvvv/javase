package cn.zfy.datainput;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 1�����������
 * @author DELL
 *
 */
public class Demo1 {
	public static void main(String[] args) throws IOException {
		String str="hello,zfy!";
		byte[] b=str.getBytes();
		int len=b.length;
		//д����λ�����ļ���
		//�����ڵ��Ե�ָ��λ�û�ȡ���ַ�����
		/*DataOutputStream dos=new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(
								new File("F:/io.txt"))));
			//��ָ���ļ�����ָ���ַ�����
			dos.write(b, 0, len);
			dos.flush();*/
		
		
		
		//����Ϊʲô��0��
		/*byte[] bb=new byte[1024];
		ByteArrayInputStream bais=new ByteArrayInputStream(bb);
		DataOutputStream dos2=new DataOutputStream(
				new BufferedOutputStream(bb));
		dos2.write(b, 0, len);
		
		byte[] desc=baos.toByteArray();
		System.out.println(desc.length);*/
		
		
		
		
	}

}


