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
		// int pivot = partitionLeftRight(a, p, r);
		quickSortInternally(a, p, pivot - 1);
		quickSortInternally(a, pivot + 1, r);
	}

	// 返回切分点的位置,思路是j<r,递增遍历，当小于分点时，与i位置的值互换，i加一，继续遍历，直到遍历完成，最后将i位置的值与pivot的值互换，返回i索引
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

	// 左右指针交换法，判断条件为right!=left;
	private static int partitionLeftRight(int[] array, int startIndex,
			int endIndex)
	{
		int left = startIndex;
		int right = endIndex;
		int pivot = array[startIndex];
		while (right != left)
		{
			while (right > left && array[right] > pivot)
			{
				right--;
			}
			while (right > left && array[left] < pivot)
			{
				left--;
			}
			// right==left，交换没有意义
			if (right > left)
			{
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		int temp = array[left];
		array[left] = pivot;
		array[startIndex] = temp;
		return left;
	}

	// 归并排序：由下到上的，先处理子问题，然后再合并
	// 而快排正好相反，它的处理过程是由上到下的，先分区，然后再处理子问题

}
