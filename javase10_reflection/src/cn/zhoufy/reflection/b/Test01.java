package cn.zhoufy.reflection.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
/**
 * 1、java的动态编译；
 * 2.通过JavaCompiler调用；
 * 3.通过Runtime.getRuntime()执行类；
 * 4.通过JavaCompiler调用；
 * 
 * @author DELL
 *
 */
public class Test01 {

	public static void main(String[] args) throws Exception {
		test3();
	}
	
	//JavaCompiler
	public static void test1() {
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int result=compiler.run(null, null, null, "F:/mycode/Welcome.java");
		System.out.println(result==0?"编译成功！":"编译失败！！");
		String str="public class Hi{public static void main(String[] args) {System.out.println(\"HaHa,zhoyfy!!\");}}";
	}
	
	//Runtime.getRuntime()
	public static void test2() throws Exception {
		Runtime run=Runtime.getRuntime();
		//运行的指定目录的下welcome.class文件；
		Process process=run.exec("java -cp F:/mycode  Welcome");
		//程序已经运行，需要通过IO流将程序内容展示出来；
		
		InputStream in=process.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String info="";
		while((info=reader.readLine())!=null) {
			System.out.println(info);
		}
	}
	//通过classLoader调用；
	//通过反射调用main方法；
	public static void test3() throws Exception {
		try {
			URL[] urls=new URL[] {new URL("file:/"+"F:/mycode/")};
			URLClassLoader loader=new URLClassLoader(urls);
			Class c=loader.loadClass("Welcome");
			//调用加载类的main方法；
			Method m=c.getMethod("main", String[].class);
			//调用静态方法，传入的第一个参数时null；因为静态对象不需要对象去调用；后面是指可变参数；
			//如果静态方法为public static void mm(String[] a,String[] b);
			//此时需要传入两个数组；写的方式为：
			//m.invoke(null,(Object)new String[] {}，(Object)new String[] {});
			//此时的object不能丢，编译器会有编译成多个参数；发生参数不匹配问题；
			//m.invoke(null,new String[] {"aa","bb"})->public static void mm(null，aa,bb)；
			//而我们需要的是public static void mm(String[]{"aa","bb"})；
			//因此，必须加上（object）转型，避免这个问题；
			//当没有参数时，可以不用写；
			m.invoke(null,(Object)new String[] {});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
