package cn.zhoufy.go.bridge;
/**
 * 1.一个维度：电脑样式；
 * @author DELL
 *
 */
public class Computer {
	protected Brand brand;
	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}
	public void sale() {
		System.out.println("computer");
		brand.getBrand();
	}
}
class Laptop extends Computer{
	public Laptop(Brand brand) {
		super(brand);
	}
	public void sale() {
		System.out.println("laptop!");
		brand.getBrand();
	}
}
class Desklop extends Computer{

	public Desklop(Brand brand) {
		super(brand);
	}
	public void sale() {
		System.out.println("desklop");
		brand.getBrand();
	}
	
}
