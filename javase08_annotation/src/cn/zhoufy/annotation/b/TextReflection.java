package cn.zhoufy.annotation.b;
/**
 * 3-ʹ�÷�����ע����Ϣ��
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TextReflection {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		try {
			Class clazz=Class.forName("cn.zhoufy.annotation.b.Students");
			Annotation[] annotations=clazz.getDeclaredAnnotations();//
			//��ø��������ע�⣻
			for(Annotation temp:annotations) {
				System.out.println(temp);
			}
			//��ø���ָ����ע�⣻
			SetTable st=(SetTable) clazz.getAnnotation(SetTable.class);
			//���ע���valueֵ��//��һ�����飻
				System.out.println(st.value());
				//����������������������
				System.out.println(st.value()[0]);
				//��ø���ָ����ע�⣻
				SetTable2 st2=(SetTable2) clazz.getAnnotation(SetTable2.class);
				//���ע���valueֵ��
				System.out.println(st2.value());
				
				//��ø���ָ��������
				Field f=clazz.getDeclaredField("name");
				//��ø���ָ�����Ե�ע�⣻
				SetField sf=f.getAnnotation(SetField.class);
				//ָ�����Ե�ע������ԣ�
				System.out.println(sf.columnName()+"-->"+sf.type()+"-->"+sf.length());
				//���ݻ�õı������ֶε���Ϣ��ƴ��DDL��䣬Ȼ��ʹ��JDBCִ�����SQL��䣬�����ݿ���������صı�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��ȡ�෴��ʧ�ܣ���");
		}
	}

}
