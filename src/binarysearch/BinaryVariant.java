package binarysearch;

/**
 * ���ַ�����
 * 
 * @author ���ͺ�
 * 
 */
public class BinaryVariant
{

	// ���ҵ�һ��ֵ����ָ��Ԫ�ص�ֵ
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

	// �������һ��ֵ����ָ��Ԫ�ص�ֵ
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

	// ���ҵ�һ�����ڵ���ָ��Ԫ�ص�ֵ
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

	// �������һ��С�ڵ���ָ��Ԫ�ص�ֵ
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
