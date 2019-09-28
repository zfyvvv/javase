package cn.zhoufy.go.flyweight;
/**
 * 1.享元工厂，可以复用对象的源头！
 * 2.工厂一定要加Map容器！
 */
import java.util.HashMap;
import java.util.Map;

public class ChessFlyWeightFactory {
	private static Map<String,ChessFlyWeight> map=new HashMap<String,ChessFlyWeight>();
	public static ChessFlyWeight getChess(String color) {
		if(map.get(color)!=null) {
			return map.get(color);
	}else {
		ChessFlyWeight cfw=new ConcreteChess(color);
		map.put(color, cfw);
		return cfw;
		}
	}

}
