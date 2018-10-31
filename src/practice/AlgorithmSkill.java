package practice;
import java.util.Arrays;

/**
 * �����㷨���ֳ��õļ���
 * 
 * @author xhwang
 * 
 */
public class AlgorithmSkill
{

	public static void main(String[] args)
	{
		int[] array = new int[] { 3, 6, 3, 5, 6, 7, 8, 6, 19, 15 };
		sortByIndex(array);

	}

	/**
	 * 1.���������±� ����ȡֵ��Χ��[0,20]
	 */
	private static void sortByIndex(int[] array)
	{
		int[] temp = new int[21];// �±�Ϊarrayֵ������ֵΪarray��Ӧֵ���ֵĴ���

		for (int i = 0; i < array.length; i++)
		{
			temp[array[i]]++;
		}
		int index = 0;
		for (int i = 0; i < temp.length; i++)
		{
			for (int j = 0; j < temp[i]; j++)
			{
				array[index] = i;
				index++;
			}
		}
		System.out.print("temp:" + Arrays.toString(temp));
		System.out.print("array:" + Arrays.toString(array));
	}

	// 2.����ȡ�� ��������ʵ�ֵĶ���
	private void getPostion(int pos, int N)
	{
		for (int i = 0; i < N; i++)
		{
			if (pos < N)
			{
				// û��Խ��
				// ʹ������arr[pos]
			}
			else
			{
				pos = 0;
				// ��Ϊ0��ʹ������
				// ʹ��arr[pos]
			}
			pos++;
		}
		// �ڶ��ַ���
		for (int i = 0; i < N; i++)
		{
			// ʹ������arr[pos] (���Ǽ���տ�ʼ��ʱ��pos < N)
			pos = (pos + 1) % N;
		}
	}

	// 3.���ÿ���ָ�� ������ �Ƿ��л� ������м�λ�õĽڵ� ������K��λ�õĽڵ�

	// 4.������λ����
	private void test()
	{

		// n/2 --> n>>1
		// n/4 --> n>>2

		int n = 5;
		// if (n % 2 == 1)
		// {
		// // doSomething()
		// }
		if ((n & 1) == 1)
		{
			// doSomething()
		}

	}

	// 5.�����ڱ�λ��
	// �������򣬻�������

	// 6.��ݹ��йص��Ż�
	// *���ڿ��Եݹ�����⿼��״̬����
	// ���⣺һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
	// ���� f(n) ��ʾn��̨�׵���������������f(n) = f(n-1) + f(n - 2)��

	// �кܶ���ظ�����
	private int f(int n)
	{
		if (n <= 2)
		{
			return n;
		}
		else
		{
			return f(n - 1) + f(n - 2);
		}
	}

	// ʹ��״�屣������Ż�(����¼��)
	int[] arr = new int[1000];

	private int fun_1(int n)
	{
		if (n <= 2)
		{
			return n;
		}
		else
		{
			if (arr[n] != 0)
			{
				return arr[n];
			}
			else
			{
				arr[n] = fun_1(n - 1) + fun_1(n - 2);
				return arr[n];
			}
		}
	}

	// *�����Ե����� ��Ϊ���n����̫�󣬵��º���ջ���࣬ջ�ռ䲻��
	// �����Ե����ϵ�������֮Ϊ����
	private int fun_2(int n)
	{
		if (n <= 2)
			return n;
		int f1 = 1;
		int f2 = 2;
		int sum = 0;

		for (int i = 3; i < n; i++)
		{
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		return sum;
	}
	// ������ʹ�õݹ��������ʱ��Ҫ����������������
	// (1). �Ƿ���״̬�ظ�����ģ��ɲ�����ʹ�ñ���¼�����Ż���
	// (2). �Ƿ���Բ�ȡ���Ƶķ������Ե�������������һζ�ݹ�Ŀ�����

}
