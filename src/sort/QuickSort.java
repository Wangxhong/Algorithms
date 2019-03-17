package sort;

/**
 * �������� ʱ�临�Ӷȣ�O(nlogn),������O(n^2) ����ԭ������ �ռ临�Ӷȣ�O(1) �������ǲ��ȶ�������
 * 
 * @author ���ͺ�
 * 
 */
public class QuickSort
{
	// ��������a�����飬n��ʾ����Ĵ�С
	public static void quickSort(int[] a, int n)
	{
		quickSortInternally(a, 0, n - 1);
		partition_(a, 0, n - 1);
	}

	// ��������ݹ麯����p,rΪ�±�
	private static void quickSortInternally(int[] a, int p, int r)
	{
		if (p >= r)
			return;
		int pivot = partition(a, p, r);
		// int pivot = partitionLeftRight(a, p, r);
		quickSortInternally(a, p, pivot - 1);
		quickSortInternally(a, pivot + 1, r);
	}

	// �����зֵ��λ��,˼·��j<r,������������С�ڷֵ�ʱ����iλ�õ�ֵ������i��һ������������ֱ��������ɣ����iλ�õ�ֵ��pivot��ֵ����������i����
	private static int partition(int[] a, int p, int r)
	{
		int pivot = a[r];
		int i = p;
		int j = p;

		for (; j < r; j++)
		{
			if (a[j] < pivot)
			{
				swap(a, i, j);
				i++;
			}
		}

		swap(a, i, r);
		System.out.println("i=" + i);
		return i;
	}

	private static void partition_(int[] a, int p, int r)
	{
		if (r <= p)
			return;
		//
		int pivot = a[p];
		int i = p, j = r;
		while (j > i)
		{
			while (j > i && a[i] <= pivot)
			{
				i++;
			}
			while (a[j] > pivot)
			{
				j--;
			}
			if (j > i)
				swap(a, i, j);
		}
		//
		swap(a, p, j);
		//
		partition_(a, p, j - 1);
		partition_(a, j + 1, r);
	}

	private static void swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// �鲢�������µ��ϵģ��ȴ��������⣬Ȼ���ٺϲ�
	// �����������෴�����Ĵ�����������ϵ��µģ��ȷ�����Ȼ���ٴ���������
}
