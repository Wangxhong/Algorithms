package queue;

/**
 * ��������ʵ�ֵĶ���
 * 
 * @author ���ͺ�
 * 
 */
public class LinkedQueue
{
	private Node head = null;
	private Node tail = null;

	// ���ʱ���ƶ�tailָ��
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

	// ����ʱ���ƶ�headָ��
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
