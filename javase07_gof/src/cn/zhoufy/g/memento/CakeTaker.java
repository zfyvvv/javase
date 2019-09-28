package cn.zhoufy.g.memento;

import java.util.ArrayList;
import java.util.List;

public class CakeTaker {
	private EmpMemento memento;//设置成属性，方便管理！通过list可以设置多个备忘点！
	
	//private List<EmpMemento> list=new ArrayList<EmpMemento>();从而可以恢复到之前的状态！

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}
	
	
	

}
