package cn.zfy.comparable;
/**
 * 1、常见数值大小比较;
 * 2、java内置元素大小的比较；
 * 3、java的内置元素都实现了java.lang.comparable接口；
 * 	    该接口中只有一个方法public int compareTo(object obj),返回值为一个int类型；
 *    int=0，表示this=obj;int>0，表示this>obj;int<0，表示this<obj;
 * 4、实现接口，，通过compareTo()进行排序，方法里面的实现可以是概率对象的一个属性;
 *    工人的工资，新闻的热度，学生的分数；
 * @author DELL
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		int i=2;
		int j=3;//数值大小
		Character ch='a';
		Character ch2='b';//Unicode
		String str1="abc";
		String str2="abd";
		String str3="abddefg";//先按顺序比较Unicode码，如果为起始位置子串，则返回长度差；
		System.out.println(ch.compareTo(ch2));
		System.out.println(str1.compareTo(str2));
		System.out.println(str2.compareTo(str3));
	}

}
