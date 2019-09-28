package cn.zfy.map1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 1、map的应用：分炼存储；+面向对象+处理（1：n）
 * 2、定义一个字符串letter类；
 * @author DELL
 *
 */
public class SetDeepMap01 {
	public static void main(String[] args) {
		String[] arr="this is a dog and this is a cat.".split(" ");
		Map<String,Letter> map=new HashMap<String,Letter>();
		for(String key:arr) {
			if(!map.containsKey(key)) {
			map.put(key, new Letter());}
			Letter l=map.get(key);
			int c=l.getCount();
			l.setCount(c+1);
		}
		Set<String> keyset=map.keySet();
		Iterator<String> keyIt=keyset.iterator();
		while(keyIt.hasNext()) {
			String l=keyIt.next();
			System.out.println(l+"--->"+map.get(l).getCount());
			System.out.println(map.get(l).getName());
		}
		
		
		
	}
	
}
