package queue;

/**
 * ѭ�����У�������ʵ�� ���Ӧ�ø��ӹ㷺
 * 
 * ���鲻����������������ţ������н�ġ��������������Ľϴ�
 * 
 * ������ʹtailռ��һ���ռ䣬����ʹ��ʵ��size�������Ż�
 * 
 * @author ���ͺ�
 * 
 */
public class CircularQueue
{
	private String[] items;
	private int n = 0;
	private int head = 0;
	private int tail = 0;

	// ʵ�����ݵ�������С
	private int size = 0;

	public CircularQueue(int capacity)
	{
		items = new String[capacity];
		this.n = capacity;
	}

	public boolean enqueue(String item)
	{
		// �����Ѿ�����
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
		// ���head == tail ��ʾ����Ϊ��
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
}
