package cn.zfy.list;

import java.util.Iterator;

/**
 * 目的：深入理解迭代器原理，实现内部类和匿名类
 * @author DELL
 *
 */
public class SetDeepList {
	 private String[] elem={"a","b","c"};
	 private int size =elem.length;
	 private int coursor=-1;
	 
	 public int size() {
		 return this.size;
	 }
	 
	 //public Iterator iterator1() {
		// return new MyIter();
	// }
	 
	 //将相关的方法进行合并封装；
	 public Iterator iterator() {
		 //通过内部类进行实现，这也是list，set，map中可以调用iterator的本质；
		 //每个容器实现的方式不一样，但是功能一样；
		 return new Iterator() {
			 public boolean hasNext() {
				 	 return coursor+1<size;
			 }
			public String next() {
				coursor++;
				return elem[coursor];
			}
			public void remove() {
				System.arraycopy(elem, coursor+1, elem, coursor, SetDeepList.this.size-(coursor+1));			
				SetDeepList.this.size--;
				coursor--;
			}
		 };
			 }			 
	 

	 
	public static void main(String[] args) {
		SetDeepList list=new SetDeepList();
		Iterator it=list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("----------------!");
		
		it=list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("----------------!");
		
		}
	
}
