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

	// ����ָ�뽻�������ж�����Ϊright!=left;
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
			// right==left������û������
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

	// �鲢�������µ��ϵģ��ȴ��������⣬Ȼ���ٺϲ�
	// �����������෴�����Ĵ�����������ϵ��µģ��ȷ�����Ȼ���ٴ���������

}
