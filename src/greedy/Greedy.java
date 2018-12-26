package greedy;

/**
 * 贪心算法   ： 删除整数的k个数字，获得删除后的最小值
 * 
 * @param num
 *            原整数
 * @param k
 *            删除数量
 */
public class Greedy
{
	public static void main(String[] args)
	{
		System.out.println(removeKDigits("123456", 3));

		System.out.println(removeKDigits("1593212", 3));

		System.out.println(removeKDigits("30200", 1));
	}

	/*
	 * 数字太长使用字符串表示 准备个数组类型的栈，来装选择的数字 时间复杂：O(n) 空间复杂：O(n)
	 */
	private static String removeKDigits(String num, int k)
	{
		int newLength = num.length() - k;
		char[] stack = new char[num.length()];
		int top = 0;
		for (int i = 0; i < num.length(); i++)
		{
			char c = num.charAt(i);
			while (top > 0 && stack[top - 1] > c && k > 0)
			{
				top -= 1;
				k -= 1;
			}
			stack[top++] = c;
		}
		// 去除栈中的前面的零
		int offset = 0;
		while (offset < newLength && stack[offset] == '0')
		{
			offset++;
		}
		return offset == newLength ? "0" : new String(stack, offset, newLength
				- offset);
	}
}
