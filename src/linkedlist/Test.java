package linkedlist;

/**
 * * 哨兵的示例
 * 
 * @author 王贤宏
 * 
 */
public class Test
{
	// array为数组，n为数组长度，key为查找的值
	public int find(int[] array, int n, int key)
	{
		if (array == null || n <= 0)
			return -1;
		int i = 0;
		while (i < n)//
		{
			if (array[i] == key)//
			{
				return i;
			}
			i++;
		}
		return -1;
	}

	public int find2(int[] array, int n, int key)
	{
		if (array == null || n <= 0)
			return -1;

		if (array[n - 1] == key)
		{
			return n - 1;
		}
		int temp = array[n - 1];
		array[n - 1] = key; // 这是哨兵

		int i = 0;
		while (array[i] != key) // 少了i<n的循环
		{
			i++;
		}
		array[n - 1] = temp; // 值复原
		if (i == n - 1)
		{
			return -1;
		}
		return i;
	}
}
