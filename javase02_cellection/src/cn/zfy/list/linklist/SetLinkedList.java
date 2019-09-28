package cn.zfy.list.linklist;

public class SetLinkedList {
	//开始节点；
	Node first;
	//尾节点；
	Node last;
	private int size;
	
	//增
	public void add(Object obj) {
		Node n=new Node();
		//当链表为null时，此时为第一个元素；
		if(first==null) {
			//第一个链表的前后链表都是Null：
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			//该链表的始元素和尾元素均为n；
			first=n;
			last=n;
		}else {
			//链表有元素时，此时当前节点n的前一个节点设置为链表的最后一个元素；;
			//链表有元素时，此时当前节点n的后一个节点即为null;
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			
			//整个链表的始节点还是为first；
			//整个链表的尾节点设置为n;
			last.setNext(n);
			last=n;
		}
		//链表的长度要++；
		   size++;
			}
	
	//查
	public Object get(int Index) {
		rangeCheck(Index);
		Node temp= null;		
		if(first!= null) {
			temp=first;
			for(int i=0;i<Index;i++) {
				temp = temp.next;
				         }
				}
		//存的时候，temp为null，说明只有一个元素；
		return temp.obj;
	}
	//获取集合大小；
	public int size() {
		return size;
	           }
	//判断索引越界；
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
