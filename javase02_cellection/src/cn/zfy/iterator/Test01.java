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
 * 1��list�����ֱ�����ʽ��
 * 2��set��2�ֱ�����ʽ��
 * 3��map�����ֱ�����ʽ��
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
	
	//��ͨforѭ����->list
	public static void foreach(List<?> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	//��ǿforѭ����->list
	public static void foreach2(List<String> list) {
		for(String s:list) {
			System.out.println(s);
		}
		
	}
	
	//������+forѭ����->list
	public static void itreatorFor(List<String> list) {
		for(Iterator<String> iter=list.iterator();iter.hasNext();) {
			String temp=iter.next();
			System.out.println(temp);
		}
		
	}
	
	//������+whileѭ����->list
	//���Խ���Ԫ�ص�ɾ��������
	public static void itreatorWhile(List<String> list) {
		Iterator<String> iter=list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		}
	
	//������+forѭ����->set
	public static void itreatorFor(Set<String> set) {
		for(Iterator<String> iter=set.iterator();iter.hasNext();) {
			String temp=iter.next();
			System.out.println(temp);
		}
		
	}
		
	//������+whileѭ����->set
	public static void itreatorWhile(Set<String> set) {
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
			}
	
	//�Ȼ�ȡkeyset�������ļ���set������setʱ��ȡvalueֵ��->map
	public static void iterator(Map<String, String> map) {
		Set<String> set=map.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String key=iter.next();
			System.out.println(key+"->"+map.get(key));
		}
		//����������𣻱���key��ָ�򣬶�ʹ��iter.next()�Ƿ�������һ���������Ѿ�ִ�������Σ�
		//���ԲŻ����iii->zfyy�����汨��ָ���쳣��
		/*while(iter.hasNext()) {
			System.out.println(iter.next()+"->"+map.get(iter.next()));
		}*/
	}
	
	//�Ȼ�ȡentryset(��ֵ��)�ļ���set������entryset�ǻ�ȡentry��ͨ��entry��ȡ��ȡvalueֵ��->map
		public static void iterator2(Map<String, String> map) {
			Set<Entry<String, String>> set=map.entrySet();
			Iterator<Entry<String, String>> iter=set.iterator();
			while(iter.hasNext()) {
				Entry<String, String> entry=iter.next();
				System.out.println(entry.getKey()+"->"+entry.getValue());
			}
		}
	

}
