package cn.zhoufy.go.bridge;
/**
 * 1.һ��ά�ȣ�����Ʒ�ƣ�
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