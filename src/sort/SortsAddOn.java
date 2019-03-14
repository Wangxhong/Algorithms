package sort;

/**
 * ����ð���㷨 �������ð�ݸ��׶��������㷨���� ϣ������
 * 
 * @author ���ͺ�
 * 
 */
public class SortsAddOn
{
	private static void bubbleDownSort(int[] arr)
	{
		if (arr == null || arr.length == 1)
		{
			return;
		}
		// ��ǰ�����������С������������ˮ��������
		for (int i = 0; i < arr.length; i++)
		{
			int j = i + 1;
			for (; j < arr.length; j++)
			{
				if (arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		// ��β����ǰ������ȡ�����ֵ
		for (int i = arr.length - 1; i >= 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[j] > arr[i])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	/*
	 * ϣ������
	 */
	private static void shellSort(int[] arr)
	{
		if (arr == null || arr.length == 1)
		{
			return;
		}
		int step = arr.length / 2;
		while (step >= 1)
		{
			for (int i = step; i < arr.length; i++)
			{
				int value = arr[i];
				int j = i - step;
				for (; j >= 0; j -= step)
				{
					if (value < arr[j])
					{
						arr[j + step] = arr[j];
					}
					else
					{
						break;
					}
				}
				arr[j + step] = value;
			}
			step = step / 2;
		}
	}

	// 5/2/1
	private void shellSort_(int[] arr)
	{
		// ����gap��������С����
		for (int gap = arr.length / 2; gap > 0; gap = gap >> 1)
		{
			// �ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
			for (int i = gap; i < arr.length; i++)
			{
				int j = i;
				while (j - gap >= 0 && arr[j] < arr[j - gap])
				{
					swap(arr, j, j - gap);
					j -= gap;
				}
			}
		}
	}

	private static void swap(int[] arr, int j, int i)
	{
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
