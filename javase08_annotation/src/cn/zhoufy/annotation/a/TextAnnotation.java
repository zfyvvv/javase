package cn.zhoufy.annotation.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1��ע���ʹ�ã�
 *  ����ʹ��ע�⣻������ʹ��ע�⣻
 * 2���Զ���ע�⣻
 * @author DELL
 *
 */
//ע������Ĭ��ֵ�Ŀ��Բ���д��
@SetAnnotation(name="zhoufy",age=18)
public class TextAnnotation {
	
	//һ��ע���е�ֵ����ȫд��
	@SetAnnotation(name="zhoufy",age=18,career="qc��ѧ")
	public void set() {
	}
	
	//һ��ע����ֻ��һ��ֵ
	@SetAnnotation2(value="aaaa")
	public void get() {
		
	}
	
	//ע����ֻ��һ��ֵʱ��value����ʡ�ԣ�
	@SetAnnotation2("aaaa")
	public void post() {
		
	}

}

/**
 * 1���Զ���ע�⣻
 *  ����ʹ�õ�Ŀ��
 * @author DELL
 *
 */
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SetAnnotation {
	String name();
	//��������Ĭ��ֵ��
	int age() default 0;
	String[] career() default {"��������ѧ","��Ͽ��ѧ","����ѧԺ"};
}


@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SetAnnotation2 {
	//�ⲻ��һ�������������Ǹ��ַ������飻
	String[] value();
}


