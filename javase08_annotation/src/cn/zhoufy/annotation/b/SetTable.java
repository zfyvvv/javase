package cn.zhoufy.annotation.b;
/**
 * 1-新建类的注解，value值为一个数组；
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {
	String[] value();
}
/**
 * 1.自定义table注解2；
 * @author DELL
 *
 */
@Target(value= {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SetTable2 {
	String value();
}

/**
 * 1-新建属性的注解，value值为多个类型；
 * @author DELL
 *
 */
@Target(value= {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface SetField {
	String columnName();
	String type();
	int length();
	
}