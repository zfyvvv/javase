package cn.zfy.map1;

import java.util.HashMap;
import java.util.Map;
/**
 * 1��map�ļ�ʹ�ã��ײ�ԭ��������+����
 *    ����Ϊentry[]��������±�Ϊhashcode�������д�������󣻸�����Ϊ�������飻
 *    �����д����Ȼ���key��value�洢�ڶ����value��ȥ��
 * @author DELL
 *
 */
public class TextMap {
	public static void main(String[] args) {
		Map map= new HashMap();
		map.put("�ܷ���", new Wife("����"));
		Wife w= (Wife) map.get("�ܷ���");
		System.out.println(w.name);		
	}

}

class Wife{
	String name;
	public Wife(String name) {
		this.name =name;
	}
}
