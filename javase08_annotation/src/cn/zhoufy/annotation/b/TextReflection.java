package cn.zhoufy.annotation.b;
/**
 * 3-使用反射获得注解信息；
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TextReflection {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		try {
			Class clazz=Class.forName("cn.zhoufy.annotation.b.Students");
			Annotation[] annotations=clazz.getDeclaredAnnotations();//
			//获得该类的所以注解；
			for(Annotation temp:annotations) {
				System.out.println(temp);
			}
			//获得该类指定的注解；
			SetTable st=(SetTable) clazz.getAnnotation(SetTable.class);
			//获得注解的value值；//是一个数组；
				System.out.println(st.value());
				//哈哈哈哈哈哈哈哈哈哈！
				System.out.println(st.value()[0]);
				//获得该类指定的注解；
				SetTable2 st2=(SetTable2) clazz.getAnnotation(SetTable2.class);
				//获得注解的value值；
				System.out.println(st2.value());
				
				//获得该类指定的属性
				Field f=clazz.getDeclaredField("name");
				//获得该类指定属性的注解；
				SetField sf=f.getAnnotation(SetField.class);
				//指定属性的注解的属性；
				System.out.println(sf.columnName()+"-->"+sf.type()+"-->"+sf.length());
				//根据获得的表明，字段的信息，拼出DDL语句，然后使用JDBC执行这个SQL语句，在数据库中生成相关的表；
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("获取类反射失败！！");
		}
	}

}
