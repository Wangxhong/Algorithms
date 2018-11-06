package queue;

/**
 * 用数组实现队列
 * 
 * @author 王贤宏
 * 
 */
public class ArrayQueue
{
	// 数组：items，数组大小：n
	private String[] items;
	private int n = 0;
	// head表示队头下标，tail表示队尾下标
	private int head = 0;
	private int tail = 0;

	public ArrayQueue(int capacity)
	{
		items = new String[capacity];
		this.n = capacity;
	}

	public boolean enqueue(String item)
	{
		// 如果tail == n 表示队列已经满了
		if (tail == n)
			return false;

		items[tail] = item;
		tail++;
		return true;
	}

	// 优化的入队函数
	// 出队时可以不用搬移数据。如果没有空闲空间了，我们只需要在入队时做一次集中的数据搬移
	public boolean enqueue_1(String item)
	{
		// 如果tail == n 表示队列已经满了
		if (tail == n)
		{
			if (head == 0)
			{
				return false;
			}
			// 搬移
			for (int i = head; i < tail; i++)
			{
				items[i - head] = items[i];
			}
			// 重置
			tail -= head;
			head = 0;
		}

		items[tail] = item;
		tail++;
		return true;
	}

	public String dequeue()
	{
		if (head == tail)
			return null;
		String str = items[head];
		head++;
		return str;
	}

	public void printAll()
	{
		for (int i = head; i < tail; i++)
		{
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue("a");
		queue.enqueue("b");
		queue.dequeue();
		queue.enqueue("c");
		queue.printAll();
	}
}
