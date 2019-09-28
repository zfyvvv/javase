package cn.zfy.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1、实现comparator接口，重写compare()方法，
 *   比comparable接口更加灵活，解耦（独立于实体类），且方便应用于各种排序规则；
 *   在具体应用中可以实现匿名内部类；
 * 2、自定义排序的两种方法：
 *   实现java.lang.comparable接口，重写compareTo()方法；
 *   实现java.util.comparator接口，重写compare()方法（推荐）
 * 3、容器list中的元素不可排序，必须通过collections.sort()|collections.sort(list,comparator)进行排序；
 *   collections.sort(list,comparator)可以通过内部类进行实现；
 *   JDK已经提供可以排序的容器类；treeset和treemap；
 * @author DELL
 *
 */
public class test01 {
	public static void main(String[] args) {
		List list=new ArrayList<Goods>();
		list.add(new Goods("phone", 2000, 10));
		list.add(new Goods("pad", 1200, 5));
		list.add(new Goods("tv", 4000, 2));
		
		//通过外部单独实现类进行实现
		//Collections.sort(list, new FavComp());
		//通过内部类进行实现；实现时带上泛型；
		Collections.sort(list, new Comparator<Goods>() {
			@Override
			public int compare(Goods g1, Goods g2) {
				// TODO Auto-generated method stub
				return g1.getPrice()-g2.getPrice();
			}
		});
		System.out.println(list);
		
	}

}
