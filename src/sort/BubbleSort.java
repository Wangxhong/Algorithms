package sort;

/**
 * 1.额外空间几乎没占用，属于原地排序算法 ; 2.相同的数据不进行交换，稳定性算法 ;
 * 3.时间复杂度：最好O(n),最坏O(n^2),平均时间：0(n^2);
 * 
 * 逆序度=满有序度(n*(n-1)/2)-初始有序度，逆序度也就是需要数据交换的次数; 平均：n*(n-1)/4
 * 
 * @author 王贤宏
 * 
 */
public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] array = new int[] { 3, 6, 1, 5, 2, 4 };
		sort(array, array.length);
	}

	/*
	 * array 为数组，n为数组长度
	 */
	public static void sort(int[] array, int n)
	{
		boolean flag = false;
		for (int i = 0; i < n; i++)
		{
			flag = false;
			for (int j = 0; j < n - i - 1; j++)
			{
				if (array[j] > array[j + 1])
				{
					flag = true;
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
			if (!flag)
			{
				break;
			}
		}
	}
}
