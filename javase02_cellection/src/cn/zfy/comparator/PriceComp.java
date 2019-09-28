package cn.zfy.comparator;
/**
 * 1、按价格排序的类；
 * @author DELL
 *
 */
public class PriceComp implements java.util.Comparator<Goods>{

	@Override
	public int compare(Goods o1, Goods o2) {
		return o1.getPrice()-o2.getPrice();
	}

	



}
