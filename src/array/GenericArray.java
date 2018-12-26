package array;

/**
 * 泛型动态数组
 * 
 * @author xhwang
 */
public class GenericArray<T>
{

	private T[] data;
	private int size;

	// 无参构造方法，默认数组容量为10
	public GenericArray()
	{
		this(10);
	}

	public GenericArray(int capacity)
	{
		this.data = (T[]) new Object[capacity];
		this.size = 0;
	}

	// 获取数组容量
	public int getCapacity()
	{
		return data.length;
	}

	// 获取当前元素个数
	public int count()
	{
		return size;
	}

	// 判断数组是否为空
	public boolean isEmpty()
	{
		return size == 0;
	}

	public void add(int index, T value)
	{
		// 检查下标
		checkIndex(index);
		// 扩容
		if (size >= data.length)
		{
			resize(2 * size);
		}
		// 移动数据
		for (int i = size; i > index; i--)
		{
			data[i] = data[i - 1];
		}
		// 赋值
		data[index] = value;
		size++;
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
		data[size] = null;
		// 扩容
		if (size == data.length / 4 && data.length / 2 != 0)
		{
			resize(data.length / 2);
		}
		return t;
	}

	// 向数组头插入元素
	public void addFirst(T e)
	{
		add(0, e);
	}

	// 向数组尾插入元素
	public void addLast(T e)
	{
		add(size, e);
	}

	// 删除第一个元素
	public T removeFirst()
	{
		return remove(0);
	}

	// 删除末尾元素
	public T removeLast()
	{
		return remove(size - 1);
	}

	// 从数组中删除指定元素
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

	private void resize(int capacity)
	{
		T[] newdata = (T[]) new Object[capacity];

		for (int i = 0; i < size; i++)
		{
			newdata[i] = data[i];
		}
		data = newdata;
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
