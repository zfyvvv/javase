package com.zfy.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkBinaryTree implements BinaryTree{
	
	private Node root;
	/*private int height;
	private int size;*/
	
	
	public LinkBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	

	public LinkBinaryTree(Node root) {
		super();
		this.root = root;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root==null;
	}

	//��ȡ�ڵ������
	@Override
	public int size() {
		// TODO Auto-generated method stub
		System.out.print("the size of this btree is:");
		return this.size(root);
	}
	private int size(Node root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}else {
			//��ȡ��������size��
			int nl=this.size(root.getLeftChild());
			//��ȡ��������size��
			int nr=this.size(root.getRightChild());
			//��������������������sizeֻ�Ͳ�+1��
			return nl+nr+1;
		}
	}

	//��ȡ�߶ȣ�
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		System.out.print("the hieght of this btree is:");
		return this.getHeight(root);
		
	}
	private int getHeight(Node root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}else {
			//��ȡ�������ĸ߶ȣ�
			int nl=this.getHeight(root.getLeftChild());
			//��ȡ�������ĸ߶ȣ�
			int nr=this.getHeight(root.getRightChild());
			//�������������������ϴ�߶Ȳ�+1��
			return nl>nr?nl+1:nr+1;
		}
	}

	//����ĳԪ�أ�
	@Override
	public Node findKey(int value) {
		// TODO Auto-generated method stub
		return this.findKey(value,root);
	}
	private Node findKey(int value,Node root) {
		// TODO Auto-generated method stub
		if(root==null) {//�ݹ��������1
			return null;
		}else if(root!=null && (int)root.getData()==value) {//�ݹ��������2
			return root;
		}else {
			Node node1=this.findKey(value, root.getLeftChild());
			Node node2=this.findKey(value, root.getRightChild());
			if(node1!=null && (int)node1.getData()==value) {
				return node1;
			}else if(node2!=null && (int)node2.getData()==value) {
				return node2;
			}else {
				return null;
			}
			
		}
	}

	//ǰ�������
	@Override
	public void preOrderTraverse() {
		if(root!=null) {
			//1.������ڵ��ֵ��
			System.out.print(root.getData()+" ");
			//2.�������������������
				//����һ���������������������ĸ���
			BinaryTree leftTree=new LinkBinaryTree(root.getLeftChild());
			leftTree.preOrderTraverse();
			//3.�������������������
				//����һ���������������������ĸ���
			BinaryTree rightTree=new LinkBinaryTree(root.getRightChild());
			rightTree.preOrderTraverse();
		}
	}

	//���������
	@Override
	public void inOrderTraverse() {
		System.out.println("inOrderTraverse��");
		this.inOrderTraverse(root);
		System.out.println();
	}
	//���������������⹫����
	private void inOrderTraverse(Node root) {
		if(root!=null) {
			//1.�������������������
				//����һ���������������������ĸ���
			/*BinaryTree leftTree=new LinkBinaryTree(root.getLeftChild());
			leftTree.inOrderTraverse(root.getLeftChild());*/
			this.inOrderTraverse(root.getLeftChild());
			//2.������ڵ��ֵ��
			System.out.print(root.getData()+" ");
			//3.�������������������
				//����һ���������������������ĸ���
			//�����Ѿ���д������Ǵ���ģ�
			/*BinaryTree rightTree=new LinkBinaryTree(root.getRightChild());
			rightTree.inOrderTraverse(root.getRightChild());*/
			this.inOrderTraverse(root.getRightChild());
		}
	}

	//����������
	@Override
	public void posOrderTraverse() {
		// TODO Auto-generated method stub
		System.out.println("posOrderTraver:");
		this.posOrderTraverse(root);
		System.out.println();
		
	}
	public void posOrderTraverse(Node root) {
		if(root!=null) {
			posOrderTraverse(root.getLeftChild());
			posOrderTraverse(root.getRightChild());
			System.out.print(root.getData()+" ");
		}
		
	}

	@Override
	public void preOrderTraverse(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	//����ǵݹ������
	//�Աȵݹ飬�ݹ���Դ��ļ򻯴��룻
	@Override
	public void inOrderByStack() {
		// TODO Auto-generated method stub
		System.out.println("����ǵݹ������");
		//����ջ��
		Deque<Node> stack=new LinkedList<>();
		Node current=root;
		while(current!=null||!stack.isEmpty()) {
			while(current!=null) {
				stack.push(current);
				current=current.getLeftChild();
			}
			
			if(!stack.isEmpty()) {
				current=stack.pop();
				System.out.println(current.getData()+" ");
				current=current.getRightChild();
			}
		}
		System.out.println();
	}

	@Override
	public void posOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	//�㼶����������ʹ�õݹ�ķ�ʽ��������ջ����ʵ�֣�
	@Override
	public void levelOrderByStack() {
		// TODO Auto-generated method stub
		//ʹ��һ�����У���������У�����֮�󣬸��ڵ�����в��Ѹ��ڵ�������ӽڵ������У�
		System.out.print("levelOrderByStack: ");
		if(root==null) {return;}
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(queue.size()!=0) {
			int len=queue.size();
			for(int i=0;i<len;i++) {
				Node temp=queue.poll();
				System.out.print(temp.getData()+" ");
				if(temp.getLeftChild()!=null) {queue.add(temp.getLeftChild());}
				if(temp.getRightChild()!=null) {queue.add(temp.getRightChild());}
			}
			
		}
		System.out.println();
	}

}
