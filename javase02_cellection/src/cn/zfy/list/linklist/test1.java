package cn.zfy.list.linklist;

import java.util.ArrayList;
import java.util.List;
/**
 * 1��һ�������⣻
 * @author DELL
 *
 */
public class test1 {

	public static void main(String[] args) {
		List list=new ArrayList<String>();
		list.add("zfy");
		//list.add("lt");
		list.add(2, "aa");
		//�����ȴ��ȡ�������������죻 java.lang.IndexOutOfBoundsException: Index: 2, Size: 1
		//list.add(4, "bb");
		//System.out.println(list.get(3));
		
	}
}
