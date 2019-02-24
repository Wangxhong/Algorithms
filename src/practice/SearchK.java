package practice;

/**
 * ��һ������������в��ҵ�K��Ԫ��
 * 
 * @author ���ͺ�
 * 
 */
public class SearchK
{

	// 1.�����ѵ�ʱ�临�Ӷ��� O��k��
	// 2.����ʣ�������ʱ�临�Ӷ���O��n-k��
	// 3.ÿ�ε����ѵ�ʱ�临�Ӷ��� O��logk��
	// ����2��3��Ƕ�׹�ϵ��1��2,3�ǲ��й�ϵ�������ܵ��ʱ�临�Ӷ���O����n-k��logk +
	// k������kԶС��n������£�Ҳ���Խ��Ƶ���Ϊ��O��nlogk��
	// �ռ临�Ӷ�Ϊ0(1) ��Ϊ����ԭ����

	public static void main(String[] args)
	{
		int[] a = new int[] { 3, 5, 7, 1, 9, 6, 3, 0, 8 };
		findK(a, 5);
	}

	// ��ԭ�������Ϲ�����СΪK��С����
	private static int findK(int[] array, int k)
	{
		// ������
		buildHeap(array, k);
		// �Ƚ�
		for (int i = k; i < array.length; i++)
		{
			if (array[i] > array[0])
			{
				// swape(array, 0, i);
				array[0] = array[i];
				downHeap(array, 0, k);
			}
		}
		return array[0];
	}

	private static void buildHeap(int[] array, int length)
	{
		for (int i = ((length - 1) - 1) / 2; i >= 0; i--) // ע�����±�
		{
			downHeap(array, i, length);
		}
	}

	private static void downHeap(int[] array, int parent, int length)
	{
		int tempValue = array[parent];
		int child = 2 * parent + 1;
		while (child < length)
		{
			int index = child;
			if ((child + 1) < length && array[child + 1] < array[child])
			{
				index = child + 1;
			}
			if (array[index] >= tempValue)
			{
				break;
			}
			array[parent] = array[index];
			parent = index;
			child = 2 * parent + 1;
		}
		array[parent] = tempValue;
	}

	private static void swape(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
