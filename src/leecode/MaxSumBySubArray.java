package leecode;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。 求所有子数组的和的最大值。要求时间复杂度为O(n)。
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

	// 穷举法
	// {3, 10, -4, 7, 2}为最大的连续子数组
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

	// 动态规划
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
