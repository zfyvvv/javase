package cn.zhoufy.annotation.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1、注解的使用；
 *  类上使用注解；方法上使用注解；
 * 2、自定义注解；
 * @author DELL
 *
 */
//注解中有默认值的可以不用写；
@SetAnnotation(name="zhoufy",age=18)
public class TextAnnotation {
	
	//一般注解中的值必须全写，
	@SetAnnotation(name="zhoufy",age=18,career="qc大学")
	public void set() {
	}
	
	//一般注解中只有一个值
	@SetAnnotation2(value="aaaa")
	public void get() {
		
	}
	
	//注解中只有一个值时，value可以省略；
	@SetAnnotation2("aaaa")
	public void post() {
		
	}

}

/**
 * 1、自定义注解；
 *  定义使用的目标
 * @author DELL
 *
 */
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SetAnnotation {
	String name();
	//可以设置默认值；
	int age() default 0;
	String[] career() default {"大连理工大学","三峡大学","美的学院"};
}


@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SetAnnotation2 {
	//这不是一个方法，而是是个字符串数组；
	String[] value();
}


