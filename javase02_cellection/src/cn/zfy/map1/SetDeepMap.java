package cn.zfy.map1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *1、map的应用：分炼存储；+面向对象+处理（1：n）
 * @author DELL
 *
 */

public class SetDeepMap {

	public static void main(String[] args) {
		String[] arr="this is a dog and this is a cat.".split(" ");

		Map<String,Integer> map=new HashMap<String,Integer>();
		for(String key:arr) {
			//System.out.println(key);					
		if(!map.containsKey(key)) {
			map.put(key, 1);
		       }else {
		    	   map.put(key, map.get(key)+1);
		       }

	}
		Set<String> keySet=map.keySet();
		Iterator<String> it=keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			Integer value=map.get(key);
			System.out.println(key+"--->"+value);
		}
		}
}
