package sort;

/**
 * 快速排序 时间复杂度：O(nlogn),最坏的情况O(n^2) 它是原地排序 空间复杂度：O(1) 但是它是不稳定的排序
 * 
 * @author 王贤宏
 * 
 */
public class QuickSort
{
	// 快速排序，a是数组，n表示数组的大小
	public static void quickSort(int[] a, int n)
	{
		quickSortInternally(a, 0, n - 1);
	}

	// 快速排序递归函数，p,r为下标
	private static void quickSortInternally(int[] a, int p, int r)
	{
		if (p >= r)
			return;
		int pivot = partition(a, p, r);
		quickSortInternally(a, p, pivot - 1);
		quickSortInternally(a, pivot + 1, r);
	}

	private static int partition(int[] a, int p, int r)
	{
		int pivot = a[r];
		int i = p;
		int j = p;

		for (; j < r; j++)
		{
			if (a[j] < pivot)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}

		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;
		System.out.println("i=" + i);
		return i;
	}

	private static int partition_(int[] arr, int startIndex, int endIndex)
	{
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;

		while (left != right)
		{
			while (right > left && arr[right] > pivot)
			{
				right--;
			}
			while (right > left && arr[left] <= pivot)
			{
				left++;
			}
			//
			if (right > left)
			{
				int tempValue = arr[left];
				arr[left] = arr[right];
				arr[right] = tempValue;
			}
		}
		//
		int temp = arr[left];
		arr[left] = pivot;
		arr[startIndex] = temp;
		return left;
	}

	// 归并排序：由下到上的，先处理子问题，然后再合并
	// 而快排正好相反，它的处理过程是由上到下的，先分区，然后再处理子问题

}
