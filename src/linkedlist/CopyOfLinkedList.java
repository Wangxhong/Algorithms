package linkedlist;

/*
 * 1)������ת
 * 2) �����л��ļ��
 * 3) �������������ϲ�
 * 4) ɾ����������n�����
 * 5) ��������м���
 */
public class CopyOfLinkedList
{

	// ��ת���� ����ͷ���
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
		Node pre = null;
		Node newHead = null;
		while (head != null)
		{
			Node node = head.next;
			if (node == null)
			{
				newHead = head;
			}
			head.next = pre;
			pre = head;
			head = node;
		}
		return newHead;
	}

	// ����Ƿ�Ϊѭ���������ļ�⣩
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
		if (head == null)
			return false;
		Node slow = head;
		Node fast = head.next;
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

	// �ϲ���������
	public Node mergeSortedList(Node la, Node lb)
	{
		if (la == null)
			return lb;
		if (lb == null)
			return la;

		Node head = null;
		Node p = la;
		Node q = lb;

		// ��ȡͷ���
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

		// ƴ��
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
		// ����һ����ƴ�꣬ʣ��һ�������жϣ�������һ��
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

	// ɾ��������K���Ľ��
	public Node deleteLastKth(Node list, int k)
	{
		Node fast = list;

		// ȷ��fast��λ����Kλ�öԳ�
		int i = 1;
		while (fast != null && i < k)
		{
			fast = fast.next;
			++i;
		}

		if (fast == null)
			return list;

		// һֱ��������ͷ
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
		Node fast = head;
		int i = 1;
		while (fast != null && i < k)
		{
			fast = fast.next;
			i++;
		}
		if (fast == null)
			return head;
		Node slow = head;
		Node pre = null;
		while (fast.next != null)
		{
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
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

	// �м�ֵ
	public Node findMiddleNode(Node list)
	{
		if (list == null)
			return null;
		Node slow = list;
		Node fast = list;
		while (fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
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
