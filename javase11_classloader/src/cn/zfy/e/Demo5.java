package cn.zfy.e;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.zfy.c.Demo3;

public class Demo5 {
	public static void main(String[] args) throws Exception {
		//AppClassLoader
		ClassLoader loader=Demo5.class.getClassLoader();
		System.out.println(loader);
		
		//AppClassLoader
		ClassLoader loader2=Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		
		//����ָ����������ָֻ���Լ������������
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("E:/myjava"));
		ClassLoader loader3=Thread.currentThread().getContextClassLoader();
		//FileSystemClassLoader
		System.out.println(loader3);
		//ָ����Ӧ������������࣡
		Class<Demo3> c=(Class<Demo3>) Thread.currentThread().getContextClassLoader().loadClass("cn.zhoufy.classloader.c.Demo3");
		System.out.println(c);
		//˫��ί�ɻ��ƣ�����Ӧ�����������
		System.out.println(c.getClassLoader());
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
