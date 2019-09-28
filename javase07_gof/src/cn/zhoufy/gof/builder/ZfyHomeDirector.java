package cn.zhoufy.gof.builder;

public class ZfyHomeDirector implements HomeDirector{//具体装配，
	private HomeBuilder homeBuilder;
	
	public ZfyHomeDirector(HomeBuilder homeBuilder) {//获得构造器，
		this.homeBuilder = homeBuilder;
	}


	@Override                         
	public Home directHome() {      //通过指定具体的homeBuilder-->产生具体的模块-->装配具体的对象-->获得所需对象
		House hh=homeBuilder.buildeHouse();//构造器生产的模块
		Car hc=homeBuilder.builderCar();//构造器生产的模块
		Money hm=homeBuilder.builderMoney();//构造器生产的模块
		
		Home h=new Home();//给对象装配几个模块；
		h.setHou(hh);
		h.setCar(hc);
		h.setMon(hm);
		return h;
	}


	
}
