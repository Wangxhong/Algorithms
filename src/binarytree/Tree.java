package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ǰ�к���б���
 * 
 * @author xhwang
 * 
 */
public class Tree
{
	private Node root;
	private static List<Node> list = new ArrayList<Node>();

	public Tree()
	{
		init();
	}

	// ���ĳ�ʼ��:�ȴ�Ҷ�ڵ㿪ʼ,��Ҷ����
	public void init()
	{
		Node a = new Node("A", null, null);
		Node c = new Node("C", null, null);
		Node b = new Node("B", a, c);

		Node f = new Node("F", null, null);
		Node e = new Node("E", b, f);

		Node z = new Node("Z", null, null);
		Node x = new Node("X", null, null);
		Node y = new Node("Y", x, z);

		Node h = new Node("H", e, y);

		root = h;
	}

	// ����ڵ��ࣺ
	private class Node
	{
		private String data;
		private Node lchid;// ����ָ����������ָ��
		private Node rchild;// ����ָ����������ָ��

		public Node(String data, Node lchild, Node rchild)
		{
			this.data = data;
			this.lchid = lchild;
			this.rchild = rchild;
		}
	}

	/**
	 * �Ըö���������ǰ����� ����洢��list�� ǰ�����:
	 */
	public void preOrder(Node node)
	{
		list.add(node); // �Ƚ����ڵ����list
		// �����������Ϊ�ռ��������ң��ڵݹ���÷�����ʱ��һֱ�Ὣ�����ĸ�����list������������ȱ������ڵ�
		if (node.lchid != null)
		{
			preOrder(node.lchid);
		}
		// �����ߵ���һ�㣬ֻҪ��ǰ�ڵ�������Ϊ�գ���ô�Ϳ������������ϱ�������֤�˸����ҵı���˳��
		if (node.rchild != null)
		{
			preOrder(node.rchild);
		}
	}

	/**
	 * �Ըö���������������� ����洢��list��, ���ڶ����������ͨ����������õ�����ļ���
	 */
	public void inOrder(Node node)
	{
		if (node.lchid != null)
		{
			inOrder(node.lchid);
		}
		list.add(node);
		if (node.rchild != null)
		{
			inOrder(node.rchild);
		}
	}

	/**
	 * �Ըö��������к������ ����洢��list��
	 */
	public void postOrder(Node node)
	{
		if (node.lchid != null)
		{
			postOrder(node.lchid);
		}
		if (node.rchild != null)
		{
			postOrder(node.rchild);
		}
		list.add(node);
	}

	/**
	 * ���ص�ǰ������� ˵��: 1�����һ����ֻ��һ����㣬�������Ϊ1�� 2����������ֻ����������û������������ô���������������������ȼ�1��
	 * 3����������ֻ����������û������������ô�������Ӧ����������������ȼ�1��
	 * 4����������������������������Ǹ�������Ⱦ���������������ȵĽϴ�ֵ�ټ�1��
	 * 
	 * @return
	 */
	public int getTreeDepth(Node node)
	{
		// �ҵ���ֹ����
		if (node.lchid == null && node.rchild == null)
		{
			return 1;
		}
		// �ݹ麯��
		int left = 0, right = 0;
		if (node.lchid != null)
		{
			left = getTreeDepth(node.lchid);
		}
		if (node.rchild != null)
		{
			right = getTreeDepth(node.rchild);
		}
		// �������
		return left > right ? left + 1 : right + 1;
	}

	// �õ��������
	public List<Node> getResult()
	{
		return list;
	}

	public static void main(String[] args)
	{
		Tree tree = new Tree();
		System.out.println("���ڵ���:" + tree.root);

		tree.inOrder(tree.root);
		StringBuilder builder = new StringBuilder();
		for (Node node : list)
		{
			builder.append(node.data);
		}
		System.out.print("" + builder.toString());

		int depth = tree.getTreeDepth(tree.root);
		System.out.println("��������� " + depth);
	}
}
