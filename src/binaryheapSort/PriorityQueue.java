package binaryheapSort;

import java.util.Arrays;

/*
 * 优先队列 （最大优先队列/最小优队列）
 */
public class PriorityQueue
{
	private static int[] array;
	// 当前下标值
	private int size;

	public PriorityQueue(int length)
	{
		array = new int[length];
	}

	public static void main(String[] args)
	{
		PriorityQueue queue = new PriorityQueue(16);
		queue.enQueue(3);
		queue.enQueue(1);
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(2);
		queue.enQueue(5);
		queue.enQueue(9);
		System.out.print(Arrays.toString(array));
		//
		int value1=queue.deQueue();
		int value2=queue.deQueue();
		int value3=queue.deQueue();
		
		System.out.print("出栈："+Integer.toString(value1)+Integer.toString(value2)+Integer.toString(value3));

	}

	private void enQueue(int key)
	{
		if (size >= array.length)
		{
			resize();
		}
		array[size++] = key;
		upAdjust(array);
	}

	private int deQueue()
	{
		int heap = array[0];
		array[0] = array[size--];
		downAdjust(array, 0, size);
		return heap;
	}

	// 上浮调整
	private void upAdjust(int[] array)
	{
		int childIndex = size - 1; //是完全二叉树
		int parentIndex = (childIndex - 1) / 2;
		int temp = array[childIndex];
		while (childIndex > 0 && temp > array[parentIndex])
		{
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}
		array[childIndex] = temp;
	}

	private void downAdjust(int[] array, int parentIndex, int length)
	{
		int temp = array[parentIndex];
		int childIndex = 1;
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

	// 数组扩容
	private void resize()
	{
		int newSize = 2 * size;
		array = Arrays.copyOf(array, newSize);
	}

}
