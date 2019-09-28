package cn.zfy.map2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 1��map��Ӧ�ã�
 * @author DELL
 *
 */


public class MpaDome01 {
	public static void main(String[] args) {
		List<Student> list=exam();
		Map<String,ClassRoom> map=count(list);
		view(map);

	}
	//��ȡmap����༶����ͨ���༶��String��ȡ����༶���Ӷ���ȡ�༶��������ԣ�
	//map�ı�����ʽ��
	public static void view(Map<String,ClassRoom> map) {
		Set<String> keyset=map.keySet();//���Ȼ��һ��SET��
		Iterator<String> keysIt=keyset.iterator();//Ȼ����SET�ĵ�������
		while(keysIt.hasNext()) {  //���ж�
			String no=keysIt.next();  //�ٻ��map��keyֵ��
			double total=map.get(no).getTotal();
			double avg=total/map.get(no).getStulist().size();
			System.out.println(no+"--->"+total+"--->"+avg+"--->"+map.get(no).getNo());//����keyֵ���valueֵ��
		}
		
	}
	
	//ͨ��map<String,ClassRoom>��һ���༶�����Զ�Ӧһ���༶����
	public static Map<String,ClassRoom> count(List<Student> list){
		Map<String,ClassRoom> map=new HashMap<String,ClassRoom>();
		for(Student stu:list) {
				String no=stu.getNo();//�༶//ÿһ��stu���������ݶ����д洢��
				double score=stu.getScore();//����
				ClassRoom croom=map.get(no);//�ȼ���༶���ڣ�����ָ��map��classroom;
				if(null==croom) {
					croom=new ClassRoom(no);//���û��croom���򴴽�һ���༶������༶���������
					map.put(no, croom);//���༶�źͰ༶����ӳ�䣻
				}
			croom.getStulist().add(stu);//�������croom��ֱ����croom��stulist�������ѧ����
			croom.setTotal(croom.getTotal()+score);//Ϊ�˼���ÿ���༶���ܷ֣��ֱ�ÿ��ѧ���ķ�����ӣ�
		}
		
		return map;
	}
	
	//ʹ�ö���student��װ���ݣ���ʽlist���ϣ�
	public static List<Student> exam(){
		List<Student> list=new ArrayList<Student>();
		list.add(new Student("�ܷ���","A",90));
		list.add(new Student("����","A",100));
		list.add(new Student("��","B",20));
		list.add(new Student("�ܷ�","B",40));
		list.add(new Student("����","B",30));
		return  list;
	}
	
}







