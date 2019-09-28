package cn.zfy.fileinputstream;
/**
 * 1-�ļ��Ŀ�����
 * 2-�ļ��еĿ�����
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;

public class FileUtil {
	/**
	 *  1-���ļ�·�������ļ��еĿ���
	 * @param yfile
	 * @param dfile
	 */
	public static void filesCopy(String ystr,String dstr) {
		filesCopy(new File(ystr),new File(dstr));
	}
	
	/**
	 *
	 * 1-���ļ���������ļ��еĿ���
	 * @param yfile
	 * @param dfile
	 */
	public static void filesCopy(File yfile,File dfile) {
		if(yfile.isDirectory()) {
			dfile=new File(dfile,yfile.getName());
		}
		filesCopyDetail(yfile,dfile);
	}
	
	/**
	 * 1���ļ��п���ϸ��
	 * @param yfile
	 * @param dfile
	 */
	public static void filesCopyDetail(File yfile,File dfile) {
		if(yfile.isFile()) {
			try {
				FileUtil.fileCopy(yfile, dfile);//�����ļ���ֱ��ʹ��IO�����ƣ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(yfile.isDirectory()) {  //dfile=new File(dstr,yfile.getName());�����ļ��У���ֱ�Ӵ�����
			dfile.mkdirs();//��ȷ���ļ��еĴ��ڣ�
			for(File temp:yfile.listFiles()) {//�ڸ��ļ������棬���еݹ鿽����
				filesCopyDetail(temp,new File(dfile,temp.getName()));//Ŀ���ļ����ļ������ƾ���Դ�ļ������name;
			}
		}
		
	}
	
	/**
	 * 1-�ļ�·�������ļ�����
	 * @param yfilepath
	 * @param dfilepath
	 * @throws IOException
	 */
	public static void filePathCopy(String yfilepath,String dfilepath) throws IOException {
		fileCopy(new File(yfilepath),new File(dfilepath));
}
	/**
	 * 1-���ļ���������ļ�����
	 * @param yfile
	 * @param dfile
	 * @throws IOException
	 */
	public static void fileCopy(File yfile,File dfile) throws IOException {
		if(yfile.isDirectory()) {
			System.out.println("ֻ�ܿ����ļ���");
			throw new IOException("���ֻ�ܿ����ļ�����������");
		}
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
}



