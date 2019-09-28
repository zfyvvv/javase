package cn.zfy.fileinputstream;
/**
 * 1-文件的拷贝；
 * 2-文件夹的拷贝；
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
	 *  1-用文件路径进行文件夹的拷贝
	 * @param yfile
	 * @param dfile
	 */
	public static void filesCopy(String ystr,String dstr) {
		filesCopy(new File(ystr),new File(dstr));
	}
	
	/**
	 *
	 * 1-用文件对象进行文件夹的拷贝
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
	 * 1、文件夹拷贝细节
	 * @param yfile
	 * @param dfile
	 */
	public static void filesCopyDetail(File yfile,File dfile) {
		if(yfile.isFile()) {
			try {
				FileUtil.fileCopy(yfile, dfile);//凡是文件，直接使用IO流复制；
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(yfile.isDirectory()) {  //dfile=new File(dstr,yfile.getName());凡是文件夹，就直接创建；
			dfile.mkdirs();//先确保文件夹的存在；
			for(File temp:yfile.listFiles()) {//在该文件夹下面，进行递归拷贝；
				filesCopyDetail(temp,new File(dfile,temp.getName()));//目标文件，文件的名称就用源文件里面的name;
			}
		}
		
	}
	
	/**
	 * 1-文件路径进行文件拷贝
	 * @param yfilepath
	 * @param dfilepath
	 * @throws IOException
	 */
	public static void filePathCopy(String yfilepath,String dfilepath) throws IOException {
		fileCopy(new File(yfilepath),new File(dfilepath));
}
	/**
	 * 1-用文件对象进行文件拷贝
	 * @param yfile
	 * @param dfile
	 * @throws IOException
	 */
	public static void fileCopy(File yfile,File dfile) throws IOException {
		if(yfile.isDirectory()) {
			System.out.println("只能拷贝文件！");
			throw new IOException("真的只能拷贝文件！！！！！");
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
		is.close();//先开的后关
}	
}



