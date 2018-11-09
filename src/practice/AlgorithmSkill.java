package practice;
import java.util.Arrays;

/**
 * 数据算法几种常用的技巧
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
	 * 1.巧用数组下标 假设取值范围在[0,20]
	 */
	private static void sortByIndex(int[] array)
	{
		int[] temp = new int[21];// 下标为array值，它的值为array对应值出现的次数

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

	// 2.巧用取余 如用数组实现的队列
	private void getPostion(int pos, int N)
	{
		for (int i = 0; i < N; i++)
		{
			if (pos < N)
			{
				// 没有越界
				// 使用数组arr[pos]
			}
			else
			{
				pos = 0;
				// 置为0再使用数组
				// 使用arr[pos]
			}
			pos++;
		}
		// 第二种方案
		for (int i = 0; i < N; i++)
		{
			// 使用数组arr[pos] (我们假设刚开始的时候pos < N)
			pos = (pos + 1) % N;
		}
	}

	// 3.巧用快慢指针 单链表： 是否有环 链表的中间位置的节点 倒数第K个位置的节点

	// 4.巧用移位运算
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

	// 5.设置哨兵位置
	// 插入排序，环形链表

	// 6.与递归有关的优化
	// *对于可以递归的问题考虑状态保存
	// 问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法？
	// 假设 f(n) 表示n级台阶的总跳数法，则有f(n) = f(n-1) + f(n - 2)。

	// 有很多的重复计算
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

	// 使用状体保存进行优化(备忘录法)
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

	// *考虑自底向上 因为如果n数据太大，导致函数栈过多，栈空间不足
	// 这种自底向上的做法称之为递推
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
	// 当你在使用递归解决问题的时候，要考虑以下两个问题
	// (1). 是否有状态重复计算的，可不可以使用备忘录法来优化。
	// (2). 是否可以采取递推的方法来自底向上做，减少一味递归的开销。

}
