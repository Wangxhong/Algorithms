package binaryheapSort;

import java.util.Arrays;

/*
 * ������
 */
public class HeapSort
{
	public static void main(String[] args)
	{
		// �������鹹������
		// ѭ�������Ѷ���Ԫ������ĩ��Ҷ���û������ŵ��ڶ�
		// �����ѵĻ�������
		int[] array = new int[] { 2, 6, 8, 1, 5, 11, 4, 9, 3, 10, 7 };
		heapBulid(array);
		System.out.print(Arrays.toString(array));
	}

	private static void heapBulid(int[] array)
	{
		int length = array.length;
		int i = (length - 2) / 2;
		for (; i >= 0; i--)
		{
			downAdjust(array, i, length);
		}
		System.out.print(Arrays.toString(array));
		//
		int j = length - 1;
		for (; j > 0; j--)
		{
			int tempVaule = array[0];
			array[0] = array[j];
			array[j] = tempVaule;
			//
			downAdjust(array, 0, j);
		}
	}

	private static void downAdjust(int[] array, int parentIndex, int length)
	{
		int temp = array[parentIndex];
		int childIndex = 2 * parentIndex + 1;
		while (childIndex < length)
		{
			if (childIndex + 1 < length
					&& array[childIndex + 1] > array[childIndex])
			{
				childIndex++;
			}
			if (temp >= array[childIndex])
			{
				break;
			}
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		array[parentIndex] = temp;
	}

}
