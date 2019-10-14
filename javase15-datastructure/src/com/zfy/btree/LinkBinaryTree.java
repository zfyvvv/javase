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

	//获取节点个数；
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
			//获取左子树的size；
			int nl=this.size(root.getLeftChild());
			//获取右子树的size；
			int nr=this.size(root.getRightChild());
			//返回左子树和右子树的size只和并+1；
			return nl+nr+1;
		}
	}

	//获取高度；
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
			//获取左子树的高度；
			int nl=this.getHeight(root.getLeftChild());
			//获取右子树的高度；
			int nr=this.getHeight(root.getRightChild());
			//返回左子树和右子树较大高度并+1；
			return nl>nr?nl+1:nr+1;
		}
	}

	//查找某元素；
	@Override
	public Node findKey(int value) {
		// TODO Auto-generated method stub
		return this.findKey(value,root);
	}
	private Node findKey(int value,Node root) {
		// TODO Auto-generated method stub
		if(root==null) {//递归结束条件1
			return null;
		}else if(root!=null && (int)root.getData()==value) {//递归结束条件2
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

	//前序遍历；
	@Override
	public void preOrderTraverse() {
		if(root!=null) {
			//1.输出根节点的值；
			System.out.print(root.getData()+" ");
			//2.对左子树进行先序遍历
				//构建一个二叉树，根是左子树的根；
			BinaryTree leftTree=new LinkBinaryTree(root.getLeftChild());
			leftTree.preOrderTraverse();
			//3.对右子树进行先序遍历
				//构建一个二叉树，根是右子树的根；
			BinaryTree rightTree=new LinkBinaryTree(root.getRightChild());
			rightTree.preOrderTraverse();
		}
	}

	//中序遍历；
	@Override
	public void inOrderTraverse() {
		System.out.println("inOrderTraverse：");
		this.inOrderTraverse(root);
		System.out.println();
	}
	//辅助方法；不对外公开；
	private void inOrderTraverse(Node root) {
		if(root!=null) {
			//1.对左子树进行先序遍历
				//构建一个二叉树，根是左子树的根；
			/*BinaryTree leftTree=new LinkBinaryTree(root.getLeftChild());
			leftTree.inOrderTraverse(root.getLeftChild());*/
			this.inOrderTraverse(root.getLeftChild());
			//2.输出根节点的值；
			System.out.print(root.getData()+" ");
			//3.对右子树进行先序遍历
				//构建一个二叉树，根是右子树的根；
			//方法已经重写，这个是错误的；
			/*BinaryTree rightTree=new LinkBinaryTree(root.getRightChild());
			rightTree.inOrderTraverse(root.getRightChild());*/
			this.inOrderTraverse(root.getRightChild());
		}
	}

	//后续遍历；
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

	//中序非递归遍历；
	//对比递归，递归可以大大的简化代码；
	@Override
	public void inOrderByStack() {
		// TODO Auto-generated method stub
		System.out.println("中序非递归遍历：");
		//创建栈；
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

	//层级遍历；不能使用递归的方式，借助于栈进行实现；
	@Override
	public void levelOrderByStack() {
		// TODO Auto-generated method stub
		//使用一个队列，根先入队列，遍历之后，根节点出队列并把根节点的两个子节点加入队列；
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
