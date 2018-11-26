package sort;

/*
 * �������������Ͱ����
 * 
 */
public class CountingSort
{

	public static void main(String[] args)
	{
		// ����ʮһ�˴�е�����������ֲ���0~9
		int[] array = new int[] { 2, 5, 8, 6, 2, 7, 5, 5, 9, 1, 0 };
		countingSort(array);
		// [0, 1, 2, 2, 5, 5, 5, 6, 7, 8, 9]
	}

	// ��������a������,���������д洢�Ķ��ǷǸ�������
	public static void countingSort(int[] array)
	{
		if (array == null || array.length <= 1)
		{
			return;
		}
		// ȷ��max
		int max = array[0];
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
			}
		}
		// ȷ��Ͱ�Ĵ�С
		int[] bucket = new int[max + 1];
		for (int i = 0; i < bucket.length; i++)
		{
			bucket[i] = 0;
		}
		// ��ֵ
		for (int value : array)
		{
			bucket[value]++;
		}
		// �ۼ����
		for (int i = 1; i < bucket.length; i++)
		{
			bucket[i] = bucket[i - 1] + bucket[i];
		}
		// ����
		int[] copy = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--)
		{
			int index = bucket[array[i]] - 1;
			copy[index] = array[i];
			bucket[array[i]]--;
		}
		// copy��ԭ����
		for (int i = 0; i < copy.length; i++)
		{
			array[i] = copy[i];
		}
	}
	// ʱ�临�Ӷȣ�O(n),�ռ�O(n),�����ȶ�����

}
