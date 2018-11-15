package sort;

/**
 * 1.����ռ伸��ûռ�ã�����ԭ�������㷨 ; 2.��ͬ�����ݲ����н������ȶ����㷨 ;
 * 3.ʱ�临�Ӷȣ����O(n),�O(n^2),ƽ��ʱ�䣺0(n^2);
 * 
 * �����=�������(n*(n-1)/2)-��ʼ����ȣ������Ҳ������Ҫ���ݽ����Ĵ���; ƽ����n*(n-1)/4
 * 
 * @author ���ͺ�
 * 
 */
public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] array = new int[] { 3, 6, 1, 5, 2, 4 };
		sort(array, array.length);
	}

	/*
	 * array Ϊ���飬nΪ���鳤��
	 */
	public static void sort(int[] array, int n)
	{
		boolean flag = false;
		for (int i = 0; i < n; i++)
		{
			flag = false;
			for (int j = 0; j < n - i - 1; j++)
			{
				if (array[j] > array[j + 1])
				{
					flag = true;
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
			if (!flag)
			{
				break;
			}
		}
	}
}
