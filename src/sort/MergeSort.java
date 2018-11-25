package sort;

/**
 * 归并算法 时间O(nlogn),空间O(n),属于稳定的排序 分治思想
 * 
 * 归并排序算法是一种在任何情况下时间复杂度都比较稳定的排序算法，但是这也是它的缺点，不是原地排序，空间占用O(n)(额外申请临时数据)
 * 
 * @author 王贤宏
 * 
 */
public class MergeSort
{
	public static void main(String[] args)
	{

	}

	public static void mergeSort(int[] array, int n)
	{
		mergeSortInternally(array, 0, n - 1);
	}

	private static void mergeSortInternally(int[] a, int p, int r)
	{
		if (p <= r)
			return;
		// 中间值
		int q = p + (r - p) / 2;
		mergeSortInternally(a, p, q);
		mergeSortInternally(a, q + 1, r);

		// 合并
		merge(a, p, q, r);
	}

	private static void merge(int[] a, int p, int q, int r)
	{
		int i = p;
		int j = q + 1;
		int k = 0;
		// 申请临时数组
		int[] temp = new int[r - p + 1];
		// copy
		while (i <= p && j <= r)
		{
			if (a[i] < a[j])
			{
				temp[k++] = a[i++];
			}
			else
			{
				temp[k++] = a[j++];
			}
		}
		//
		int start = i;
		int end = q;
		if (j <= r)
		{
			start = j;
			end = r;
		}
		// copy
		while (start <= end)
		{
			temp[k++] = a[start++];
		}
		// 赋值
		for (i = 0; i < (r - p); i++)
		{
			a[p + i] = temp[i];
		}
	}
}
