package cn.zfy.list;

import java.util.Iterator;

/**
 * Ŀ�ģ�������������ԭ��ʵ���ڲ����������
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
	 
	 //����صķ������кϲ���װ��
	 public Iterator iterator() {
		 //ͨ���ڲ������ʵ�֣���Ҳ��list��set��map�п��Ե���iterator�ı��ʣ�
		 //ÿ������ʵ�ֵķ�ʽ��һ�������ǹ���һ����
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
