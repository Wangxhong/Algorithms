package queue;

/**
 * ������ʵ�ֶ���
 * 
 * @author ���ͺ�
 * 
 */
public class ArrayQueue
{
	// ���飺items�������С��n
	private String[] items;
	private int n = 0;
	// head��ʾ��ͷ�±꣬tail��ʾ��β�±�
	private int head = 0;
	private int tail = 0;

	public ArrayQueue(int capacity)
	{
		items = new String[capacity];
		this.n = capacity;
	}

	public boolean enqueue(String item)
	{
		// ���tail == n ��ʾ�����Ѿ�����
		if (tail == n)
			return false;

		items[tail] = item;
		tail++;
		return true;
	}

	// �Ż�����Ӻ���
	// ����ʱ���Բ��ð������ݡ����û�п��пռ��ˣ�����ֻ��Ҫ�����ʱ��һ�μ��е����ݰ���
	public boolean enqueue_1(String item)
	{
		// ���tail == n ��ʾ�����Ѿ�����
		if (tail == n)
		{
			if (head == 0)
			{
				return false;
			}
			// ����
			for (int i = head; i < tail; i++)
			{
				items[i - head] = items[i];
			}
			// ����
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
