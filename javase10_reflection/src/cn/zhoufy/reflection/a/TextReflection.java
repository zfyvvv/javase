package cn.zhoufy.reflection.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 1、反射的创建三种方法：
 *   通过路径：Class stuclazz=Class.forName(path);
 *   通过对象：Class stuclazz2=ss.getClass();
 *   通过类名：Class stuclazz3=Students.class;
 * 2、通过反射获取属性，方法和构造器； 
 * @author DELL
 *
 */
//@SuppressWarnings(value="all")
public class TextReflection {
	public static void main(String[] args) throws Exception {
		test3();
		
	}
	
	
/*	1、反射的创建三种方法：
	Class stuclazz=Class.forName(path);
	Class stuclazz2=ss.getClass();
	Class stuclazz3=Students.class;
	2、通过反射获取属性，方法和构造器； */
	public static void test1()throws Exception{
		String path="cn.zhoufy.reflection.a.Students";
	try {
		Class stuclazz=Class.forName(path);
		//Class类也是一个类，当其他的类被JVM加载时，会根据其他类的信息和结果生产唯一的Claaa文件；
		//根据这个class文件，我们反射出加载类的具体信息；  
		System.out.println(stuclazz);
		          
		/*Students ss=new Students();
		Class stuclazz2=ss.getClass();
		System.out.println(stuclazz2);
		Class stuclazz3=Students.class;
		System.out.println(stuclazz3);
		System.out.println(stuclazz.equals(stuclazz2));
		System.out.println(stuclazz.equals(stuclazz3));*/
		//获得属性
		//获得名字；
		System.out.println(stuclazz.getName());
		//获得包名&名字；
		System.out.println(stuclazz.getSimpleName());
		//获得指定属性；
		//Field f=stuclazz.getField("name");
		//获得全部公开属性
		Field[] fs1=stuclazz.getFields();
		System.out.println(fs1.length);
		//获得全部属性
		Field[] fs2=stuclazz.getDeclaredFields();
		System.out.println(fs2.length);
		for(Field temp:fs2) {
			System.out.println("属性-->"+temp);}
		//获得方法；
		Method[] ms=stuclazz.getDeclaredMethods();//
		System.out.println(ms.length);
		for(Method temp:ms) {
		System.out.println("方法-->"+temp);}
		Method m1=stuclazz.getMethod("getName",null);
		System.out.println(m1);
		Method m2=stuclazz.getMethod("setName",String.class);
		System.out.println(m2);
		//获得构造器
		Constructor[] cs=stuclazz.getDeclaredConstructors();
		for(Constructor temp:cs) {
			System.out.println("构造器-->"+temp);
		}
		Constructor c=stuclazz.getConstructor(null);
		System.out.println(c);
		Constructor c2=stuclazz.getConstructor(String.class,int.class,String.class);
		System.out.println(c2);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.out.println("反射类失败！！！！");
			}
			
		}
	//通过反射API创建对象，设置对象属性等；
	//通过反射可以动态设置对象的属性；
	public static void test2() throws Exception{
		String path="cn.zhoufy.reflection.a.Students";
		try {
			Class<Students> stuclazz=(Class<Students>) Class.forName(path);
			Students ss;
			Students ss1;
			try {
				//获得空构造器；
				ss = stuclazz.newInstance();
				System.out.println(ss);  
				//区分构造器
				Constructor<Students> c=stuclazz.getDeclaredConstructor(String.class,int.class,String.class);
				//构建实际对象；并设置班级属性；
				ss1=c.newInstance("周方杨",30,"二年级");
				System.out.println(ss1.getName());
				
				Students ss2=stuclazz.newInstance();
				//通过方法设置属性；
				Method m=stuclazz.getDeclaredMethod("setName", String.class);
				//ss2.setName("刘婷")；
				m.invoke(ss2, "刘婷");
				System.out.println(ss2.getName());
				
				Students ss3=stuclazz.newInstance();
				//设置属性
				Field f=stuclazz.getDeclaredField("name");
				//跳过安全检查；（访问安全检查）
				f.setAccessible(true);
				//属性设置；
				f.set(ss3, "刘婷婷");
				//直接使用ss3的方法读属性
				System.out.println(ss3.getName());
				//通过反射读属性
				System.out.println(f.get(ss3));
				
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("反射类失败！！！！");
		}
		
	}
	
	//Method m2=TextReflection3.class.getMethod("bb", null);
	//TextReflection3,是一个泛型类；
/*	1、泛型信息在编译完成后擦除，为了获得类的这些信息，
	2、通过反射，获得指定方法的参数泛型|返回值泛型；
	3、Type类：
	   GenericArrayType：表示一种元素是参数化类型或变量类型的数组类型；
	   ParameterizedType:表示一种参数化的类型；List<Students>
	   TypeVariable:各种类型变量的公共接口；
	   WildcardType:带边一种通配符类型表达式；*/
	public static void test3()throws Exception{
		try {
			//获得指定方法参数的泛型信息
			//获得指定方法；
			Method m=TextReflection.class.getMethod("aa", Map.class,List.class);
			//获得指定方法 的参数泛型；一个方法可能有多个参数，所以为一个数组；
			Type[] t=m.getGenericParameterTypes();
			for(Type paramType:t) {
				//打印该参数泛型
				System.out.println("#"+paramType);
				//是不是参数类型
				if(paramType instanceof ParameterizedType) { 
					Type[] genericTypes=((ParameterizedType) paramType).getActualTypeArguments();
					//是的话，强制转为带泛型的参数类型，并获得真正的参数类型；
					for(Type genericType:genericTypes) {
						System.out.println("泛型类型"+genericType);
					}
				}
			}
			System.out.println("@@@@@@@@@@@@@@@@@@");
			//获得指定方法返回值的泛型信息
			//获得指定方法
			//获得指定方法 的返回值泛型；
			Method m2=TextReflection.class.getMethod("bb", null);
			Type returnType=m2.getGenericReturnType();
			if(returnType instanceof ParameterizedType) {
				Type[] genericTypes=((ParameterizedType) returnType).getActualTypeArguments();
				for(Type genericType:genericTypes) {
					System.out.println("返回值.泛型类型"+genericType);
				}
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void aa(Map<String,Students> map,List<Students> list) {
		System.out.println("TextReflection.aa()");
	}
	public Map<Integer,Students> bb(){
		System.out.println("TextReflection.bb()");
		return null;
	}
		
		
	}
