package linkedlist;

/**
 * 单链表的查找，插入，删除的操作 数据类型为int
 * 
 * @author 王贤宏
 */
public class SingleLinkedList
{

	private Node head = null;

	public Node findByValue(int value)
	{
		Node p = head;
		while (p != null && p.data != value)
		{
			p = p.next;
		}
		return p;
	}

	public Node findByIndex(int index)
	{
		Node p = head;
		int pos = 0;
		while (p != null && pos != index)
		{
			p = p.next;
			pos++;
		}
		return p;
	}

	public void insertToHead(int value)
	{
		Node node = new Node(null, value);
		insertToHead(node);
	}

	// 在头部插入
	public void insertToHead(Node newNode)
	{
		if (head == null)
		{
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void insertAfter(Node p, int value)
	{
		Node node = new Node(null, value);
		insertAfter(p, node);
	}

	// 在P节点之后插入
	public void insertAfter(Node p, Node newValue)
	{
		if (p == null)
			return;
		newValue.next = p.next;
		p.next = newValue;
	}

	public void insertBefore(Node p, int value)
	{
		Node node = new Node(null, value);
		insertBefore(p, node);
	}

	// 在p节点之前插入 ，时间复杂度O(n)
	public void insertBefore(Node p, Node newValue)
	{
		if (p == null)
			return;
		if (p == head)
		{
			insertToHead(newValue);
			return;
		}
		Node sNode = head;
		while (sNode != null && sNode.next != p)
		{
			sNode = sNode.next;
		}
		if (sNode == null)
			return;

		newValue.next = p;
		sNode.next = newValue;
	}

	// 删除节点
	public void deleteByNode(Node p)
	{
		if (p == null || head == null)
			return;
		if (p == head)
		{
			head = head.next;
			return;
		}
		Node m = head;
		while (m != null && m.next != p)
		{
			m = m.next;
		}

		if (m == null)
			return;

		m.next = m.next.next;
	}

	// 根据值来删除节点
	public void deleteByNode(int value)
	{
		if (head == null)
			return;
		Node p = head;
		Node m = null;
		while (p != null && p.data != value)
		{
			m = p;
			p = p.next;
		}
		if (p == null)
			return;
		if (m == null)
		{
			head = head.next;
		}
		else
		{
			m.next = m.next.next;
		}
	}

	public static Node createNode(int data)
	{
		return new Node(null, data);
	}

	public static class Node
	{
		private Node next;
		private int data;

		public Node(Node next, int data)
		{
			this.next = next;
			this.data = data;
		}

		public int getData()
		{
			return data;
		}
	}

	public void printAll()
	{
		Node p = head;
		while (p != null)
		{
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	// 判断是否是回文
	private boolean palindrome()
	{
		if (head == null)
		{
			return false;
		}
		else
		{
			// 寻找中间节点
			Node p = head;
			Node q = head;
			if (p.next == null)
			{
				return true;
			}
			while (q.next != null && q.next.next != null)
			{
				p = p.next;
				q = q.next.next;
			}
			// 判断奇偶数
			Node leftLink = null;
			Node rightLink = null;
			if (q.next == null)
			{
				rightLink = p.next;
				leftLink = inverseLinkList(p).next;
			}
			else
			{
				rightLink = p.next;
				leftLink = inverseLinkList(p);
			}
			// 判断是否是相等的
			return TFResult(leftLink, rightLink);
		}
	}

	private Node inverseLinkList(Node p)
	{
		Node pre = null;
		Node r = head;
		while (r != p)
		{
			Node next = r.next;
			r.next = pre;
			pre = r;
			r = next;
		}
		r.next = pre;
		return r;
	}

	private boolean TFResult(Node leftNode, Node rightNode)
	{
		Node l = leftNode;
		Node r = rightNode;
		while (l != null && r != null)
		{
			if (l.data == r.data)
			{
				l = l.next;
				r = r.next;
				continue;
			}
			else
			{
				break;
			}
		}
		//
		if (l == null && r == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void insertTail(int value)
	{
		Node newNode = new Node(null, value);
		// 空链表，可以插入新节点作为head，也可以不操作
		if (head == null)
		{
			head = newNode;

		}
		else
		{
			Node q = head;
			while (q.next != null)
			{
				q = q.next;
			}
			newNode.next = q.next;
			q.next = newNode;
		}
	}

	public static void main(String[] args)
	{

		SingleLinkedList link = new SingleLinkedList();
		System.out.println("hello");
		// int data[] = {1};
		// int data[] = {1,2};
		// int data[] = {1,2,3,1};
		// int data[] = {1,2,5};
		// int data[] = {1,2,2,1};
		// int data[] = {1,2,5,2,1};
		int data[] = { 1, 2, 5, 2, 1 };

		for (int i = 0; i < data.length; i++)
		{
			// link.insertToHead(data[i]);
			link.insertTail(data[i]);
		}

		System.out.println("打印原始:");
		link.printAll();
		if (link.palindrome())
		{
			System.out.println("回文");
		}
		else
		{
			System.out.println("不是回文");
		}
	}
}
