package com.zfy.btree;

/**
 * 1.二叉树接口；
 * 2.可以有不同的实现类，即每个类的可以使用不同的存储结构，比如顺序结构和链式结构；
 * @author DELL
 *
 */
public interface BinaryTree {
	
	public boolean isEmpty();
	public int size();
	public int getHeight();
	
	public Node findKey(int value);
		
	public void preOrderTraverse();
	public void inOrderTraverse();
	public void posOrderTraverse();	
	
	public void preOrderTraverse(Node node);
	
	public void preOrderByStack();
	public void inOrderByStack();
	public void posOrderByStack();	
	
	public void levelOrderByStack();	
	
	
	

}
