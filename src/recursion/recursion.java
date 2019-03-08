package recursion;

import java.util.HashMap;

/**
 * 递归的例子以及优化
 * 
 * 堆栈溢出；重复计算；时间和空间复杂度高
 * 
 * @author 王贤宏
 * 
 */
public class recursion
{
	// 终止条件：f(1)=1
	// 递推公式： f(n)=f(n-1)+1;
	public int func(int n)
	{
		if (n == 1)
			return 1;
		return func(n - 1) + 1;
	}

	// 优化
	public int func_1(int n)
	{
		if (n == 1)
			return 1;
		int sum = 1;
		for (int i = 2; i <= n; i++)
		{
			sum = sum + 1;
		}
		return sum;
	}

	// 有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问有多少种走法？
	// f(1)==1;f(2)==2
	// f(n)=f(n-1)+f(n-2)
	// 时间复杂度为O(2^n)
	public int fun(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return fun(n - 1) + fun(n - 2);
	}

	// 减少重复计算
	private HashMap<Integer, Integer> map = new HashMap<>();

	// 空间复杂度为O(N),时间复杂度也为O(N)
	public int fun_2(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		if (map.containsKey(n))
		{
			return map.get(n);
		}
		int res = fun_2(n - 1) + fun_2(n - 2);

		map.put(n, res);
		return res;
	}

	// 优化函数 ,可以减少栈的深度，也可以用全局变量来控制深度
	// 这个简单的动态规划的过程，也称动态递归：1.最优子结构，2 边界确定，3状态转移方程
	public int fun_1(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		//
		int sum = 0;
		int prepre = 1;
		int pre = 2;
		for (int i = 3; i <= n; i++)
		{
			sum = prepre + pre;
			prepre = pre;
			pre = sum;
		}
		return sum;
	}
	// 时间复杂度为O(N),但是空间复杂度只为O(1)

}
