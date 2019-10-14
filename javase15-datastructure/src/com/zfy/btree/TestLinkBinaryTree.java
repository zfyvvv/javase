package com.zfy.btree;

/**
 *  1.��������������ͼ��ʾ�Ķ������� 
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
		//����һ����������
		Node node5=new Node(5, null, null);
		Node node4=new Node(4, null, node5);
		Node node7=new Node(7, null, null);
		Node node6=new Node(6, null, node7);
		Node node3=new Node(3, null, null);
		Node node2=new Node(2, node3, node6);
		Node node1=new Node(1, node4, node2);
		
		BinaryTree btree=new LinkBinaryTree(node1);
		//����ʹ�õĵ���tree������treeset���Ǳ����Ѿ�����õ��������й��ɺ��㷨�ģ�
		
		//�ж϶������Ƿ�Ϊ�գ�
		System.out.println(btree.isEmpty());
		
		//�������-�ݹ飻1452367
		/*System.out.println("�ȸ��������Ϊ��");
		btree.preOrderTraverse();
		System.out.println();*/
		
		//�������-�ݹ飻4513267
		btree.inOrderTraverse();
		
		//�������-�ݹ飻5437621
		btree.posOrderTraverse();
		//�������-�ǵݹ飨����ջ����
		//����α������������У���1425367;
		btree.levelOrderByStack();
		//�������в���ĳ��ֵ��(�ڱ�����ʱ����в��ң�)
		//System.out.println(btree.findKey(1));
		System.out.println(btree.findKey(20));
		//�������ĸ�-�ݹ飻
		System.out.println(btree.getHeight());
		//�������Ľڵ�������
		System.out.println(btree.size());
	}

}
