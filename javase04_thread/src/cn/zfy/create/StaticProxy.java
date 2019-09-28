package cn.zfy.create;
/**
 * 1-静态代理，
 * 2-真实角色：
 * 3-代理角色：持有真实角色的引用；
 * 4-两个类具有相同的接口；
 * 
 * @author DELL
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		People p=new People();
		//表面看似company的结婚，实际是给people进行结婚
		//但是作为调用者的我们，是不知道people的具体过程的，只和company进行接触；
		Company c=new Company(p);//如果传递的对象不为空，就运行传递的对象的方法；
		c.getMarry();
	}
}

/**
 * 1、接口，两个代理共同的接口；
 * @author DELL
 *
 */
interface Marry{
	void getMarry();
}

/**
 * 1、真实对象；
 * @author DELL
 *
 */
class People implements Marry{
	@Override
	public void getMarry() {
		System.out.println("我可以结婚了！！！");
		
	}
} 
/**
 * 1、代理对象；持有真实对象的引用；
 * @author DELL
 *
 */
class Company implements Marry{
	private People you;
	
	public Company() {
		super();
	}

	public Company(People you) {
		super();
		this.you = you;
	}
	public void before() {
		System.out.println("before......");
	}
	public void after() {
		System.out.println("after.............");
	}
	@Override
	public void getMarry() {
		before();
		you.getMarry();
		after();
	}
}


