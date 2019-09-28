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
 * 1��java�Ķ�̬���룻
 * 2.ͨ��JavaCompiler���ã�
 * 3.ͨ��Runtime.getRuntime()ִ���ࣻ
 * 4.ͨ��JavaCompiler���ã�
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
		System.out.println(result==0?"����ɹ���":"����ʧ�ܣ���");
		String str="public class Hi{public static void main(String[] args) {System.out.println(\"HaHa,zhoyfy!!\");}}";
	}
	
	//Runtime.getRuntime()
	public static void test2() throws Exception {
		Runtime run=Runtime.getRuntime();
		//���е�ָ��Ŀ¼����welcome.class�ļ���
		Process process=run.exec("java -cp F:/mycode  Welcome");
		//�����Ѿ����У���Ҫͨ��IO������������չʾ������
		
		InputStream in=process.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String info="";
		while((info=reader.readLine())!=null) {
			System.out.println(info);
		}
	}
	//ͨ��classLoader���ã�
	//ͨ���������main������
	public static void test3() throws Exception {
		try {
			URL[] urls=new URL[] {new URL("file:/"+"F:/mycode/")};
			URLClassLoader loader=new URLClassLoader(urls);
			Class c=loader.loadClass("Welcome");
			//���ü������main������
			Method m=c.getMethod("main", String[].class);
			//���þ�̬����������ĵ�һ������ʱnull����Ϊ��̬������Ҫ����ȥ���ã�������ָ�ɱ������
			//�����̬����Ϊpublic static void mm(String[] a,String[] b);
			//��ʱ��Ҫ�����������飻д�ķ�ʽΪ��
			//m.invoke(null,(Object)new String[] {}��(Object)new String[] {});
			//��ʱ��object���ܶ������������б���ɶ������������������ƥ�����⣻
			//m.invoke(null,new String[] {"aa","bb"})->public static void mm(null��aa,bb)��
			//��������Ҫ����public static void mm(String[]{"aa","bb"})��
			//��ˣ�������ϣ�object��ת�ͣ�����������⣻
			//��û�в���ʱ�����Բ���д��
			m.invoke(null,(Object)new String[] {});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
