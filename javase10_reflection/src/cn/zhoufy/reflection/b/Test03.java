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
	
	//使用javassist生产一个新的类；
	public static void test1() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		//创建类的位置；
		CtClass cc = pool.makeClass("cn.zhoufy.relection.b.Emp");
		
		//创建属性；也可以设置默认值；
		CtField f1 = CtField.make("private int age;", cc);
		CtField f2 = CtField.make("private String name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//创建方法；
		CtMethod m1 = CtMethod.make("public int getAge(){return age;}", cc);
		CtMethod m2 = CtMethod.make("public void setAge(int age){this.age=age;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//添加构造器；
		CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
		//构造器的方法体；可以使用这个修改方法体；
		constructor.setBody("{this.age=age;this.name=name;}");
		cc.addConstructor(constructor);
		
		//写入指定位置；
		cc.writeFile("F:/mycode");
		System.out.println("successed!");
	}
	
	//获取已有类的信息；
	public static void test2() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass dd = pool.makeClass("cn.zhoufy.relection.b.Stu");
		
		byte[] bytes=dd.toBytecode();
		System.out.println(Arrays.toString(bytes));
		//类的名字，简名，超类，接口；
		System.out.println(dd.getName());
		System.out.println(dd.getSimpleName());
		System.out.println(dd.getSuperclass());
		System.out.println(dd.getInterfaces().toString());
		

	}
	
	//使用javassist修改已有的类；添加新的方法；
	public static void test3() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass dd = pool.makeClass("cn.zhoufy.relection.b.Stu");
		//添加新的方法；
		//CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", dd);
		//创建类似上面的方法；
		CtMethod m = new CtMethod(CtClass.intType, "add", 
				new CtClass[]{CtClass.intType,CtClass.intType}, dd);
		m.setModifiers(Modifier.PUBLIC);
		//m.setBody("{return a+b;}");
		m.setBody("{ System.out.println(\"successed!\"); return $1+$2;}");
		dd.addMethod(m);
		
		//通过反射调用新生成的方法；
		//dd.toClass();这是字节码对象的一个方法;类似java中反射的getclass（）；
		Class clazz = dd.toClass();
		Object obj=clazz.newInstance();
		Method m2 = clazz.getDeclaredMethod("add", int.class,int.class);
		Object result = m2.invoke(obj, 200,10);
		System.out.println(result);
	}
	
	//使用javassist修改已有的类；修改属性,增加set和get方法；
	public static void test4() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass dd = pool.makeClass("cn.zhoufy.relection.b.Stu");
		//CtField.make("private int age;", cc);
		//CtField.make("private int age=100;", cc);
		CtField f1 = new CtField(CtClass.intType,"score",dd);
		f1.setModifiers(Modifier.PRIVATE);
		//也可以设置默认值；
		//dd.addField(f1,"89");
		dd.addField(f1);
		
		//获得指定属性；
		//dd.getDeclaredField("score");
		
		//增加set和get方法；
		//CtMethod m1 = CtMethod.make("public int getAge(){return age;}", cc);
		dd.addMethod(CtNewMethod.getter("getScore", f1));
		dd.addMethod(CtNewMethod.getter("setScore", f1));
		
		//构造器前后加代码操作；
		CtConstructor[] cs=dd.getConstructors();
		for(CtConstructor temp:cs) {
			System.out.println(temp.getLongName());
			//可以在构造器前后进行添加和处理信息；
			//temp.insertBefore(src);
			//temp.insertAfter(src);
		}
		
		
		
	}
	
}
