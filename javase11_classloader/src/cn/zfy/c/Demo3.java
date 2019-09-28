package cn.zfy.c;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 1.����������������
 * 2.�Զ���������������ã�
 * @author DELL
 *
 */
public class Demo3 {
	public static void main(String[] args) throws Exception {
		FileSystemClassLoader loader=new FileSystemClassLoader("E:/myjava");
		FileSystemClassLoader loader2=new FileSystemClassLoader("E:/myjava");
		Class<?> c=loader.loadClass("HiZhoufy");
		Class<?> c2=loader.loadClass("HiZhoufy");
		Class<?> c3=loader2.loadClass("HiZhoufy");
		Class<?> c4=loader2.loadClass("java.lang.String");
		Class<?> c5=loader2.loadClass("cn.zhoufy.classloader.a.Dome1");
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());//ͬһ����������ͬһ���࣬����ͬ��
		System.out.println(c3.hashCode());//��ͬ�ļ���������ͬһ���࣬�಻ͬ��
		System.out.println(c4.hashCode());
		
		System.out.println(c4.getClassLoader());//�������������
		System.out.println(c3.getClassLoader());//�Զ������������
		System.out.println(c5.getClassLoader());//ϵͳĬ�����������
	}
}



//1.�Զ���ϵͳ�ļ��������
class FileSystemClassLoader extends ClassLoader{
	//cn.zhoufy.test.User -->d:/myjava/  cn/zhoufy/test/User.class
	private String rootDir;
	public FileSystemClassLoader(String rootDir) {
		this.rootDir=rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//�Ȳ鿴�Ƿ���ع�����࣬����Ѿ����أ���ֱ�ӷ��أ����򣬼����µ��ࣻ
		Class<?> c=findLoadedClass(name);
		if(c!=null) {
			return c;
		}else {
			ClassLoader parent=this.getParent();
			try {
				//ί�ɸ����࣬
				c=parent.loadClass(name);
			} catch (Exception e) {
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
			byte[] buffer=new byte[1024];
			int temp=0;
			while((temp=is.read(buffer))!=-1) {
				baos.write(buffer, 0, temp);
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

//1.�����������
class NetClassLoader extends ClassLoader{
	//cn.zhoufy.test.User -->d:/myjava/  cn/zhoufy/test/User.class
	private String rootUrl;
	public NetClassLoader(String rootUrl) {
		this.rootUrl=rootUrl;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);//�Ȳ鿴�Ƿ���ع�����࣬����Ѿ����أ���ֱ�ӷ��أ����򣬼����µ��ࣻ
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
		String path=rootUrl+"/"+classname.replace('.', '/')+".class";
		//IOUtils,����ʹ���������е�����ת���ֽ����飻
		InputStream is=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		try {
			URL url=new URL(path);
			is=url.openStream();
			byte[] buffer=new byte[1024];
			int temp=0;
			while((temp=is.read(buffer))!=-1) {
				baos.write(buffer, 0, temp);
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
