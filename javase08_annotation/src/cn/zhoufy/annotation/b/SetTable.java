package cn.zhoufy.annotation.b;
/**
 * 1-�½����ע�⣬valueֵΪһ�����飻
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
 * 1.�Զ���tableע��2��
 * @author DELL
 *
 */
@Target(value= {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SetTable2 {
	String value();
}

/**
 * 1-�½����Ե�ע�⣬valueֵΪ������ͣ�
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