package cn.zfy.d;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;



/**
 * 1.��������ع����м򵥵ļ���|���ܲ���
 * @author DELL
 *
 */
public class Dome4 {
	public static void main(String[] args) throws Exception {
//		int a=3;//011
//		System.out.println(Integer.toBinaryString(a^0xff));//ȡ�����ܲ�����
		//java.lang.ClassFormatError!!�౻���ܣ����ز�����
//		FileSystemClassLoader loader=new FileSystemClassLoader("E:/myjava/temp");
//		Class<?> c=loader.loadClass("HiZhoufy");
//		System.out.println(c);
		//������ȷ��ȡ����
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

//�Զ�������ࣻ
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
				c=parent.loadClass(name);//ί�ɸ����࣬
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
		//IOUtils,����ʹ���������е�����ת���ֽ����飻
		InputStream is=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		try {
			is=new FileInputStream(path);
			int temp=-1;
			while((temp=is.read())!=-1) {//����is��������ݣ��ñ���temp�洢������Ȼ��д��baos��ȥ��
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
 


