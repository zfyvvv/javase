package javase18_math;

import java.util.Scanner;

public class Function {
	
	private double a;
	private double b;
	private double c;
	private Root root=new Root();
	
	//ax2+bx+c=0;
	/**
	 * 求根公式；
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private Root getRoot(double a,double b,double c) {
		
		//Root root=new Root();
		root.setDianlta(b*b-4*a*c);
		if(root.getDianlta()>0) {
			root.setFlag(2);
			root.setMsg("该方程有有两个不同的根！");
			double sqrt=Math.sqrt(root.getDianlta());
			double son1=-b+sqrt;
			double son2=-b-sqrt;
			double mother=2*a;
			root.setX1(son1/mother);
			root.setX2(son2/mother);
		}else if(root.getDianlta()==0){
			root.setFlag(1);
			root.setMsg("该方程只有一个根！");
			double son=-b;
			double mother=2*a;
			root.setX1(son/mother);
			root.setX2(root.getX1());
		}else {
			root.setFlag(0);
			root.setMsg("该方程在实数范围内没有根！");
		}
		return root;
	}
	
	public static void main(String[] args) {
		Function fun=new Function();
		System.out.println("请输入函数的参数a：");
		Scanner sa=new Scanner(System.in);
		fun.setA(sa.nextDouble());
		System.out.println("请输入函数的参数b：");
		Scanner sb=new Scanner(System.in);
		fun.setB(sb.nextDouble());
		System.out.println("请输入函数的参数c：");
		Scanner sc=new Scanner(System.in);
		fun.setC(sc.nextDouble());
		System.out.println("该一元二次函数为："+(int)fun.getA()+"x*x+"+(int)fun.getB()+"x+"+(int)fun.getC()+"=0");
		Root root=fun.getRoot(fun.getA(), fun.getB(), fun.getC());

		if(root.getFlag()==2) {
			System.out.println("dianlta的值为："+root.getDianlta());
			System.out.println(root.getMsg());
			System.out.println("该方程的两个根分别为："+root.getX1()+"和"+root.getX2());
		}else if(root.getFlag()==1) {
			System.out.println("dianlta的值为："+root.getDianlta());
			System.out.println(root.getMsg());
			System.out.println("该方程的一个根为："+root.getX1());
		}else {
			System.out.println("dianlta的值为："+root.getDianlta());
			System.out.println(root.getMsg());
		}
		
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	
	
	

}
