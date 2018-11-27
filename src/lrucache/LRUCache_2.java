package lrucache;
import java.util.HashMap;

/**
 * 最近最久未使用置换算法LRU ()
 * 
 * 查找：每次数据项被查询到时，都将此数据项移动到链表头部。
 * 经过分析，我们知道使用双向链表可以保证插入和替换的时间复杂度是O(1)，但查询的时间复杂度是O(n
 * )，因为需要对双链表进行遍历。为了让查找效率也达到O(1)，很自然的会想到使用 hash table 。
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
