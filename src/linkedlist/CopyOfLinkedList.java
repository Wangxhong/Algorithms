package linkedlist;

/*
 * 1)单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class CopyOfLinkedList
{

	// 反转链表， 返回头结点
	public Node reverse(Node list)
	{
		Node headNode = null;
		Node preNode = null;
		Node curNode = list;

		while (curNode != null)
		{
			Node node = curNode.next;
			if (node == null)
			{
				headNode = curNode;
			}
			curNode.next = preNode;
			preNode = curNode;
			curNode = node;
		}
		return headNode;
	}

	private Node reverse_01(Node head)
	{
		if (head.next == null)
			return head;
		Node pre = null;
		while (head != null)
		{
			Node node = head.next;
			head.next = pre;
			pre = head;
			head = node;
		}
		return pre;

	}

	// 检测是否为循环链表（环的检测）
	public boolean checkCircle(Node list)
	{
		if (list == null)
			return false;

		Node fast = list.next;
		Node slow = list;

		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkCircle_01(Node head)
	{
		if (head == null || head.next == null)
		{
			return false;
		}
		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null)// 判断条件
		{
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
			{
				return true;
			}
		}
		return false;
	}

	// 合并有序链表
	public Node mergeSortedList(Node la, Node lb)
	{
		if (la == null)
			return lb;
		if (lb == null)
			return la;

		Node head = null; //
		Node p = la;
		Node q = lb;

		// 获取头结点
		if (p.data < q.data)
		{
			head = p;
			p = p.next;
		}
		else
		{
			head = q;
			q = q.next;
		}

		// 拼接
		Node r = head;
		while (p != null && q != null)
		{
			if (p.data < q.data)
			{
				r.next = p;
				p = p.next;
			}
			else
			{
				r.next = q;
				q = q.next;
			}
			r = r.next;
		}
		// 其中一个已拼完，剩下一个链作判断，完成最后一步
		if (p != null)
		{
			r.next = p;
		}
		else
		{
			r.next = q;
		}

		return head;
	}

	private Node mergeSortedList_(Node list1, Node list2)
	{
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		Node p = list1;
		Node q = list2;

		Node head, curNode;
		// 初始指向
		if (p.data < q.data)
		{
			head = curNode = p;
			p = p.next;
		}
		else
		{
			head = curNode = q;
			q = q.next;
		}
		//
		while (p != null && q != null)
		{
			if (p.data < q.data)
			{
				curNode.next = p;
				p = p.next;
			}
			else
			{
				curNode.next = q;
				q = q.next;
			}
			curNode = curNode.next;
		}
		// 判断哪个没有结束，并拼接上
		if (p != null)
		{
			curNode.next = p;
		}
		if (q != null)
		{
			curNode.next = q;
		}
		return head;
	}

	// 删除倒数第K个的结点
	public Node deleteLastKth(Node list, int k)
	{
		Node fast = list;

		// 确定fast的位置与K位置对称
		int i = 1;
		while (fast != null && i < k)
		{
			fast = fast.next;
			++i;
		}

		if (fast == null)
			return list;

		// 一直遍历到尽头
		Node slow = list;
		Node preNode = null;
		while (fast.next != null)
		{
			fast = fast.next;
			preNode = slow;
			slow = slow.next;
		}

		if (preNode == null)
		{
			list = list.next;
		}
		else
		{
			preNode.next = preNode.next.next;
		}

		return list;
	}

	private Node deleteK(Node head, int k)
	{
		Node forward = head;
		int i = 1;
		while (forward != null && i < k)
		{
			forward = forward.next;
			i++;
		}
		// 倒数K超出范围
		if (forward == null)
		{
			return head;
		}
		//
		Node pre = null;
		Node back = head;
		while (forward.next != null)
		{
			forward = forward.next;
			pre = back;
			back = back.next;
		}
		// 倒数K与头结点正好重合
		if (pre == null)
		{
			head = head.next;
		}
		else
		{
			pre.next = pre.next.next;
		}
		return head;
	}

	// 中间值
	public Node findMiddleNode(Node list)
	{
		if (list == null)
		{
			return null;
		}
		Node slow = list;
		Node fast = list;
		while (fast.next != null && fast.next.next != null) //
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void printAll(Node list)
	{
		Node p = list;
		while (p != null)
		{
			System.out.print("data:" + p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	public static Node createNode(int data)
	{
		return new Node(data, null);
	}

	public static class Node
	{
		private int data;
		private Node next;

		public Node(int data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
}
