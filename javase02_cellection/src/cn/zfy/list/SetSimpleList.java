package cn.zfy.list;
/**
 * 1、深入理解迭代器原理；
 *  数组中的长度是属性；list中的长度是一个方法；
 * @author DELL
 *
 */
public class SetSimpleList {
	 private String[] elem={"a","b","c"};
	 private int size =elem.length;
	 private int coursor=-1;
	 
	 //list中方法的本质还是数组的长度属性；
	 public int size() {
		 return this.size;
	 }
	 //判断是否有下一个是通过游标和字符串数组的长度进行比较；
	 //游标小于长度，则有；
	 public boolean hasNext() {
		 	 return coursor+1<size;
	 }
	 
	 //游标+1，并返回该下标的数组元素；
	public String next() {
		coursor++;
		return elem[coursor];
	}
	
	 //remove的本质还是数组的移动操作；移除后size和游标都-1；
	public void remove() {
		//[2,6,5,7]->[2,5,7]
		//源数组为4个元素，新数组为3个元素，从游标位置开始挪动，游标前面的元素不用理会；
		//当游标为1时，即新数组的第二元素是旧数组的第三个元素（coursor+1），需要移动元素的数目是2个（4-2）
		System.arraycopy(elem, coursor+1, elem, coursor, this.size-(coursor+1));			
		this.size--;
		this.coursor--;
	}

	public static void main(String[] args) {
		SetSimpleList list=new SetSimpleList();
		if(list.hasNext()) {
		System.out.println(list.next());
		list.remove();
		}
		if(list.hasNext()) {		
			System.out.println(list.next());
			list.remove();               }
		
		if(list.hasNext()) {
			System.out.println(list.next());
			list.remove();                             }
		
		if(list.hasNext()) {
			System.out.println(list.next());
			list.remove();                              }
		
		System.out.println(list.size());
		}
	
}
