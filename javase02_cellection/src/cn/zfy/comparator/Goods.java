package cn.zfy.comparator;

public class Goods {
	private String name;
	private int price;
	private int fav;
	
	
	public Goods() {
		super();
	}

	public Goods(String name, int price, int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		
		return "商品："+name+"；     价格："+price+"；      喜爱度："+fav+";\n";
	}

}
