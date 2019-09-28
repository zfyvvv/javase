package cn.zhoufy.go.bridge;
/**
 * 1.一个维度：电脑品牌！
 * @author DELL
 *
 */
public interface Brand {
	void getBrand();
}
class Lenovo implements Brand{

	@Override
	public void getBrand() {
		System.out.println("lenovo");
	}
}
class Dell implements Brand{
	@Override
	public void getBrand() {
		System.out.println("dell");
	}
}
class Mi implements Brand{

	@Override
	public void getBrand() {
		System.out.println("mi");
	}
}