package cn.zhoufy.regularexpression.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 1�����棻
 *   ��ȡ����ҳ���������Ϣ��Ȼ��ͨ��������ʽ����ѡ��
 * @author DELL
 *
 */
public class WebSpider {
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
	 
	public static List<String> getMatcherSubsring(String deststr,String regexstr){
		
		return null;
	}
	
	public static void main(String[] args) {
		String dest=getUrlContext("http://www.163.com","gbk");
		System.out.println(dest);
		Pattern p=Pattern.compile("<a[\\s\\S]+?</a>");//ȡ�����ӵ��������ݣ�
		Matcher m=p.matcher(dest);
		while(m.find()) {
			System.out.println(m.group());
		}
		
	}

}
