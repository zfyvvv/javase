package cn.zfy.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1��ʵ��comparator�ӿڣ���дcompare()������
 *   ��comparable�ӿڸ��������������ʵ���ࣩ���ҷ���Ӧ���ڸ����������
 *   �ھ���Ӧ���п���ʵ�������ڲ��ࣻ
 * 2���Զ�����������ַ�����
 *   ʵ��java.lang.comparable�ӿڣ���дcompareTo()������
 *   ʵ��java.util.comparator�ӿڣ���дcompare()�������Ƽ���
 * 3������list�е�Ԫ�ز������򣬱���ͨ��collections.sort()|collections.sort(list,comparator)��������
 *   collections.sort(list,comparator)����ͨ���ڲ������ʵ�֣�
 *   JDK�Ѿ��ṩ��������������ࣻtreeset��treemap��
 * @author DELL
 *
 */
public class test01 {
	public static void main(String[] args) {
		List list=new ArrayList<Goods>();
		list.add(new Goods("phone", 2000, 10));
		list.add(new Goods("pad", 1200, 5));
		list.add(new Goods("tv", 4000, 2));
		
		//ͨ���ⲿ����ʵ�������ʵ��
		//Collections.sort(list, new FavComp());
		//ͨ���ڲ������ʵ�֣�ʵ��ʱ���Ϸ��ͣ�
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
