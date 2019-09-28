package cn.zfy.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 1、list的三种遍历方式；
 * 2、set的2种遍历方式；
 * 3、map的两种遍历方式；
 * @author DELL
 *
 */
public class Test01 {

	public static void main(String[] args) {
		/*List<String> list=new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		foreach(list);
		foreach2(list);
		itreatorFor(list);
		itreatorWhile(list);*/
		
		
	/*	Set<String> set=new HashSet<>();
		set.add("eee");
		set.add("fff");
		set.add("ggg");
		itreatorFor(set);
		itreatorWhile(set);*/
		
		
		Map<String, String> map=new HashMap<>();
		map.put("iii", "zfy");
		map.put("kkk", "zfyy");
		map.put("lll", "zfyyy");
//		iterator(map);
		iterator2(map);
		
	}
	
	//普通for循环；->list
	public static void foreach(List<?> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	//增强for循环；->list
	public static void foreach2(List<String> list) {
		for(String s:list) {
			System.out.println(s);
		}
		
	}
	
	//迭代器+for循环；->list
	public static void itreatorFor(List<String> list) {
		for(Iterator<String> iter=list.iterator();iter.hasNext();) {
			String temp=iter.next();
			System.out.println(temp);
		}
		
	}
	
	//迭代器+while循环；->list
	//可以进行元素的删除操作；
	public static void itreatorWhile(List<String> list) {
		Iterator<String> iter=list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		}
	
	//迭代器+for循环；->set
	public static void itreatorFor(Set<String> set) {
		for(Iterator<String> iter=set.iterator();iter.hasNext();) {
			String temp=iter.next();
			System.out.println(temp);
		}
		
	}
		
	//迭代器+while循环；->set
	public static void itreatorWhile(Set<String> set) {
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
			}
	
	//先获取keyset（键）的集合set，遍历set时获取value值；->map
	public static void iterator(Map<String, String> map) {
		Set<String> set=map.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String key=iter.next();
			System.out.println(key+"->"+map.get(key));
		}
		//和上面的区别；变量key是指向，而使用iter.next()是方法，是一个动作；已经执行了三次；
		//所以才会出现iii->zfyy，后面报空指针异常；
		/*while(iter.hasNext()) {
			System.out.println(iter.next()+"->"+map.get(iter.next()));
		}*/
	}
	
	//先获取entryset(键值对)的集合set，遍历entryset是获取entry，通过entry获取获取value值；->map
		public static void iterator2(Map<String, String> map) {
			Set<Entry<String, String>> set=map.entrySet();
			Iterator<Entry<String, String>> iter=set.iterator();
			while(iter.hasNext()) {
				Entry<String, String> entry=iter.next();
				System.out.println(entry.getKey()+"->"+entry.getValue());
			}
		}
	

}
