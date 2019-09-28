package cn.zhoufy.gof.builder;
/**
 * 1.构建者模式：构造复杂对象时，并且对象的构造过程有一定的顺序，
 * 2.将构造和装配过程分离；分别提供；
 * 3.装配负责将对象几个模块装配起来；而对象的几个模块分别在其他的地方构造；（使用接口，将设计和实现分离！）
 * 4.并不多见；
 * 5.过程：
 *     指定具体的homeBuilder-->产生具体的模块-->装配具体的对象-->获得所需对象
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		Home h=new ZfyHomeDirector(new ZfyHomeBuilder()).directHome();
		h.getCar();
		h.getHou();
		h.getMon();
		System.out.println(h.getMon().getName());
	}

}
