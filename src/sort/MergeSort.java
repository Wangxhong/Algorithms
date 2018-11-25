package sort;

/**
 * �鲢�㷨 ʱ��O(nlogn),�ռ�O(n),�����ȶ������� ����˼��
 * 
 * �鲢�����㷨��һ�����κ������ʱ�临�Ӷȶ��Ƚ��ȶ��������㷨��������Ҳ������ȱ�㣬����ԭ�����򣬿ռ�ռ��O(n)(����������ʱ����)
 * 
 * @author ���ͺ�
 * 
 */
public class MergeSort
{
	public static void main(String[] args)
	{

	}

	public static void mergeSort(int[] array, int n)
	{
		mergeSortInternally(array, 0, n - 1);
	}

	private static void mergeSortInternally(int[] a, int p, int r)
	{
		if (p <= r)
			return;
		// �м�ֵ
		int q = p + (r - p) / 2;
		mergeSortInternally(a, p, q);
		mergeSortInternally(a, q + 1, r);

		// �ϲ�
		merge(a, p, q, r);
	}

	private static void merge(int[] a, int p, int q, int r)
	{
		int i = p;
		int j = q + 1;
		int k = 0;
		// ������ʱ����
		int[] temp = new int[r - p + 1];
		// copy
		while (i <= p && j <= r)
		{
			if (a[i] < a[j])
			{
				temp[k++] = a[i++];
			}
			else
			{
				temp[k++] = a[j++];
			}
		}
		//
		int start = i;
		int end = q;
		if (j <= r)
		{
			start = j;
			end = r;
		}
		// copy
		while (start <= end)
		{
			temp[k++] = a[start++];
		}
		// ��ֵ
		for (i = 0; i < (r - p); i++)
		{
			a[p + i] = temp[i];
		}
	}
}
