package sort;

public class InsertSort
{
	public static void main(String[] args)
	{
		int[] array = new int[] { 3, 6, 1, 5, 2, 4 };
		selectionSort(array, array.length);
	}

	// 插入排序
	// 时间复杂度O(n~n^2),空间复杂度为O(1)
	// 稳定排序
	public static void insertionSort(int[] array, int n)
	{

		for (int i = 1; i < n; i++)
		{
			int value = array[i];
			int j = i - 1;
			// 查找要插入的位置并移动数据
			for (; j >= 0 && array[j] > value; --j)
			{
				array[j + 1] = array[j];
			}
			// 定位赋值
			array[j + 1] = value;
		}
	}

	// 选择排序
	// 空间复杂度为O(1),不管是否有序，时间复杂度O(n^2)
	// 是不稳定的排序
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
}
