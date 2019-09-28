package cn.zfy.url;
/**
 * URL:互联网资源的指针；
 * 1-创建方法：2种，绝对路径|相对路径；
 * 2常用方法：7个，获得协议|域名|端口|资源|锚点|参数|相对路径
 */
import java.net.MalformedURLException;
import java.net.URL;

public class UrlD1 {
	public static void main(String[] args) throws MalformedURLException {
		//绝对路径
		URL ur1=new URL("https://www.baidu.com:80/index.html#aa?uname=zhoufy");//有锚点：#aa
		//URL ur1=new URL("https://www.baidu.com:80/index.html?uname=zhoufy");//无锚点；
		System.out.println("协议--->"+ur1.getProtocol());
		System.out.println("域名--->"+ur1.getHost());
		System.out.println("资源--->"+ur1.getFile());
		System.out.println("相对路径--->"+ur1.getPath());
		System.out.println("端口--->"+ur1.getPort());
		System.out.println("锚点--->"+ur1.getRef());
		System.out.println("参数--->"+ur1.getQuery());//有锚点，则为空；无锚点，则有内容；
		//相对路径
		URL ur2=new URL("https://www.baidu.com/a/");
		URL ur3=new URL(ur2,"b.txt");
		System.out.println(ur3.toString());
		
		
	}

}
