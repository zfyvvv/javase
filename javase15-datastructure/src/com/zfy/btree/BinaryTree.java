package com.zfy.btree;

/**
 * 1.�������ӿڣ�
 * 2.�����в�ͬ��ʵ���࣬��ÿ����Ŀ���ʹ�ò�ͬ�Ĵ洢�ṹ������˳��ṹ����ʽ�ṹ��
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
