package cn.zfy.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
/**
 * 1���ļ��Ŀ���
 * 2�������ķ�װ��
 * @author DELL
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		String stry="E:/04-java/bbb.txt";
		String strd="E:/04-java/ccc.txt";
		try {
			filePathCopy(stry,strd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	/**
	 * 1���ļ��Ŀ�����
	 * 2�����쳣��ʱ�׳�ȥ��
	 * @param yfilepath
	 * @param dfilepath
	 * @throws IOException
	 */
	public static void filePathCopy(String yfilepath,String dfilepath) throws IOException {
		File yfile=new File(yfilepath);
		File dfile=new File(dfilepath);
		InputStream is=new FileInputStream(yfile);
		OutputStream os=new FileOutputStream(dfile);
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))) {
			os.write(flush, 0, flush.length);
			os.flush();
		}
		os.close();
		is.close();//�ȿ��ĺ��
}


/**
 * 1���汾1.0
 * 2���쳣���д���
 * @author DELL
 *
 */
	public static void fileCopy1(String yfilepath,String dfilepath) {
		File yfile=new File(yfilepath);
		File dfile=new File(dfilepath);
		InputStream is=null;
		OutputStream os=null;
		try {
			is=new FileInputStream(yfile);
			os=new FileOutputStream(dfile);
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=is.read(flush))) {
				os.write(flush, 0, flush.length);//��ʵ�ʳ��ȶ�����
				os.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null!=is||null!=os) {
				try {
					is.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
}
}

