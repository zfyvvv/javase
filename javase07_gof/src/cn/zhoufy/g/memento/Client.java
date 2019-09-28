package cn.zhoufy.g.memento;

public class Client {
	public static void main(String[] args) {
		CakeTaker ct=new CakeTaker();
		Emp emp=new Emp("zfy",28,1200);
		System.out.println("1-->"+emp.getName()+"-->"+emp.getAge()+"-->"+emp.getSalary());
		//EmpMemento mmo=emp.memento();
		ct.setMemento(emp.memento());//设置备忘点,设置成CakeTaker的一个属性；
		
		emp.setName("lt");
		emp.setAge(20);
		emp.setSalary(5200);
		System.out.println("2-->"+emp.getName()+"-->"+emp.getAge()+"-->"+emp.getSalary());//已更改
		emp.recoverEmp(ct.getMemento());//把这个对象的每个属性恢复都ct.getMemento()代表的的状态！
		System.out.println("3-->"+emp.getName()+"-->"+emp.getAge()+"-->"+emp.getSalary());
		
		
	}

}
