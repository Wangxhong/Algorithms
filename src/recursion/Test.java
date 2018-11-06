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
public class Test
{
	// 终止条件：f(1)=1
	// 递推公式： f(n)=f(n-1)+1;
	private int func(int n)
	{
		if (n == 1)
			return 1;
		return func(n - 1) + 1;
	}

	// 优化
	private int func_1(int n)
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
	private int fun(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return fun(n - 1) + fun(n - 2);
	}

	// 优化函数 ,可以减少栈的深度，也可以用全局变量来控制深度
	private int fun_1(int n)
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

	// 减少重复计算
	private HashMap<Integer, Integer> map = new HashMap<>();

	private int fun_2(int n)
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
}
