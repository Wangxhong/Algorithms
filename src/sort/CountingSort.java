package sort;

/*
 * 计数排序（特殊的桶排序）
 * 
 */
public class CountingSort
{

	public static void main(String[] args)
	{
		// 这是十一人打靶的情况，分数分布在0~9
		int[] array = new int[] { 2, 5, 8, 6, 2, 7, 5, 5, 9, 1, 0 };
		countingSort(array);
		// [0, 1, 2, 2, 5, 5, 5, 6, 7, 8, 9]
	}

	// 计数排序，a是数组,假设数组中存储的都是非负整数。
	public static void countingSort(int[] array)
	{
		if (array == null || array.length <= 1)
		{
			return;
		}
		// 确定max
		int max = array[0];
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
			}
		}
		// 确定桶的大小
		int[] bucket = new int[max + 1];
		for (int i = 0; i < bucket.length; i++)
		{
			bucket[i] = 0;
		}
		// 赋值
		for (int value : array)
		{
			bucket[value]++;
		}
		// 累加求和
		for (int i = 1; i < bucket.length; i++)
		{
			bucket[i] = bucket[i - 1] + bucket[i];
		}
		// 排序
		int[] copy = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--)
		{
			int index = bucket[array[i]] - 1;
			copy[index] = array[i];
			bucket[array[i]]--;
		}
		// copy到原数组
		for (int i = 0; i < copy.length; i++)
		{
			array[i] = copy[i];
		}
	}
	// 时间复杂度：O(n),空间O(n),属于稳定排序

}
