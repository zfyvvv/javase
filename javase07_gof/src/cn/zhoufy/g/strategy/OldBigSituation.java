package cn.zhoufy.g.strategy;

public class OldBigSituation implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("oldbigsituation!-->0.5");
		return standardPrice*0.5;
	}
	

}
