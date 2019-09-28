package cn.zfy.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**�ֽ����������ֽ�����һ�ֶ�̬����ʽ���ֽ����飬Ŀ�ĵ����ֽ�����ͳ���
 * 1���ֽ���������������ָ���ģ�byteArray->��ByteArrayInputStream��->����
 *   ����Դ���ֽ����鲻Ҫ̫��
 *   ѡ������
 *   ������
 *   �ͷ���Դ�����Բ��ô���
 *   
 *2���ֽ����������������->��ByteArrayOutputStream��->���ڴ�����ģ�byteArray
 *   ����Դ���ڲ�ά����
 *   ѡ������������Դ��
 *   ������д�����ݣ�
 *   �ͷ���Դ�����Բ��ã�
 *   
 *   ��ȡ���ݣ����ڴ浼����ͨ��ByteArrayOutputStream.toByteArray()��ȡ�ֽ����飻
 *   
 *   
 * 3�����еĶ��������Զ����ַ������У�  
 * @author DELL
 *
 */
public class IOTest02 {

	public static void main(String[] args) {
		test1();
	}
	
	//�ַ���->ͨ���ֽ����飨flush�����д��ݣ�ͨ��new String(flush,0,len)������������ʾ������
	public static void test1() {
        //����Դ���ַ���->�ֽ����飻
		byte[] src="i believe you can!".getBytes();
		//ѡ������
		InputStream is=null;
		try {
			//��̬��
			is=new ByteArrayInputStream(src);
			//�������ֶζ�ȡ��
			//����������
			byte[] flush=new byte[5];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				//�ֽ�����->�ַ�����
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//�ֽ�����->�ַ�����
	public static void test2() {
        //����Դ�����ڴ��Լ����ƣ�
		byte[] dest=null;
		//ѡ��������������������ʹ�ö�̬����
		ByteArrayOutputStream baos=null;
		try {
			//����ʹ�ö�̬��
			baos=new ByteArrayOutputStream();
			//�������ֶζ�ȡ��
			//��Ҫ���ݵ���Ϣ��
			String msg="show me the able!";
			byte[] datas=msg.getBytes();
			baos.write(datas, 0, datas.length);
			baos.flush();
			
			//��λ�ȡд�����ֽ����飻
			dest=baos.toByteArray();
			System.out.println(dest.length+"-->"+dest.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}

