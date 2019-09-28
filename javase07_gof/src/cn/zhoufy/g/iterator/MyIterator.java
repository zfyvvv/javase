package cn.zhoufy.g.iterator;

public interface MyIterator {
	void fist();
	void next();
	boolean hasNext();
	
	boolean isFirst();
	boolean isLast();
	 
	Object getCurrentObject();
}
