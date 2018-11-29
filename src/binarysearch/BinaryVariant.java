package binarysearch;

/**
 * 二分法变体
 * 
 * @author 王贤宏
 * 
 */
public class BinaryVariant
{

	// 查找第一个值等于指定元素的值
	public static int bianry_1(int[] array, int value)
	{
		if (array == null || array.length < 1)
			return -1;
		int high = array.length - 1;
		int low = 0;
		int mid = 0;
		while (high <= low)
		{
			mid = low + ((high - low) >> 1);
			if (array[mid] > value)
			{
				high = mid - 1;
			}
			else if (array[mid] < value)
			{
				low = mid + 1;
			}
			else
			{
				if (mid == 0 || array[mid - 1] != value)
					return mid;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

	// 查找最后一个值等于指定元素的值
	public static int bianry_2(int[] array, int value)
	{
		if (array == null || array.length < 1)
			return -1;
		int high = array.length - 1;
		int low = 0;
		int mid = 0;
		while (high <= low)
		{
			mid = low + ((high - low) >> 1);
			if (array[mid] > value)
			{
				high = mid - 1;
			}
			else if (array[mid] < value)
			{
				low = mid + 1;
			}
			else
			{
				if (mid == array.length - 1 || array[mid + 1] != value)
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	// 查找第一个大于等于指定元素的值
	public static int bianry_3(int[] array, int value)
	{
		if (array == null || array.length < 1)
			return -1;
		int high = array.length - 1;
		int low = 0;
		int mid = 0;
		while (high <= low)
		{
			mid = low + ((high - low) >> 1);
			if (array[mid] >= value)
			{
				if (mid == 0 || array[mid - 1] < value)
					return mid;
				else
					high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return -1;
	}

	// 查找最后一个小于等于指定元素的值
	public static int bianry_4(int[] array, int value)
	{
		if (array == null || array.length < 1)
			return -1;
		int high = array.length - 1;
		int low = 0;
		int mid = 0;
		while (high <= low)
		{
			mid = low + ((high - low) >> 1);
			if (array[mid] <= value)
			{
				if (mid == array.length - 1 || array[mid + 1] > value)
					return mid;
				else
					low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}
		}
		return -1;
	}
}
