package cn.zfy.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
/**
 * 1、list的使用；
 *   增删改查；遍历；大小；
 * @author DELL
 *
 */
public class Test01 {
	public static void main(String[] args) {
	List list=new ArrayList();
	list.add("aaaa");
	list.add("bbbb");
	list.add(1234);
	list.add(5896);
	list.add(new Dog());
	list.add(new Date());
	list.set(1, "cccc");
	/*System.out.println(list.isEmpty());
	System.out.println(list.size());
	System.out.println(list.indexOf(5896));
	System.out.println(list.get(2));
	list.remove("bbbb");
	System.out.println(list.size());
	list.remove(3);
	System.out.println(list.size());*/
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
	

}
}
class Dog{
    	  private String name;
    	  private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Dog() {
			super();
		}
	
    	  
    	  
    	  
	
}