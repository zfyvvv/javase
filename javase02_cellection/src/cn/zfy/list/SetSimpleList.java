package cn.zfy.list;
/**
 * 1��������������ԭ��
 *  �����еĳ��������ԣ�list�еĳ�����һ��������
 * @author DELL
 *
 */
public class SetSimpleList {
	 private String[] elem={"a","b","c"};
	 private int size =elem.length;
	 private int coursor=-1;
	 
	 //list�з����ı��ʻ�������ĳ������ԣ�
	 public int size() {
		 return this.size;
	 }
	 //�ж��Ƿ�����һ����ͨ���α���ַ�������ĳ��Ƚ��бȽϣ�
	 //�α�С�ڳ��ȣ����У�
	 public boolean hasNext() {
		 	 return coursor+1<size;
	 }
	 
	 //�α�+1�������ظ��±������Ԫ�أ�
	public String next() {
		coursor++;
		return elem[coursor];
	}
	
	 //remove�ı��ʻ���������ƶ��������Ƴ���size���α궼-1��
	public void remove() {
		//[2,6,5,7]->[2,5,7]
		//Դ����Ϊ4��Ԫ�أ�������Ϊ3��Ԫ�أ����α�λ�ÿ�ʼŲ�����α�ǰ���Ԫ�ز�����᣻
		//���α�Ϊ1ʱ����������ĵڶ�Ԫ���Ǿ�����ĵ�����Ԫ�أ�coursor+1������Ҫ�ƶ�Ԫ�ص���Ŀ��2����4-2��
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
