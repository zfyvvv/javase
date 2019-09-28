package cn.zfy.c;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 1.类加载器的深入理解
 * 2.自定义类加载器的运用；
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
		System.out.println(c2.hashCode());//同一加载器加载同一个类，类相同！
		System.out.println(c3.hashCode());//不同的加载器加载同一个类，类不同；
		System.out.println(c4.hashCode());
		
		System.out.println(c4.getClassLoader());//引导类加载器；
		System.out.println(c3.getClassLoader());//自定义类加载器，
		System.out.println(c5.getClassLoader());//系统默认类加载器；
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

//1.网络类加载器
class NetClassLoader extends ClassLoader{
	//cn.zhoufy.test.User -->d:/myjava/  cn/zhoufy/test/User.class
	private String rootUrl;
	public NetClassLoader(String rootUrl) {
		this.rootUrl=rootUrl;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);//先查看是否加载过这个类，如果已经加载，则直接返回；否则，加载新的类；
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
		String path=rootUrl+"/"+classname.replace('.', '/')+".class";
		//IOUtils,可以使用它将流中的数据转成字节数组；
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
