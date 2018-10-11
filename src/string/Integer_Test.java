package string;

import java.lang.reflect.Field;

/*
 * 
 */
public class Integer_Test
{
	public static void main(String[] args)
	{
		Integer a = 1;
		Integer b = 2;
		System.out.print("value a:" + a + " b:" + b);
		swap(a, b);
		System.out.print(" value a:" + a + " b:" + b);
	}

	private static void swap(Integer a, Integer b)
	{
		int temp = a.intValue();
		try
		{
			// private final int value;
			Field field = Integer.class.getDeclaredField("value");
			field.setAccessible(true);
			field.set(a, b);
			// field.set(b, temp); 会将a的缓存赋给b
			field.set(b, new Integer(temp));
		}
		catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	// 这样是错误的
	private static void swap2(Integer a, Integer b)
	{
		Integer temp = a;
		a = b;
		b = temp;
	}
}
