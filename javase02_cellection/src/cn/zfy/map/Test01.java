package cn.zfy.map;

public class Test01 {
	public static void main(String[] args) {
		SimpleMap se=new SimpleMap();
		//增
		se.add("lt", 28);
		se.add("lt1", 29);
		se.add("lt2", 26);
		se.add("lt3", 25);
		se.add("lt4", 20);
		//map大小
		System.out.println(se.getSize());
		//查；
		System.out.println(((SimpleEntry)se.get("lt")).getValue());
		//改
		System.out.println(((SimpleEntry)se.get("lt4")).getValue());
		se.set("lt4", 100);
		System.out.println("seted:"+((SimpleEntry)se.get("lt4")).getValue());
		//删
		se.remove("lt4");
		System.out.println(se.getSize());
		System.out.println("seted:"+((SimpleEntry)se.get("lt4")).getValue());
		
		
	}
}
