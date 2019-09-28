package cn.zfy.map1;

import java.util.HashMap;
import java.util.Map;
/**
 * 1、map的简单使用；底层原理是数组+链表；
 *    数组为entry[]，数组的下标为hashcode，数组中存链表对象；该数组为链表数组；
 *    链表中存对象，然后把key和value存储在对象的value中去；
 * @author DELL
 *
 */
public class TextMap {
	public static void main(String[] args) {
		Map map= new HashMap();
		map.put("周方杨", new Wife("刘婷"));
		Wife w= (Wife) map.get("周方杨");
		System.out.println(w.name);		
	}

}

class Wife{
	String name;
	public Wife(String name) {
		this.name =name;
	}
}
