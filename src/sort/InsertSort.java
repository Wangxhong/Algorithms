package sort;

public class InsertSort
{
	public static void main(String[] args)
	{
		int[] array = new int[] { 3, 6, 1, 5, 2, 4 };
		selectionSort(array, array.length);
	}

	// 插入排序
	public static void insertionSort(int[] array, int n)
	{

		for (int i = 1; i < n; i++)
		{
			int value = array[i];
			int j = i - 1;
			// 查找要插入的位置并移动数据
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
			// 定位赋值
			array[j + 1] = value;
		}
	}

	// 选择排序
	public static void selectionSort(int[] array, int n)
	{
		if (n <= 1)
			return;

		for (int i = 0; i < n - 1; i++)
		{
			// 查找最小值
			int minIndex = i;
			for (int j = i + 1; j < n; j++)
			{
				if (array[j] < array[minIndex])
				{
					minIndex = j;
				}
			}
			// 交换
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	private void selection_test(int[] array)
	{
		if (array.length <= 1)
			return;
		for (int i = 0; i < array.length - 1; i++)
		{
			int minIndex = i;
			int j = i + 1;
			for (; j < array.length; ++j)
			{
				if (array[j] < array[minIndex])
				{
					minIndex = j;
				}
			}

			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

}
