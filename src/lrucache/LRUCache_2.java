package lrucache;
import java.util.HashMap;

/**
 * ������δʹ���û��㷨LRU ()
 * 
 * ���ң�ÿ���������ѯ��ʱ���������������ƶ�������ͷ����
 * ��������������֪��ʹ��˫��������Ա�֤������滻��ʱ�临�Ӷ���O(1)������ѯ��ʱ�临�Ӷ���O(n
 * )����Ϊ��Ҫ��˫������б�����Ϊ���ò���Ч��Ҳ�ﵽO(1)������Ȼ�Ļ��뵽ʹ�� hash table ��
 * 
 * @author xhwang
 */
public class LRUCache_2
{

	private int mCapacity;

	private HashMap<Integer, Node> cacheMap = new HashMap<>();

	private Node head = null;

	private Node end = null;

	public LRUCache_2(int capacity)
	{
		this.mCapacity = capacity;
	}

	public void set(int key, int value)
	{
		if (cacheMap.containsKey(key))
		{
			Node node = cacheMap.get(key);
			node.value = value;
			remove(node);
			setHead(node);
		}
		else
		{
			Node newNode = Node.createNode(key, value);
			if (cacheMap.size() >= mCapacity)
			{
				cacheMap.remove(end.key);
				remove(end);
				setHead(newNode);
			}
			else
			{
				setHead(newNode);
			}
			cacheMap.put(key, newNode);
		}
	}

	public int get(int key)
	{
		if (cacheMap.containsKey(key))
		{
			Node node = cacheMap.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}

	public void remove(Node n)
	{
		if (n.pre != null)
		{
			n.pre.next = n.next;
		}
		else
		{
			head = n.next;
		}

		if (n.next != null)
		{
			n.next.pre = n.pre;
		}
		else
		{
			end = n.pre;
		}
	}

	public void setHead(Node n)
	{
		n.next = head;
		n.pre = null;
		if (head != null)
		{
			head.pre = n;
		}
		head = n;
		if (end == null)
		{
			end = head;
		}
	}

	public static class Node
	{
		private int key;
		private int value;
		private Node pre;
		private Node next;

		private Node(int key, int value)
		{
			this.key = key;
			this.value = value;
		}

		public static Node createNode(int key, int value)
		{
			return new Node(key, value);
		}
	}

	public static void main(String[] args)
	{
		LRUCache_2 cache = new LRUCache_2(10);
		cache.set(1, 10);
		cache.set(2, 11);
		cache.set(3, 12);
		cache.set(4, 13);
		cache.set(5, 14);
		cache.set(9, 15);

	}
}
