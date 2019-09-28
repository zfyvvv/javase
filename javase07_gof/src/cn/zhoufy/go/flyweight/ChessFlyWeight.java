package cn.zhoufy.go.flyweight;
/**
 * 1.内部状态使用享元类来处理！
 * @author DELL
 *
 */
public interface ChessFlyWeight {
	void setColor(String s);
	String getColor();
	void display(Coordinate c);
}

class ConcreteChess implements ChessFlyWeight{
	private String color;
	
	public ConcreteChess(String color) {
		super();
		this.color = color;
	}
	@Override
	public void setColor(String s) {
		this.color=s;
	}
	@Override
	public String getColor() {
		return color;
	}
	@Override
	public void display(Coordinate c) {
		System.out.println("yjse:"+color);
		System.out.println("wwvi:"+c.getX()+"\t"+c.getY());
	}
	
	
}
