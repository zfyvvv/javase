package cn.zhoufy.reflection.b;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;

public class Test03 {
	public static void main(String[] args)throws Exception  {
		test4();
	}
	
	//ʹ��javassist����һ���µ��ࣻ
	public static void test1() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		//�������λ�ã�
		CtClass cc = pool.makeClass("cn.zhoufy.relection.b.Emp");
		
		//�������ԣ�Ҳ��������Ĭ��ֵ��
		CtField f1 = CtField.make("private int age;", cc);
		CtField f2 = CtField.make("private String name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//����������
		CtMethod m1 = CtMethod.make("public int getAge(){return age;}", cc);
		CtMethod m2 = CtMethod.make("public void setAge(int age){this.age=age;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//��ӹ�������
		CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
		//�������ķ����壻����ʹ������޸ķ����壻
		constructor.setBody("{this.age=age;this.name=name;}");
		cc.addConstructor(constructor);
		
		//д��ָ��λ�ã�
		cc.writeFile("F:/mycode");
		System.out.println("successed!");
	}
	
	//��ȡ���������Ϣ��
	public static void test2() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass dd = pool.makeClass("cn.zhoufy.relection.b.Stu");
		
		byte[] bytes=dd.toBytecode();
		System.out.println(Arrays.toString(bytes));
		//������֣����������࣬�ӿڣ�
		System.out.println(dd.getName());
		System.out.println(dd.getSimpleName());
		System.out.println(dd.getSuperclass());
		System.out.println(dd.getInterfaces().toString());
		

	}
	
	//ʹ��javassist�޸����е��ࣻ����µķ�����
	public static void test3() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass dd = pool.makeClass("cn.zhoufy.relection.b.Stu");
		//����µķ�����
		//CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", dd);
		//������������ķ�����
		CtMethod m = new CtMethod(CtClass.intType, "add", 
				new CtClass[]{CtClass.intType,CtClass.intType}, dd);
		m.setModifiers(Modifier.PUBLIC);
		//m.setBody("{return a+b;}");
		m.setBody("{ System.out.println(\"successed!\"); return $1+$2;}");
		dd.addMethod(m);
		
		//ͨ��������������ɵķ�����
		//dd.toClass();�����ֽ�������һ������;����java�з����getclass������
		Class clazz = dd.toClass();
		Object obj=clazz.newInstance();
		Method m2 = clazz.getDeclaredMethod("add", int.class,int.class);
		Object result = m2.invoke(obj, 200,10);
		System.out.println(result);
	}
	
	//ʹ��javassist�޸����е��ࣻ�޸�����,����set��get������
	public static void test4() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass dd = pool.makeClass("cn.zhoufy.relection.b.Stu");
		//CtField.make("private int age;", cc);
		//CtField.make("private int age=100;", cc);
		CtField f1 = new CtField(CtClass.intType,"score",dd);
		f1.setModifiers(Modifier.PRIVATE);
		//Ҳ��������Ĭ��ֵ��
		//dd.addField(f1,"89");
		dd.addField(f1);
		
		//���ָ�����ԣ�
		//dd.getDeclaredField("score");
		
		//����set��get������
		//CtMethod m1 = CtMethod.make("public int getAge(){return age;}", cc);
		dd.addMethod(CtNewMethod.getter("getScore", f1));
		dd.addMethod(CtNewMethod.getter("setScore", f1));
		
		//������ǰ��Ӵ��������
		CtConstructor[] cs=dd.getConstructors();
		for(CtConstructor temp:cs) {
			System.out.println(temp.getLongName());
			//�����ڹ�����ǰ�������Ӻʹ�����Ϣ��
			//temp.insertBefore(src);
			//temp.insertAfter(src);
		}
		
		
		
	}
	
}
