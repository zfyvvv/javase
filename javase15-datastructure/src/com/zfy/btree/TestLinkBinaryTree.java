package com.zfy.btree;

/**
 *  1.创建并操作如下图所示的二叉树； 
 *         1
 *      /    \
 *     4      2
 *      \    / \ 
 *       5  3   6
 *               \
 *                7
 * @author DELL
 *
 */
public class TestLinkBinaryTree {
	
	public static void main(String[] args) {
		//创建一个二叉树；
		Node node5=new Node(5, null, null);
		Node node4=new Node(4, null, node5);
		Node node7=new Node(7, null, null);
		Node node6=new Node(6, null, node7);
		Node node3=new Node(3, null, null);
		Node node2=new Node(2, node3, node6);
		Node node1=new Node(1, node4, node2);
		
		BinaryTree btree=new LinkBinaryTree(node1);
		//后面使用的到的tree，比如treeset，是别人已经定义好的树，是有规律和算法的；
		
		//判断二叉树是否为空；
		System.out.println(btree.isEmpty());
		
		//先序遍历-递归；1452367
		/*System.out.println("先根遍历结果为：");
		btree.preOrderTraverse();
		System.out.println();*/
		
		//中序遍历-递归；4513267
		btree.inOrderTraverse();
		
		//后序遍历-递归；5437621
		btree.posOrderTraverse();
		//中序遍历-非递归（借助栈）；
		//按层次遍历（借助队列）；1425367;
		btree.levelOrderByStack();
		//二叉树中查找某个值；(在遍历的时候进行查找；)
		//System.out.println(btree.findKey(1));
		System.out.println(btree.findKey(20));
		//二叉树的高-递归；
		System.out.println(btree.getHeight());
		//二叉树的节点数量；
		System.out.println(btree.size());
	}

}
