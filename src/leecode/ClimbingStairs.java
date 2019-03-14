package leecode;

import java.util.HashMap;

/**
 * 爬楼梯 每次你可以跨 1个台阶或者 2个台阶，共有n阶请问有多少种走法？ (动态规划的思想)
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

	// 这会有大量的重复计算，时间复杂度O(2^n-1)
	private static int climb_1(int n)
	{
		if (n <= 2)
			return n;

		return climb_1(n - 1) + climb_1(n - 2);
	}

	// 加入缓存记忆
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

	// 如果n很大，栈太深，则会出现栈溢出的问题，可以自下而上递归
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
