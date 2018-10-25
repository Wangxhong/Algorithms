package array;

/**
 * ������±�������ҡ����롢ɾ��
 * 
 * @author xhwang
 * 
 */
public class array
{
	// ������������data��������
	private int data[];
	// ���������
	private int n;
	// �����ʵ������
	private int count;

	public array(int capacity)
	{
		data = new int[capacity];
		this.n = capacity;
	}

	public int findValue(int index)
	{
		if (index < 0 || index >= count)
		{
			return -1;
		}
		return data[index];
	}

	public boolean insert(int index, int value)
	{
		if (count == n || index < 0 || index > count)
			return false;

		for (int i = count; i > index; i++)
		{
			data[i] = data[i - 1];
		}
		data[index] = value;
		count++;
		return true;
	}

	public int delete(int index)
	{
		if (count == 0 || index < 0 || index >= count)
			return -1;

		int value = data[index];
		for (int i = index + 1; i < count; i++)
		{
			data[i - 1] = data[i];
		}
		--count;
		return value;
	}

	public static void main(String[] args)
	{
		array array = new array(10);
		array.insert(0, 3);
		array.insert(1, 7);
		array.insert(2, 9);
		array.insert(3, 2);
		array.insert(4, 5);

		array.delete(2);

		array.printAll();
	}

	public void printAll()
	{
		for (int i = 0; i < count; ++i)
		{
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
