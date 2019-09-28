package cn.zfy.d;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;



/**
 * 1.测试类加载过程中简单的加密|解密操作
 * @author DELL
 *
 */
public class Dome4 {
	public static void main(String[] args) throws Exception {
//		int a=3;//011
//		System.out.println(Integer.toBinaryString(a^0xff));//取反加密操作；
		//java.lang.ClassFormatError!!类被加密，加载不到；
//		FileSystemClassLoader loader=new FileSystemClassLoader("E:/myjava/temp");
//		Class<?> c=loader.loadClass("HiZhoufy");
//		System.out.println(c);
		//可以正确读取！！
		DecrptClassLoader loader=new DecrptClassLoader("E:/myjava/temp");
		Class<?> c=loader.loadClass("HiZhoufy");
		System.out.println(c);
		
	}
}


class EncrptUtil {
	public static void main(String[] args) {
		encrpt("E:/myjava/HiZhoufy.class","E:/myjava/temp/HiZhoufy.class");
	}
	
	public static void encrpt(String src,String dest) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(src);
			fos=new FileOutputStream(dest);
			int temp=-1;
			while((temp=fis.read())!=-1) {
				fos.write(temp^0xff);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

//自定义编码类；
class DecrptClassLoader extends ClassLoader{
	private String rootDir;
	public DecrptClassLoader(String rootDir) {
		this.rootDir=rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);
		if(c!=null) {
			return c;
		}else {
			ClassLoader parent=this.getParent();
			
			try {
				c=parent.loadClass(name);//委派给父类，
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			if(c!=null) {
				return c;
			}else {
				byte[] classData=getClassData(name);
				if(classData==null) {
					throw new ClassNotFoundException();
				}else {
					c=defineClass(name,classData,0,classData.length);
				}
			}
		}
		return c;
	}
	private byte[] getClassData(String classname) {
		String path=rootDir+"/"+classname.replace('.', '/')+".class";
		//IOUtils,可以使用它将流中的数据转成字节数组；
		InputStream is=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		try {
			is=new FileInputStream(path);
			int temp=-1;
			while((temp=is.read())!=-1) {//将读is里面的内容，用变量temp存储起来，然后写到baos中去，
				baos.write(temp^0xff);
			}
			return baos.toByteArray();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			if(baos!=null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
 


