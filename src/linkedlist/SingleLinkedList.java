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
		// TODO
		// p.next=null; 不要置空的？？
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
		// TODO
		// p.next=null; 不要置空的？？
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
}
