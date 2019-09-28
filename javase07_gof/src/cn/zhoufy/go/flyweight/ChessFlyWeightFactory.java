package cn.zhoufy.go.flyweight;
/**
 * 1.��Ԫ���������Ը��ö����Դͷ��
 * 2.����һ��Ҫ��Map������
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
