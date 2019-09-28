package cn.zfy.map2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 1、map的应用；
 * @author DELL
 *
 */


public class MpaDome01 {
	public static void main(String[] args) {
		List<Student> list=exam();
		Map<String,ClassRoom> map=count(list);
		view(map);

	}
	//获取map里面班级对象，通过班级号String获取对象班级，从而获取班级的相关属性；
	//map的遍历方式；
	public static void view(Map<String,ClassRoom> map) {
		Set<String> keyset=map.keySet();//首先获得一个SET，
		Iterator<String> keysIt=keyset.iterator();//然后获得SET的迭代器；
		while(keysIt.hasNext()) {  //再判断
			String no=keysIt.next();  //再获得map的key值，
			double total=map.get(no).getTotal();
			double avg=total/map.get(no).getStulist().size();
			System.out.println(no+"--->"+total+"--->"+avg+"--->"+map.get(no).getNo());//根据key值获得value值；
		}
		
	}
	
	//通过map<String,ClassRoom>，一个班级号属性对应一个班级对象；
	public static Map<String,ClassRoom> count(List<Student> list){
		Map<String,ClassRoom> map=new HashMap<String,ClassRoom>();
		for(Student stu:list) {
				String no=stu.getNo();//班级//每一个stu包含的数据都进行存储，
				double score=stu.getScore();//分数
				ClassRoom croom=map.get(no);//先假设班级存在，即是指向map的classroom;
				if(null==croom) {
					croom=new ClassRoom(no);//如果没有croom，则创建一个班级；并与班级号相关联；
					map.put(no, croom);//将班级号和班级进行映射；
				}
			croom.getStulist().add(stu);//如果存在croom，直接在croom的stulist里面放入学生；
			croom.setTotal(croom.getTotal()+score);//为了计算每个班级的总分，分别将每个学生的分数相加；
		}
		
		return map;
	}
	
	//使用对象student封装数据；形式list集合；
	public static List<Student> exam(){
		List<Student> list=new ArrayList<Student>();
		list.add(new Student("周方杨","A",90));
		list.add(new Student("刘婷","A",100));
		list.add(new Student("周","B",20));
		list.add(new Student("周方","B",40));
		list.add(new Student("周杨","B",30));
		return  list;
	}
	
}







