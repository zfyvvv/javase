package cn.zfy.exception;
/**
 * 1、出现异常；
 * 2、捕获异常；
 * @author DELL
 *
 */
public class Textexception {
	public static void main(String[] args) {
		try {
			//出现空指针异常；
			Computer a=null;
			a.star();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//下面提示出现异常；
			System.out.println("have catched the nullpoiterexception!");
		}
	
		
	}
	

}


class Computer{
	public void star() {
		System.out.println("这是一个计算机类！");
	}
}
