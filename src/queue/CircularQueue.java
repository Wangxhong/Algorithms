package queue;

/**
 * 循环队列，用数组实现 这个应用更加广泛
 * 
 * 数组不像链表可以无限扩张，而是有界的。（扩容性能消耗较大）
 * 
 * 这样会使tail占据一个空间，可以使用实际size来进行优化
 * 
 * @author 王贤宏
 * 
 */
public class CircularQueue
{
	private String[] items;
	private int n = 0;
	private int head = 0;
	private int tail = 0;

	// 实际数据的数量大小
	private int size = 0;

	public CircularQueue(int capacity)
	{
		items = new String[capacity];
		this.n = capacity;
	}

	public boolean enqueue(String item)
	{
		// 队列已经满了
		if ((tail + 1) % n == head)
			return false;

		items[tail] = item;
		tail++;
		tail = tail % n;
		size++;
		return true;
	}

	public String dequeue()
	{
		// 如果head == tail 表示队列为空
		if (head == tail)
			return null;

		String item = items[head];
		head++;
		head = head % n;
		size--;
		return item;
	}

	public void printAll()
	{
		if (0 == n)
			return;
		for (int i = head; i % n != tail; ++i)
		{
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	// 其实像ArrayDeque,就是一个非常好的设计
	// 可以使用位运算来进行，效率更高：如：
	// head=(head - 1) & (elements.length - 1)
	// tail=(tail + 1) & (elements.length - 1)
}
