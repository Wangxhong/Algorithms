package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 按前中后进行遍历
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

	// 树的初始化:先从叶节点开始,由叶到根
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

	// 定义节点类：
	private class Node
	{
		private String data;
		private Node lchid;// 定义指向左子树的指针
		private Node rchild;// 定义指向右子树的指针

		public Node(String data, Node lchild, Node rchild)
		{
			this.data = data;
			this.lchid = lchild;
			this.rchild = rchild;
		}
	}

	/**
	 * 对该二叉树进行前序遍历 结果存储到list中 前序遍历:
	 */
	public void preOrder(Node node)
	{
		list.add(node); // 先将根节点存入list
		// 如果左子树不为空继续往左找，在递归调用方法的时候一直会将子树的根存入list，这就做到了先遍历根节点
		if (node.lchid != null)
		{
			preOrder(node.lchid);
		}
		// 无论走到哪一层，只要当前节点左子树为空，那么就可以在右子树上遍历，保证了根左右的遍历顺序
		if (node.rchild != null)
		{
			preOrder(node.rchild);
		}
	}

	/**
	 * 对该二叉树进行中序遍历 结果存储到list中, 对于二叉查找树，通过中序遍历得到有序的集合
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
	 * 对该二叉树进行后序遍历 结果存储到list中
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
	 * 返回当前数的深度 说明: 1、如果一棵树只有一个结点，它的深度为1。 2、如果根结点只有左子树而没有右子树，那么树的深度是其左子树的深度加1；
	 * 3、如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1；
	 * 4、如果既有右子树又有左子树，那该树的深度就是其左、右子树深度的较大值再加1。
	 * 
	 * @return
	 */
	public int getTreeDepth(Node node)
	{
		// 找到终止条件
		if (node.lchid == null && node.rchild == null)
		{
			return 1;
		}
		// 递归函数
		int left = 0, right = 0;
		if (node.lchid != null)
		{
			left = getTreeDepth(node.lchid);
		}
		if (node.rchild != null)
		{
			right = getTreeDepth(node.rchild);
		}
		// 结果返回
		return left > right ? left + 1 : right + 1;
	}

	// 得到遍历结果
	public List<Node> getResult()
	{
		return list;
	}

	public static void main(String[] args)
	{
		Tree tree = new Tree();
		System.out.println("根节点是:" + tree.root);

		tree.inOrder(tree.root);
		StringBuilder builder = new StringBuilder();
		for (Node node : list)
		{
			builder.append(node.data);
		}
		System.out.print("" + builder.toString());

		int depth = tree.getTreeDepth(tree.root);
		System.out.println("树的深度是 " + depth);
	}
}
