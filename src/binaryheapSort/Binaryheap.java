package binaryheapSort;

import java.util.Arrays;

/*
 * 二叉堆 构建 上浮 下浮
 */
public class Binaryheap
{

	public static void main(String[] args)
	{
		int[] array = new int[] { 1, 3, 2, 6, 5, 7, 8, 9, 10, 0 };
		upAdjust(array);
		System.out.print(Arrays.toString(array));
		//
		array = new int[] { 7, 1, 3, 10, 5, 2, 8, 9, 6 };
		buildHeap(array);
		System.out.print(Arrays.toString(array));
	}

	/**
	 * 构建堆
	 * 
	 * @param array
	 *            待调整的堆
	 */
	public static void buildHeap(int[] array)
	{
		// 从最后一个非叶子节点开始，依次下沉调整
		int length = array.length;
		int i = ((length - 1) - 1) / 2;
		for (; i >= 0; i--)
		{
			downAdjust(array, i, length);
		}
	}

	/**
	 * 下沉调整
	 * 
	 * @param array
	 *            待调整的堆
	 * @param parentIndex
	 *            要下沉的父节点
	 * @param parentIndex
	 *            堆的有效大小
	 */
	public static void downAdjust(int[] array, int parentIndex, int length)
	{
		// temp保存父节点值，用于最后的赋值
		int temp = array[parentIndex];
		int leftIndex = 2 * parentIndex + 1;
		while (leftIndex < length)
		{
			if (leftIndex + 1 < length
					&& array[leftIndex + 1] < array[leftIndex])
			{
				leftIndex++;
			}
			if (temp <= array[leftIndex])
			{
				break;
			}
			// 无值交换
			array[parentIndex] = array[leftIndex];
			parentIndex = leftIndex;
			leftIndex = 2 * parentIndex + 1;
		}
		array[parentIndex] = temp;
	}

	/**
	 * 上浮调整
	 * 
	 * @param array
	 *            待调整的堆
	 */
	// 无论左child还是右child,parentIndex=(childIndex-1)/2;
	public static void upAdjust(int[] array)
	{
		int childIndex = array.length - 1;
		int parentIndex = (childIndex - 1) / 2;
		// 临时变量保存，用于最后的赋值
		int temp = array[childIndex];
		while (childIndex > 0 && temp < array[parentIndex])
		{
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}
		array[childIndex] = temp;
	}
}
