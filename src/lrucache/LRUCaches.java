package lrucache;

import java.util.HashMap;

public class LRUCaches
{
	private Node head;
	private Node tail;
	// 限制的数量
	private int limit;
	private HashMap<Integer, Node> hashMap;

	public LRUCaches(int capacity)
	{
		hashMap = new HashMap<>(capacity);
		this.limit = capacity;
	}

	private static class Node
	{
		private int key;
		private String value;
		private Node pre;
		private Node next;

		public Node(int key, String value)
		{
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args)
	{
		LRUCaches cache = new LRUCaches(16);
		cache.put(6, "a");
		cache.put(2, "b");
		cache.put(1, "c");
		cache.put(4, "d");
		cache.put(5, "e");
		cache.put(9, "f");
		cache.get(6);
	}

	//
	public String get(int key)
	{
		Node node = hashMap.get(key);
		if (node != null)
		{
			refreshNode(node);
			return node.value;
		}
		return "";
	}

	public String remove(int key)
	{
		Node node = hashMap.remove(key);
		if (node != null)
		{
			removeNode(node);
			return node.value;
		}
		return "";
	}

	public void put(int key, String value)
	{
		Node node = hashMap.get(key);
		if (hashMap.containsKey(key))
		{
			node = hashMap.get(key);
			refreshNode(node);
		}
		else
		{
			node = new Node(key, value);
			if (hashMap.size() > limit)
			{
				int oldKey = removeNode(head);
				hashMap.remove(oldKey);
			}
			hashMap.put(key, node);
			addNode(node);
		}
	}

	private void refreshNode(Node node)
	{
		if (node == tail)
			return;
		removeNode(node);
		addNode(node);
	}

	// 添加到尾部
	private void addNode(Node node)
	{
		if (tail != null)
		{
			tail.next = node;
			node.pre = tail;
			node.next = null;
		}
		tail = node;
		if (head == null)
		{
			head = node;
		}
	}

	// 从双向链表中删除Node
	private int removeNode(Node node)
	{
		if (head == node)
		{
			head = head.next;
			head.pre = null;//
		}
		else if (tail == node)
		{
			tail = tail.pre;
			tail.next = null;//
		}
		else
		{
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		return node.key;
	}
}
