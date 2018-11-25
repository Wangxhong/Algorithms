package sort;

/**
 * 向下冒泡算法 （或许比冒泡更易懂的排序算法？） 希尔排序
 * 
 * @author 王贤宏
 * 
 */
public class SortsAddOn
{
	private static void bubbleDownSort(int[] arr)
	{
		if (arr == null || arr.length == 1)
		{
			return;
		}
		for (int i = 0; i < arr.length; i++)
		{
			int j = i + 1;
			for (; j < arr.length; j++)
			{
				if (arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	/*
	 * 希尔排序
	 */
	private static void shellSort(int[] arr)
	{
		if (arr == null || arr.length == 1)
		{
			return;
		}
		int step = arr.length / 2;
		while (step >= 1)
		{
			for (int i = step; i < arr.length; i++)
			{
				int value = arr[i];
				int j = i - step;
				for (; j >= 0; j -= step)
				{
					if (value < arr[j])
					{
						arr[j + step] = arr[j];
					}
					else
					{
						break;
					}
				}
				arr[j + step] = value;
			}
			step = step / 2;
		}
	}

	private static void print(int[] arr)
	{
		System.out.println("Print array:");
		for (int x : arr)
		{
			System.out.print(x + "\t");
		}
		System.out.println("");
	}
}
