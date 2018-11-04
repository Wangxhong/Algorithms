package queue;

/**
 * 基于链表实现的队列
 * 
 * @author 王贤宏
 * 
 */
public class LinkedQueue
{
	private Node head = null;
	private Node tail = null;

	// 入队时，移动tail指针
	public boolean enqueue(String data)
	{
		if (tail == null)
		{
			Node node = new Node(data, null);
			head = node;
			tail = node;
		}
		else
		{
			tail.next = new Node(data, null);
			tail = tail.next;
		}
		return true;
	}

	// 出队时，移动head指针
	public String dequeue()
	{
		if (head == null)
		{
			return null;
		}
		String str = head.data;
		head = head.next;
		if (head == null)
		{
			tail = null;
		}
		return str;
	}

	private static class Node
	{
		private String data;
		private Node next;

		public Node(String data, Node next)
		{
			this.data = data;
			this.next = next;
		}

		public String getData()
		{
			return data;
		}
	}

}
