package quickSort;

import java.util.Arrays;

/*
 * ÍÚ¿Ó·¨
 */
public class holeAlgorithm
{

	private static void quickSort(int[] arr, int startIndex, int endIndex)
	{
		if (startIndex >= endIndex)
		{
			return;
		}
		int index = partition(arr, startIndex, endIndex);
		quickSort(arr, startIndex, index - 1);
		quickSort(arr, index + 1, endIndex);
	}

	private static int partition(int[] arr, int startIndex, int endIndex)
	{
		int pivot = arr[startIndex];
		int index = startIndex;
		int left = startIndex;
		int right = endIndex;
		// if right==left cycle is over.
		while (right >= left)
		{
			// right-->left
			while (right >= left)
			{
				if (arr[right] < pivot)
				{
					arr[left] = arr[right];
					left++;
					index = right;
					System.out.println(Arrays.toString(arr));
					break;
				}
				right--;
				System.out.println(Arrays.toString(arr));
			}
			// left-->right
			while (right >= left)
			{
				if (arr[left] > pivot)
				{
					arr[right] = arr[left];
					right--;
					index = left;
					System.out.println(Arrays.toString(arr));
					break;
				}
				System.out.println(Arrays.toString(arr));
				left++;
			}
		}
		arr[index] = pivot;
		return index;
	}

	public static void main(String[] args)
	{
		int[] array = new int[] { 5, 1, 4, 9, 7, 2, 8, 3, 6 };
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
