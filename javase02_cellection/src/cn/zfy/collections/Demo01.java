package cn.zfy.collections;
/**
 * 1、使用Collections工具类的对集合的操作；
 * 2、对其他对象的按指定规则进行排序；
 * 3、模拟斗地主发牌；
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo01 {
	public static void main(String[] args) {
		/*List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(9);
		list.add(2);
		list.add(5);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);*/
		
		//对其他实体类按照指定规则排序；
		List<Goods> list=new ArrayList<Goods>();
		list.add(new Goods("b",80,500));
		list.add(new Goods("a",100,600));
		list.add(new Goods("c",110,300));
		list.add(new Goods("d",60,900));
	
		System.out.println(list);
		System.out.println("the sort by price|fav depend by you!!");
		Collections.sort(list);
		System.out.print(list);
		
		
		
	    //模拟发牌；
		/*List<Integer> cards=new ArrayList<Integer>();
		for(int i=1;i<=54;i++) {
			cards.add(i);
		}
		List<Integer> p1=new ArrayList<Integer>();
		List<Integer> p2=new ArrayList<Integer>();
		List<Integer> p3=new ArrayList<Integer>();
		List<Integer> last=new ArrayList<Integer>();
		Collections.shuffle(cards);
		for(int i=1;i<51;i+=3) {
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		System.out.println("第一个人："+p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(last);*/
	
}
}


class Goods implements Comparable<Goods>{
	private String name;
	private int price;
	private int fav;
	public Goods(String name, int price,int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav=fav;
	}
	
	
	@Override
	public int compareTo(Goods o) {
		// TODO Auto-generated method stub
		//按价格升序排列；
		//return this.price-o.price;
		//按价格降序排列；
		return o.fav-this.fav;
	}
	
	
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", fav=" + fav + "]";
	}
	
	
	
	
	
}
