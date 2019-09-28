package cn.zhoufy.g.iterator;
/**
 * 1.和聚合类的性质很相关，List和Set中均单独实现！
 */
import java.util.ArrayList;
import java.util.List;

public class MyConcreteAggregate {
	private List<Object> list;

	public MyConcreteAggregate(List<Object> list) {
		super();
		this.list = list;
	}
	public void addObject(Object obj) {
		this.list.add(obj);
	}
	public void removeObject(Object obj) {
		this.list.remove(obj);
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
	public MyConcreteIterator getConcreteIterator() {
		return new MyConcreteIterator();
	}
	//内部类，对外提供调用的方法；可以写成内部匿名类！
	private class MyConcreteIterator implements MyIterator{
		private int cursor=0;
		@Override
		public void fist() {
			cursor=0;
		}

		@Override
		public void next() {
			cursor++;
		}

		@Override
		public boolean hasNext() {
			if(cursor<list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isFirst() {
			return cursor==0?true:false;
		}

		@Override
		public boolean isLast() {
			return cursor==(list.size()-1)?true:false;
		}
		@Override
		public Object getCurrentObject() {
			return list.get(cursor);
		}
		
	}
	

}
