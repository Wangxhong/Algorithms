package linkedlist;

/**
 * * �ڱ���ʾ��
 * 
 * @author ���ͺ�
 * 
 */
public class Test
{
	// arrayΪ���飬nΪ���鳤�ȣ�keyΪ���ҵ�ֵ
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
		array[n - 1] = key; // �����ڱ�

		int i = 0;
		while (array[i] != key) // ����i<n��ѭ��
		{
			i++;
		}
		array[n - 1] = temp; // ֵ��ԭ
		if (i == n - 1)
		{
			return -1;
		}
		return i;
	}
}
