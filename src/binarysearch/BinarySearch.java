package binarysearch;

/**
 * ���ַ�����
 * 
 * @author ���ͺ�
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
	// mid=(low+high)/2 ����д����������ģ�����̫�������������low + ((high - low) >> 1)
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

	// �ݹ�ʵ��
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
	// ʱ�临�Ӷ�0(logn),��һ�ָ�Ч�Ĳ��ҷ�����������ռ�ö���ռ�O(1)
	// һ���������������������
	// ������̫С������ֱ����˳����ң���������̫����Ϊ��Ҫ�������ڴ�ռ䣬�����ڴ��޷����㣩�����ʺ�
	// ��Ϊ��2�ݴη��������仯����

}
