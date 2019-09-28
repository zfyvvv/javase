package cn.zfy.comparator;



/**
 * 1、按喜好排序的类；
 * @author DELL
 *
 */
public class FavComp implements java.util.Comparator<Goods>{

	@Override
	public int compare(Goods o1, Goods o2) {
		return o1.getFav()-o2.getFav();
	}

	



}
