package cn.zhoufy.g.strategy;

public class NewBigSituation implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("newbigsituation!-->0.9");
		return standardPrice*0.9;
	}
	

}
