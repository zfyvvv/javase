package cn.zfy.map;

import java.util.LinkedList;
import java.util.List;

public class SimpleMap {
	//����һ���������飻
	LinkedList[] arr=new LinkedList[999];
	
	//����map�ĳ������ԣ�
	private int size;
	//�����ṩ��ȡ���ȵķ�����
	public int getSize() {
		return size;
	}
	
	//����
	public void add(Object key,Object value) {
		//������Ҫ�浽����ڵ�����Ķ���
		SimpleEntry e=new SimpleEntry(key,value);
		//��ȡhashcode��������������±ꣻ
		int index=key.hashCode()%999;
		//���жϸ��±�������Ƿ���ڣ�
		  //�������ڣ�����±������ĵ�һ��Ԫ�ؾ͸ö����൱�����������һ��SimpleEntry����
		  //������ֱ��������������ϸö��󣻲�����Ҫ�ж�key��ֵ�Ƿ��ظ���
		    //��û���ظ�������������SimpleEntry����
		    //���ظ����򸲸�ԭ����valueֵ��
		if(arr[index]==null) {
			//LinkedList�ķ�����JDK�Ѿ�ʵ�֣�
			LinkedList list=new LinkedList<>();
			arr[index]=list;
			list.add(e);
			size++;
		}else {
			LinkedList list=arr[index];
			//ȷ���Ƿ�����ͬ��key;
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					e2.setValue(value);
					return;
				}
			}
			//û����ͬ��key����ֱ������������������SimpleEntry����
			arr[index].add(e);
			size++;
		}
	}
	//��
	//ͨ��key��hashcode��ѯ����������arr[];Ȼ�����arr[]���飬ͨ��key��equals()�����ҵ�value��
	public Object get(Object key) {
		int index=key.hashCode()%999;
		if(arr[index]!=null) {
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					return list.get(i);
				}
			}
		}
		//�������ˣ�û���ҵ�����null|arr[index]=null�������null��
		return null;
	}
	
	//ɾ��
	//���ҵ�����ɾ����
	public void remove(Object key) {
		int index=key.hashCode()%999;
		if(arr[index]!=null) {
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					list.remove(i);
					size--;
				}
			}
		}
		
	}
	
	//��
	//���ҵ�������ģ�
	public void set(Object key,Object value) {
		int index=key.hashCode()%999;
		if(arr[index]!=null) {
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++) {
				SimpleEntry e2=(SimpleEntry) list.get(i);
				if(e2.getKey().equals(key)) {
					e2.setValue(value);
				}
			}
		}
		
	}
	
	
	

}

//����entryʵ����󣻷�װkey��value��
class SimpleEntry{
	private Object key;
	private Object value;
	public SimpleEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
