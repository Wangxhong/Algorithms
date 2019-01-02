package binarysearch;

/**
 * 二分法查找
 * 
 * @author 王贤宏
 * 
 */
public class BinarySearch
{
	public static void main(String[] args)
	{
		int[] array = new int[] { 3, 4, 5, 6, 7, 8, 9 };
		binary(array, 5);
	}

	// 1.high>=low
	// mid=(low+high)/2 这种写法是有问题的，数量太大导致溢出，采用low + ((high - low) >> 1)
	public static int binary(int[] array, int value)
	{
		if (array == null || array.length < 1)
			return -1;
		int high = array.length - 1;
		int low = 0;
		while (high >= low)
		{
			int mid = low + ((high - low) >> 1);
			if (value < array[mid])
			{
				high = mid - 1;
			}
			else if (value > array[mid])
			{
				low = mid + 1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}

	// 递归实现
	public static int binary_1(int[] array, int value)
	{
		if (array == null || array.length < 1)
			return -1;
		int high = array.length - 1;
		int low = 0;
		return binary_2(array, high, low, value);
	}

	private static int binary_2(int[] array, int high, int low, int value)
	{
		if (high < low)
			return -1;
		int mid = low + ((high - low) >> 2);
		if (array[mid] > value)
		{
			return binary_2(array, mid - 1, low, value);
		}
		else if (array[mid] < value)
		{
			return binary_2(array, high, mid + 1, value);
		}
		else
		{
			return mid;
		}
	}
	// 时间复杂度0(logn),是一种高效的查找方法，几乎不占用额外空间O(1)
	// 一般它合适有序数组的排列
	// 数据量太小（可以直接用顺序查找）和数据量太大（因为需要连续的内存空间，导致内存无法满足）都不适合
	// 因为是2幂次方，数级变化惊人

}
