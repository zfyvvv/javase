package cn.zhoufy.regularexpression.basictext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * 1.ȷ��һ���ַ����Ƿ����������ʽ
 * 2.��ָ����ʽ���飻
 * 3.��������Ż���ʹ��ѭ����
 * 4.�滻��
 * 5.�������棺����һ̨���ԣ������������磻
 *   ��ȡ����ҳ���������Ϣ��Ȼ��ͨ��������ʽ����ѡ��
 * 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dome1 {
	public static void main(String[] args) {
		test4();
		
	}
	
	//ȷ��һ���ַ����Ƿ����������ʽ
	public static void test1() {
       //һ���ַ������Ƿ����ָ����������ʽ
	   //ָ��������ʽ
		Pattern p=Pattern.compile("\\w+");
		//��Ҫƥ����󼰾����ַ����������й���������ƥ����������
		Matcher m=p.matcher("123&&456abc");
		//����ƥ�����Ľ����
		boolean flag=m.matches();
		System.out.println(flag);
	}
	
	//��ָ��������ʽ���з��飻
	public static void test2() {
		Pattern p=Pattern.compile("\\w+");
		//��Ҫƥ����󼰾����ַ����������й���������ƥ����������
		Matcher m=p.matcher("123&&456abc");
		
		System.out.println(m.find());
		System.out.println(m.group());
		System.out.println(m.find());
		System.out.println(m.group());
		//����ĸ����һ��û�У�
		System.out.println(m.find());
		//java.lang.IllegalStateException
		System.out.println(m.group());
	}
	
	//��ָ��������ʽ���з����Ż���
	public static void test3() {
        //������ʽ
		Pattern p=Pattern.compile("([a-z]+)([0-9]+)");
		//��Ҫƥ����󼰾����ַ����������й���������ƥ����������
		Matcher m=p.matcher("abc123&&efg456**ikl78");
		while(m.find()) {
			System.out.println(m.group());//([a-z]+)([0-9]+)
			System.out.println(m.group(1));//([a-z]+)
			System.out.println(m.group(2));//([0-9]+)
	   }
	}
	
	//��ָ��������ʽ�����滻��replaceAll("!!") method!
	public static void test4() {
		Pattern p=Pattern.compile("([0-9]+)");
		//��Ҫƥ����󼰾����ַ����������й���������ƥ����������
		Matcher m=p.matcher("abc123efg456ikl78");
		String mr=m.replaceAll("!!");
		//abc!!efg!!ikl!!
		System.out.println(mr);
	}
	
	//�������棻
	public static void test5() {
		String dest=getUrlContext("http://www.163.com","gbk");
		System.out.println(dest);
		Pattern p=Pattern.compile("<a[\\s\\S]+?</a>");//ȡ�����ӵ��������ݣ�
		Matcher m=p.matcher(dest);
		while(m.find()) {
			System.out.println(m.group());
		}
	}
	
	public static String getUrlContext(String urlString,String charSet) {
		 StringBuilder sb=new StringBuilder();
		try {
			URL url = new URL(urlString);
			BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream(),charSet));
			String temp="";
			while((temp=reader.readLine())!=null) {
				sb.append(temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}	
		
}
