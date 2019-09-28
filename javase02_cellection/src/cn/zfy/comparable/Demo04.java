package cn.zfy.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 1、测试自己写的Util类的使用；
 * @author DELL
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		//时间排序；
		Date[] arr= new Date[3];
		arr[0]=new Date();
		arr[1]=new Date(System.currentTimeMillis()-1000*3600);
		arr[2]=new Date(System.currentTimeMillis()+1000*3600);
		Utill.sort(arr);
		System.out.println(Arrays.toString(arr));
		//字符串排序；
		String[] arr2= {"abc","a","abcd","def"};
		Utill.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		//list中字符串排序；
		List list=new ArrayList();
		list.add("abc");
		list.add("a");
		list.add("de");
		list.add("abcd");
		Utill.sort(list);
		System.out.println(list);
		
		//list中字符串按指定规则进行排序；
		System.out.println("######################");
		String[] arr3=new String[] {"abc","a","abcd","df"};
		Utill.sort(arr3, new StringComp());
		System.out.println(Arrays.toString(arr3));
		
		List list2=new ArrayList();
		list2.add("abc");
		list2.add("a");
		list2.add("de");
		list2.add("abcd");
		Utill.sort(list2, new StringComp());
		System.out.println(list2);
		
}

}
