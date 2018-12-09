package lrucache;

import java.util.HashMap;

/**
 * Least Recently Used 最近最少使用算法
 * 
 * @author 王贤宏
 * 
 */
public class LRUCache
{
	private Node head;
	private Node tail;
	// 限制的数量
	private int limit;
	private HashMap<Integer, Node> hashMap;

	public LRUCache(int capacity)
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
		LRUCache cache = new LRUCache(16);
		cache.put(6, "a");
		cache.put(2, "b");
		cache.put(1, "c");
		cache.put(4, "d");
		cache.put(5, "e");
		cache.put(9, "f");
		cache.get(6);
	}

	public String get(int key)
	{
		Node node = hashMap.get(key);
		if (node == null)
		{
			return null;
		}
		refreshNode(node);
		return node.value;
	}

	public void remove(int key)
	{
		Node node = hashMap.get(key);
		removeNode(node);
		hashMap.remove(key);
	}

	public void put(int key, String value)
	{
		Node node = hashMap.get(key);
		if (node != null)
		{
			node.value = value;
			refreshNode(node);
		}
		else
		{
			if (hashMap.size() >= limit)
			{
				int oldKey = removeNode(head);
				hashMap.remove(oldKey);
			}
			node = new Node(key, value);
			addNode(node);
			hashMap.put(key, node);
		}
	}

	private void refreshNode(Node node)
	{
		if (node == tail)
			return;
		removeNode(node);
		addNode(node);
	}

	private int removeNode(Node node)
	{
		if (head == node)
		{
			head = head.next;// TODO
		}
		else if (tail == node)
		{
			tail = tail.pre;
		}
		else
		{
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		return node.key;

	}

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

}
