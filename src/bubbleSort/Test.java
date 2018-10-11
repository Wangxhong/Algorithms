package bubbleSort;

import java.util.Arrays;

public class Test
{

	public static void main(String[] args)
	{
		int[] nums = { 2, 0, 1, 4 };
		int index=getMissedNumber(nums);
		System.out.print(""+index);
		int a=1;
		System.out.println("a 非的结果是："+(~a));
	}

	private static int getMissedNumber(int[] array)
	{
		Arrays.sort(array);
		if (array[array.length - 1] != array.length)
		{
			return array.length;
		}
		if (array[0] != 0)
		{
			return 0;
		}
		for (int i = 1; i < array.length; i++)
		{
			int temp = array[i - 1] + 1;
			if (array[i] != temp)
			{
				return temp;
			}
		}

		return -1;
	}

}
