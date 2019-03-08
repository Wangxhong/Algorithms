package binaryheapSort;

/**
 * �������ȶ��У����ѣ���ʵ�֣��ѹ���/ɾ��/��Ӳ���
 * 
 * @author ���ͺ�
 * 
 */
public class PriorityQueue_
{
	private static final int CAPACITY_RATIO = 2;
	// ʵ������
	private int mSize;
	// ά��������
	private String[] array;

	public PriorityQueue_(int capacity)
	{
		this.array = new String[capacity];
	}

	public void enqueue(String object)
	{
		if (object == null)
			throw new NullPointerException();
		resize(mSize + 1);
		array[mSize++] = object;
		upAdjust(array);
	}

	public String dequeue()
	{
		String heap = array[0];
		array[0] = array[--mSize];
		array[mSize] = null;
		downAdjust(array, 0, mSize);
		return heap;
	}

	// ��̬����
	private void resize(int size)
	{
		if (size > array.length)
		{
			String[] newArray = new String[size * CAPACITY_RATIO];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
	}

	// �ϸ�
	private void upAdjust(String[] array)
	{
		int childIndex = mSize - 1;
		String temp = array[childIndex];
		while (childIndex > 0)
		{
			int parentIndex = (childIndex - 1) / 2;
			if (array[parentIndex].compareTo(temp) >= 0)
			{
				break;
			}
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
		}
		array[childIndex] = temp;
	}

	// �³�
	private void downAdjust(String[] array, int parent, int length)
	{
		int childIndex = 2 * parent + 1;
		String temp = array[parent];
		while (childIndex < length)
		{
			if ((childIndex + 1) < length
					&& array[childIndex + 1].compareTo(array[childIndex]) > 0)
			{
				childIndex = childIndex + 1;
			}
			if (temp.compareTo(array[childIndex]) >= 0)
			{
				break;
			}
			array[parent] = array[childIndex];
			parent = childIndex;
			childIndex = 2 * parent + 1;
		}
		array[parent] = temp;
	}

	// ����
	public static void main(String[] args)
	{
		PriorityQueue_ queue_ = new PriorityQueue_(10);
		queue_.enqueue("b");
		queue_.enqueue("2");
		queue_.enqueue("n");
		queue_.enqueue("o");
		queue_.enqueue("6");
		queue_.enqueue("k");
		queue_.enqueue("9");

		queue_.dequeue();
		queue_.dequeue();
	}
}
