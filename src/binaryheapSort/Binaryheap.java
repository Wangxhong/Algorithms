package binaryheapSort;

import java.util.Arrays;

/*
 * ����� ���� �ϸ� �¸�
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
	 * ������
	 * 
	 * @param array
	 *            �������Ķ�
	 */
	public static void buildHeap(int[] array)
	{
		// �����һ����Ҷ�ӽڵ㿪ʼ�������³�����
		int length = array.length;
		int i = ((length - 1) - 1) / 2;
		for (; i >= 0; i--)
		{
			downAdjust(array, i, length);
		}
	}

	/**
	 * �³�����
	 * 
	 * @param array
	 *            �������Ķ�
	 * @param parentIndex
	 *            Ҫ�³��ĸ��ڵ�
	 * @param parentIndex
	 *            �ѵ���Ч��С
	 */
	public static void downAdjust(int[] array, int parentIndex, int length)
	{
		// temp���游�ڵ�ֵ���������ĸ�ֵ
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
			// ��ֵ����
			array[parentIndex] = array[leftIndex];
			parentIndex = leftIndex;
			leftIndex = 2 * parentIndex + 1;
		}
		array[parentIndex] = temp;
	}

	/**
	 * �ϸ�����
	 * 
	 * @param array
	 *            �������Ķ�
	 */
	// ������child������child,parentIndex=(childIndex-1)/2;
	public static void upAdjust(int[] array)
	{
		int childIndex = array.length - 1;
		int parentIndex = (childIndex - 1) / 2;
		// ��ʱ�������棬�������ĸ�ֵ
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
