package cn.zhoufy.g.memento;

public class Client {
	public static void main(String[] args) {
		CakeTaker ct=new CakeTaker();
		Emp emp=new Emp("zfy",28,1200);
		System.out.println("1-->"+emp.getName()+"-->"+emp.getAge()+"-->"+emp.getSalary());
		//EmpMemento mmo=emp.memento();
		ct.setMemento(emp.memento());//���ñ�����,���ó�CakeTaker��һ�����ԣ�
		
		emp.setName("lt");
		emp.setAge(20);
		emp.setSalary(5200);
		System.out.println("2-->"+emp.getName()+"-->"+emp.getAge()+"-->"+emp.getSalary());//�Ѹ���
		emp.recoverEmp(ct.getMemento());//����������ÿ�����Իָ���ct.getMemento()����ĵ�״̬��
		System.out.println("3-->"+emp.getName()+"-->"+emp.getAge()+"-->"+emp.getSalary());
		
		
	}

}
