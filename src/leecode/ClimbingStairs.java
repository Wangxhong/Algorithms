package leecode;

import java.util.HashMap;

/**
 * ��¥�� ÿ������Կ� 1��̨�׻��� 2��̨�ף�����n�������ж������߷��� (��̬�滮��˼��)
 * 
 * @author xhwang
 * 
 */
public class ClimbingStairs
{

	public static void main(String[] args)
	{

		int value = climb_3(4);
		System.out.print("size:" + value);
	}

	// ����д������ظ����㣬ʱ�临�Ӷ�O(2^n-1)
	private static int climb_1(int n)
	{
		if (n <= 2)
			return n;

		return climb_1(n - 1) + climb_1(n - 2);
	}

	// ���뻺�����
	private static HashMap<Integer, Integer> cache = new HashMap<>();

	private static int climb_2(int n)
	{
		if (n <= 2)
			return n;

		if (cache.containsKey(n))
			return cache.get(n);
		int value = climb_2(n - 1) + climb_2(n - 2);
		cache.put(n, value);
		return value;
	}

	// ���n�ܴ�ջ̫�������ջ��������⣬�������¶��ϵݹ�
	private static int climb_3(int n)
	{
		int OneStep = 1;
		int TwoStep = 2;

		int sum = 0;
		for (int i = 3; i <= n; i++)
		{
			sum = OneStep + TwoStep;
			OneStep = TwoStep;
			TwoStep = sum;
		}
		return sum;
	}

}
