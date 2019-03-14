package leecode;

/**
 * ����һ���������飬������������Ҳ�и�����������һ���������Ķ���������һ�������顣 ������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
 * 
 * @author xhwang
 * 
 */
public class MaxSumBySubArray
{
	public static void main(String[] args)
	{
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		// int value = findMaxSubArray_1(array);
		int value = findMaxSubArray_2(array);
		System.out.print("maxSum:" + value);
	}

	// ��ٷ�
	// {3, 10, -4, 7, 2}Ϊ��������������
	private static int findMaxSubArray_1(int[] array)
	{
		int maxSum = array[0];
		int curMax = 0;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = i; j < array.length; j++)
			{
				for (int j2 = i; j2 <= j; j2++)
				{
					curMax += array[j2];
				}

				if (curMax > maxSum)
				{
					maxSum = curMax;
				}
				curMax = 0;
			}
		}
		return maxSum;
	}

	// ��̬�滮
	private static int findMaxSubArray_2(int[] array)
	{
		int maxSum = array[0];
		int curMax = 0;
		for (int i = 0; i < array.length; i++)
		{
			curMax = Math.max(array[i], curMax + array[i]);
			maxSum = Math.max(maxSum, curMax);
		}
		return maxSum;
	}
}
