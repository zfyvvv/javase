package cn.zfy.list.linklist;

public class SetLinkedList {
	//��ʼ�ڵ㣻
	Node first;
	//β�ڵ㣻
	Node last;
	private int size;
	
	//��
	public void add(Object obj) {
		Node n=new Node();
		//������Ϊnullʱ����ʱΪ��һ��Ԫ�أ�
		if(first==null) {
			//��һ�������ǰ��������Null��
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			//�������ʼԪ�غ�βԪ�ؾ�Ϊn��
			first=n;
			last=n;
		}else {
			//������Ԫ��ʱ����ʱ��ǰ�ڵ�n��ǰһ���ڵ�����Ϊ��������һ��Ԫ�أ�;
			//������Ԫ��ʱ����ʱ��ǰ�ڵ�n�ĺ�һ���ڵ㼴Ϊnull;
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			
			//���������ʼ�ڵ㻹��Ϊfirst��
			//���������β�ڵ�����Ϊn;
			last.setNext(n);
			last=n;
		}
		//����ĳ���Ҫ++��
		   size++;
			}
	
	//��
	public Object get(int Index) {
		rangeCheck(Index);
		Node temp= null;		
		if(first!= null) {
			temp=first;
			for(int i=0;i<Index;i++) {
				temp = temp.next;
				         }
				}
		//���ʱ��tempΪnull��˵��ֻ��һ��Ԫ�أ�
		return temp.obj;
	}
	//��ȡ���ϴ�С��
	public int size() {
		return size;
	           }
	//�ж�����Խ�磻
	private void rangeCheck(int index) {
			if(index<0||index>=size) {
				try {
					throw new Exception();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}
	
	public static void main(String[] args) {
			SetLinkedList list=new SetLinkedList();
			list.add("aaaa");
			/*list.add("bbbb");
			list.add("cccc");
			list.add("ddddddddddd");*/
			System.out.println(list.size());
			System.out.println(list.get(0));
         
			
	}

	
}
