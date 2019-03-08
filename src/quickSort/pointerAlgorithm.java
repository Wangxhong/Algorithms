package quickSort;

import java.util.Arrays;

/**
 * 指针法
 * 
 * @author xhwang
 * 
 */
public class pointerAlgorithm
{

	private static void quickSort(int[] arr, int startIndex, int endIndex)
	{
		if (startIndex >= endIndex)
			return;
		int index = partition_(arr, startIndex, endIndex);
		quickSort(arr, startIndex, index - 1);
		quickSort(arr, index + 1, endIndex);
	}

	private static int partition(int[] arr, int startIndex, int endIndex)
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
			while (right > left && arr[left] <= pivot)// =
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

	public static void main(String[] args)
	{
		int[] array = new int[] { 6, 1, 4, 9, 7, 2, 8, 3, 5 };
		quickSort(array, 0, array.length - 1);
		System.out.print(Arrays.toString(array));
	}

	private static int partition_(int[] array, int startIndex, int endIndex)
	{
		int pivot = array[startIndex];
		int left = startIndex, right = endIndex;

		while (right != left)
		{
			// right
			while (right > left && array[right] > pivot)
			{
				right--;
			}
			// left
			while (left < right && array[left] <= pivot)
			{
				left++;
			}
			// 排除相等时无用交换
			if (right > left)
			{
				swap(array, left, right);
			}
		}
		swap(array, startIndex, left);
		return left;
	}

	private static void swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
