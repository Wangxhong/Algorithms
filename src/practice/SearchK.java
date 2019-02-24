package practice;

/**
 * 在一个无序的数组中查找第K大元素
 * 
 * @author 王贤宏
 * 
 */
public class SearchK
{

	// 1.构建堆的时间复杂度是 O（k）
	// 2.遍历剩余数组的时间复杂度是O（n-k）
	// 3.每次调整堆的时间复杂度是 O（logk）
	// 其中2和3是嵌套关系，1和2,3是并列关系，所以总的最坏时间复杂度是O（（n-k）logk +
	// k）。当k远小于n的情况下，也可以近似地认为是O（nlogk）
	// 空间复杂度为0(1) 因为是用原数组

	public static void main(String[] args)
	{
		int[] a = new int[] { 3, 5, 7, 1, 9, 6, 3, 0, 8 };
		findK(a, 5);
	}

	// 在原有数组上构建大小为K的小顶堆
	private static int findK(int[] array, int k)
	{
		// 构建堆
		buildHeap(array, k);
		// 比较
		for (int i = k; i < array.length; i++)
		{
			if (array[i] > array[0])
			{
				// swape(array, 0, i);
				array[0] = array[i];
				downHeap(array, 0, k);
			}
		}
		return array[0];
	}

	private static void buildHeap(int[] array, int length)
	{
		for (int i = ((length - 1) - 1) / 2; i >= 0; i--) // 注意是下标
		{
			downHeap(array, i, length);
		}
	}

	private static void downHeap(int[] array, int parent, int length)
	{
		int tempValue = array[parent];
		int child = 2 * parent + 1;
		while (child < length)
		{
			int index = child;
			if ((child + 1) < length && array[child + 1] < array[child])
			{
				index = child + 1;
			}
			if (array[index] >= tempValue)
			{
				break;
			}
			array[parent] = array[index];
			parent = index;
			child = 2 * parent + 1;
		}
		array[parent] = tempValue;
	}

	private static void swape(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
