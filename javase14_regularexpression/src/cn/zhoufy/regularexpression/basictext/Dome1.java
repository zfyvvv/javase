package cn.zhoufy.regularexpression.basictext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * 1.确认一个字符串是否符合正则表达式
 * 2.按指定格式分组；
 * 3.分组代码优化，使用循环；
 * 4.替换；
 * 5.网络爬虫：给我一台电脑，下载整个世界；
 *   获取网络页面的整个信息；然后通过正则表达式进行选择；
 * 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dome1 {
	public static void main(String[] args) {
		test4();
		
	}
	
	//确认一个字符串是否符合正则表达式
	public static void test1() {
       //一个字符串，是否符合指定的正则表达式
	   //指定正则表达式
		Pattern p=Pattern.compile("\\w+");
		//需要匹配对象及具体字符串，并进行关联；尝试匹配整个区域！
		Matcher m=p.matcher("123&&456abc");
		//调用匹配对象的结果，
		boolean flag=m.matches();
		System.out.println(flag);
	}
	
	//对指定正则表达式进行分组；
	public static void test2() {
		Pattern p=Pattern.compile("\\w+");
		//需要匹配对象及具体字符串，并进行关联；尝试匹配整个区域！
		Matcher m=p.matcher("123&&456abc");
		
		System.out.println(m.find());
		System.out.println(m.group());
		System.out.println(m.find());
		System.out.println(m.group());
		//分组的概念，下一个没有，
		System.out.println(m.find());
		//java.lang.IllegalStateException
		System.out.println(m.group());
	}
	
	//对指定正则表达式进行分组优化；
	public static void test3() {
        //正则表达式
		Pattern p=Pattern.compile("([a-z]+)([0-9]+)");
		//需要匹配对象及具体字符串，并进行关联；尝试匹配整个区域！
		Matcher m=p.matcher("abc123&&efg456**ikl78");
		while(m.find()) {
			System.out.println(m.group());//([a-z]+)([0-9]+)
			System.out.println(m.group(1));//([a-z]+)
			System.out.println(m.group(2));//([0-9]+)
	   }
	}
	
	//对指定正则表达式进行替换；replaceAll("!!") method!
	public static void test4() {
		Pattern p=Pattern.compile("([0-9]+)");
		//需要匹配对象及具体字符串，并进行关联；尝试匹配整个区域！
		Matcher m=p.matcher("abc123efg456ikl78");
		String mr=m.replaceAll("!!");
		//abc!!efg!!ikl!!
		System.out.println(mr);
	}
	
	//网络爬虫；
	public static void test5() {
		String dest=getUrlContext("http://www.163.com","gbk");
		System.out.println(dest);
		Pattern p=Pattern.compile("<a[\\s\\S]+?</a>");//取超链接的整个内容，
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
