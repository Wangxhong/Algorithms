package sort;

public class InsertSort
{
	public static void main(String[] args)
	{
		int[] array = new int[] { 3, 6, 1, 5, 2, 4 };
		selectionSort(array, array.length);
	}

	// ��������
	// ʱ�临�Ӷ�O(n~n^2),�ռ临�Ӷ�ΪO(1)
	// �ȶ�����
	public static void insertionSort(int[] array, int n)
	{

		for (int i = 1; i < n; i++)
		{
			int value = array[i];
			int j = i - 1;
			// ����Ҫ�����λ�ò��ƶ�����
			for (; j >= 0; --j)
			{
				if (array[j] > value)
				{
					array[j + 1] = array[j];
				}
				else
				{
					break;
				}

			}
			// ��λ��ֵ
			array[j + 1] = value;
		}
	}

	// ѡ������
	// �ռ临�Ӷ�ΪO(1),�����Ƿ�����ʱ�临�Ӷ�O(n^2)
	// �ǲ��ȶ�������
	public static void selectionSort(int[] array, int n)
	{
		if (n <= 1)
			return;

		for (int i = 0; i < n - 1; i++)
		{
			// ������Сֵ
			int minIndex = i;
			for (int j = i + 1; j < n; j++)
			{
				if (array[j] < array[minIndex])
				{
					minIndex = j;
				}
			}
			// ����
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
}
