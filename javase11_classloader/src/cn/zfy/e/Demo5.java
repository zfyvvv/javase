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
		
		//可以指定加载器；只指定自己的类加载器；
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("E:/myjava"));
		ClassLoader loader3=Thread.currentThread().getContextClassLoader();
		//FileSystemClassLoader
		System.out.println(loader3);
		//指定相应类加载器加载类！
		Class<Demo3> c=(Class<Demo3>) Thread.currentThread().getContextClassLoader().loadClass("cn.zhoufy.classloader.c.Demo3");
		System.out.println(c);
		//双亲委派机制，还是应用类加载器！
		System.out.println(c.getClassLoader());
	}
}

//1.自定义系统文件类加载器
class FileSystemClassLoader extends ClassLoader{
	//cn.zhoufy.test.User -->d:/myjava/  cn/zhoufy/test/User.class
	private String rootDir;
	public FileSystemClassLoader(String rootDir) {
		this.rootDir=rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//先查看是否加载过这个类，如果已经加载，则直接返回；否则，加载新的类；
		Class<?> c=findLoadedClass(name);
		if(c!=null) {
			return c;
		}else {
			ClassLoader parent=this.getParent();
			try {
				//委派给父类，
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
		//IOUtils,可以使用它将流中的数据转成字节数组；
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
