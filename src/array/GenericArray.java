package array;


/**
 * ���Ͷ�̬����,ʵ����ɾ����
 * 
 * @author xhwang
 */
public class GenericArray<T>
{
	// �޲ι��췽����Ĭ����������Ϊ10
	private static final int DEFAULT_CAPACITY = 10;
	private T[] data;
	private int size;
	private int modCount;

	public GenericArray()
	{
		this(0);
	}

	public GenericArray(int capacity)
	{
		this.data = (T[]) new Object[capacity];
		this.size = 0;
	}

	// ��ȡ��������
	public int getCapacity()
	{
		return data.length;
	}

	// ��ȡ��ǰԪ�ظ���
	public int count()
	{
		return size;
	}

	// �ж������Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return size == 0;
	}

	public void add(int index, T value)
	{
		// ����±�
		checkIndex(index);
		// lasy init
		if (data.length == 0)
		{
			data = (T[]) new Object[DEFAULT_CAPACITY];
		}
		// ����
		else if (size >= data.length)
		{
			resize(2 * size); // ArrayListΪ1.5��
		}
		// �ƶ�����
		for (int i = size; i > index; i--)
		{
			data[i] = data[i - 1];
		}
		// ��ֵ
		data[index] = value;
		size++;
		modCount++;
	}

	public T remove(int index)
	{
		checkIndex(index);
		T t = data[index];
		for (int i = index + 1; i < size; i++)
		{
			data[i - 1] = data[i];
		}
		size--;
		modCount++;
		data[size] = null;
		// ��С����
		if (size == data.length / 4 && data.length / 2 != 0)
		{
			resize(data.length / 2);
		}
		return t;
	}

	private void resize(int capacity)
	{
		@SuppressWarnings("unchecked")
		T[] newdata = (T[]) new Object[capacity];

		for (int i = 0; i < size; i++)
		{
			newdata[i] = data[i];
		}
		modCount++;
		data = newdata;
	}

	// ������ͷ����Ԫ��
	public void addFirst(T e)
	{
		add(0, e);
	}

	// ������β����Ԫ��
	public void addLast(T e)
	{
		add(size, e);
	}

	// ɾ����һ��Ԫ��
	public T removeFirst()
	{
		return remove(0);
	}

	// ɾ��ĩβԪ��
	public T removeLast()
	{
		return remove(size - 1);
	}

	// ��������ɾ��ָ��Ԫ��
	public void removeElement(T e)
	{
		int index = find(e);
		if (index != -1)
		{
			remove(index);
		}
	}

	private int find(T e)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i].equals(e))
			{
				return i;
			}
		}
		return -1;
	}

	private void checkIndex(int index)
	{
		if (index <= 0 || index > size)
		{
			throw new IllegalArgumentException(
					"Add failed! Require index >=0 and index <= size.");
		}
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Array size = %d, capacity = %d \n", size,
				data.length));
		builder.append('[');
		for (int i = 0; i < size; i++)
		{
			builder.append(data[i]);
			if (i != size - 1)
			{
				builder.append(", ");
			}
		}
		builder.append(']');
		return builder.toString();
	}
}
