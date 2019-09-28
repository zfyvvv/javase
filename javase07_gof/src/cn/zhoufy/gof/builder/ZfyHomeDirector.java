package cn.zhoufy.gof.builder;

public class ZfyHomeDirector implements HomeDirector{//����װ�䣬
	private HomeBuilder homeBuilder;
	
	public ZfyHomeDirector(HomeBuilder homeBuilder) {//��ù�������
		this.homeBuilder = homeBuilder;
	}


	@Override                         
	public Home directHome() {      //ͨ��ָ�������homeBuilder-->���������ģ��-->װ�����Ķ���-->����������
		House hh=homeBuilder.buildeHouse();//������������ģ��
		Car hc=homeBuilder.builderCar();//������������ģ��
		Money hm=homeBuilder.builderMoney();//������������ģ��
		
		Home h=new Home();//������װ�伸��ģ�飻
		h.setHou(hh);
		h.setCar(hc);
		h.setMon(hm);
		return h;
	}


	
}
