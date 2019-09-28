package cn.zfy.map1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SetHashMap {
	public static void main(String[] args) {
		String[] arr="this is a cat and this is a dog that is belong to my".split(" ");
		Map<String,Letter> map=new HashMap<String,Letter>();
		for(String key:arr) {
			if(!map.containsKey(key)) {//判断是否包含这个建
				map.put(key, new Letter(key));
				}
			Letter value=map.get(key);//将包裹和KE相关联；
			value.setCount(value.getCount()+1);//没重复一次，包裹的属性count+1;
		
		}
		/*for(String key:arr) {
			if(!map.containsKey(key)) {//判断是否包含这个建
			map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);
			}*/
			/*Integer value=map.get(key);
			if(null==value) {
				map.put(key, 1);//不存在，就放1
			}else {
				map.put(key, value+1);
			}*/
			
			
		
		/*Set<String> keyset=map.keySet();
		Iterator<String> it=keyset.iterator();
		while(it.hasNext()) {
			String temp=it.next();
			System.out.println(temp+"--->"+map.get(temp));*/
		for(String key:arr) {
			Letter value=map.get(key);
			System.out.println(key+"--->"+value.getCount());
		}
		}
	}
	

	

	
	


