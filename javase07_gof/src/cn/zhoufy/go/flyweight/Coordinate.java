package cn.zhoufy.go.flyweight;
/**
 * 1.外部的状态一定要用单独的类来处理！
 * @author DELL
 *
 */
public class Coordinate {
	private int x,y;
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
