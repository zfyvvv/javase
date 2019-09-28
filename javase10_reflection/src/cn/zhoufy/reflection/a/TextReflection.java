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
 * 1������Ĵ������ַ�����
 *   ͨ��·����Class stuclazz=Class.forName(path);
 *   ͨ������Class stuclazz2=ss.getClass();
 *   ͨ��������Class stuclazz3=Students.class;
 * 2��ͨ�������ȡ���ԣ������͹������� 
 * @author DELL
 *
 */
//@SuppressWarnings(value="all")
public class TextReflection {
	public static void main(String[] args) throws Exception {
		test3();
		
	}
	
	
/*	1������Ĵ������ַ�����
	Class stuclazz=Class.forName(path);
	Class stuclazz2=ss.getClass();
	Class stuclazz3=Students.class;
	2��ͨ�������ȡ���ԣ������͹������� */
	public static void test1()throws Exception{
		String path="cn.zhoufy.reflection.a.Students";
	try {
		Class stuclazz=Class.forName(path);
		//Class��Ҳ��һ���࣬���������౻JVM����ʱ����������������Ϣ�ͽ������Ψһ��Claaa�ļ���
		//�������class�ļ������Ƿ����������ľ�����Ϣ��  
		System.out.println(stuclazz);
		          
		/*Students ss=new Students();
		Class stuclazz2=ss.getClass();
		System.out.println(stuclazz2);
		Class stuclazz3=Students.class;
		System.out.println(stuclazz3);
		System.out.println(stuclazz.equals(stuclazz2));
		System.out.println(stuclazz.equals(stuclazz3));*/
		//�������
		//������֣�
		System.out.println(stuclazz.getName());
		//��ð���&���֣�
		System.out.println(stuclazz.getSimpleName());
		//���ָ�����ԣ�
		//Field f=stuclazz.getField("name");
		//���ȫ����������
		Field[] fs1=stuclazz.getFields();
		System.out.println(fs1.length);
		//���ȫ������
		Field[] fs2=stuclazz.getDeclaredFields();
		System.out.println(fs2.length);
		for(Field temp:fs2) {
			System.out.println("����-->"+temp);}
		//��÷�����
		Method[] ms=stuclazz.getDeclaredMethods();//
		System.out.println(ms.length);
		for(Method temp:ms) {
		System.out.println("����-->"+temp);}
		Method m1=stuclazz.getMethod("getName",null);
		System.out.println(m1);
		Method m2=stuclazz.getMethod("setName",String.class);
		System.out.println(m2);
		//��ù�����
		Constructor[] cs=stuclazz.getDeclaredConstructors();
		for(Constructor temp:cs) {
			System.out.println("������-->"+temp);
		}
		Constructor c=stuclazz.getConstructor(null);
		System.out.println(c);
		Constructor c2=stuclazz.getConstructor(String.class,int.class,String.class);
		System.out.println(c2);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.out.println("������ʧ�ܣ�������");
			}
			
		}
	//ͨ������API�����������ö������Եȣ�
	//ͨ��������Զ�̬���ö�������ԣ�
	public static void test2() throws Exception{
		String path="cn.zhoufy.reflection.a.Students";
		try {
			Class<Students> stuclazz=(Class<Students>) Class.forName(path);
			Students ss;
			Students ss1;
			try {
				//��ÿչ�������
				ss = stuclazz.newInstance();
				System.out.println(ss);  
				//���ֹ�����
				Constructor<Students> c=stuclazz.getDeclaredConstructor(String.class,int.class,String.class);
				//����ʵ�ʶ��󣻲����ð༶���ԣ�
				ss1=c.newInstance("�ܷ���",30,"���꼶");
				System.out.println(ss1.getName());
				
				Students ss2=stuclazz.newInstance();
				//ͨ�������������ԣ�
				Method m=stuclazz.getDeclaredMethod("setName", String.class);
				//ss2.setName("����")��
				m.invoke(ss2, "����");
				System.out.println(ss2.getName());
				
				Students ss3=stuclazz.newInstance();
				//��������
				Field f=stuclazz.getDeclaredField("name");
				//������ȫ��飻�����ʰ�ȫ��飩
				f.setAccessible(true);
				//�������ã�
				f.set(ss3, "������");
				//ֱ��ʹ��ss3�ķ���������
				System.out.println(ss3.getName());
				//ͨ�����������
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
			System.out.println("������ʧ�ܣ�������");
		}
		
	}
	
	//Method m2=TextReflection3.class.getMethod("bb", null);
	//TextReflection3,��һ�������ࣻ
/*	1��������Ϣ�ڱ�����ɺ������Ϊ�˻�������Щ��Ϣ��
	2��ͨ�����䣬���ָ�������Ĳ�������|����ֵ���ͣ�
	3��Type�ࣺ
	   GenericArrayType����ʾһ��Ԫ���ǲ��������ͻ�������͵��������ͣ�
	   ParameterizedType:��ʾһ�ֲ����������ͣ�List<Students>
	   TypeVariable:�������ͱ����Ĺ����ӿڣ�
	   WildcardType:����һ��ͨ������ͱ��ʽ��*/
	public static void test3()throws Exception{
		try {
			//���ָ�����������ķ�����Ϣ
			//���ָ��������
			Method m=TextReflection.class.getMethod("aa", Map.class,List.class);
			//���ָ������ �Ĳ������ͣ�һ�����������ж������������Ϊһ�����飻
			Type[] t=m.getGenericParameterTypes();
			for(Type paramType:t) {
				//��ӡ�ò�������
				System.out.println("#"+paramType);
				//�ǲ��ǲ�������
				if(paramType instanceof ParameterizedType) { 
					Type[] genericTypes=((ParameterizedType) paramType).getActualTypeArguments();
					//�ǵĻ���ǿ��תΪ�����͵Ĳ������ͣ�����������Ĳ������ͣ�
					for(Type genericType:genericTypes) {
						System.out.println("��������"+genericType);
					}
				}
			}
			System.out.println("@@@@@@@@@@@@@@@@@@");
			//���ָ����������ֵ�ķ�����Ϣ
			//���ָ������
			//���ָ������ �ķ���ֵ���ͣ�
			Method m2=TextReflection.class.getMethod("bb", null);
			Type returnType=m2.getGenericReturnType();
			if(returnType instanceof ParameterizedType) {
				Type[] genericTypes=((ParameterizedType) returnType).getActualTypeArguments();
				for(Type genericType:genericTypes) {
					System.out.println("����ֵ.��������"+genericType);
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
