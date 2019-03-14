package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 按层遍历二叉树，按层打印出来
 * 
 * @author 王贤宏
 */
public class TraverseTree
{
	private static List<TreeNode> levelOrder(TreeNode root)
	{
		if (root == null)
			return new ArrayList<>(0);

		List<TreeNode> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		TreeNode preLast = root, last = root;

		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();

			result.add(node);
			System.out.print(node.val + " ");
			if (node.left != null)
			{
				queue.offer(node.left);
				last = node.left;
			}
			if (node.right != null)
			{
				queue.offer(node.right);
				last = node.right;
			}
			// 换行打印
			if (preLast == node)
			{
				preLast = last;
				System.out.println();
			}
		}
		return result;
	}

	private static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		private TreeNode(int x)
		{
			val = x;
		}
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		levelOrder(root);
	}
}
