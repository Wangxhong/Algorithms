package string;

import java.util.Arrays;

public class String_Test
{
	public static void main(String[] args)
	{
		// char[] str = { 'a', 'b', 'c' };
		// String abc = "abc";
		// String string = new String(str);
		// boolean content = string.equals("abc");
		// boolean address = str.hashCode() == abc.hashCode();
		// System.out.print(content);
		// System.out.print(address);
		// System.out.print("str:" + str.hashCode() + "abc:" + abc.hashCode());
		// int i = indexof("c", 1);
		// System.out.print("index:" + i);
	}

	private class MyString
	{
		private final char[] value;

		private final int offset;

		private final int count;

		private int hashCode;

		public MyString(MyString toCopy)
		{
			value = (toCopy.value.length == toCopy.count) ? toCopy.value
					: Arrays.copyOfRange(toCopy.value, toCopy.offset,
							toCopy.offset + toCopy.length());
			offset = 0;
			count = value.length;
		}

		public int length()
		{
			return count;
		}

		public boolean equals(Object anObject)
		{
			// 对象内存地址
			if (this == anObject)
			{
				return true;
			}
			// 内容与顺序的比较
			if (anObject instanceof MyString)
			{
				MyString anotherString = (MyString) anObject;
				int n = value.length;
				if (n == anotherString.value.length)
				{
					char v1[] = value;
					char v2[] = anotherString.value;
					int i = 0;
					while (n-- != 0)
					{
						if (v1[i] != v2[i])
							return false;
						i++;
					}
					return true;
				}
			}
			return false;
		}

		// 自定义的hashCode的值
		// 不重写默认返回的是内存地址为32位的
		public int hashCode()
		{
			int hash = hashCode;
			if (hash == 0)
			{
				if (count == 0)
				{
					return 0;
				}
				final int end = count + offset;
				final char[] chars = value;
				for (int i = offset; i < end; ++i)
				{
					hash = 31 * hash + chars[i];
				}
				hashCode = hash;
			}
			return hash;
		}

		void _getChars(int start, int end, char[] buffer, int index)
		{
			// NOTE last character not copied!
			System.arraycopy(value, start + offset, buffer, index, end - start);
		}
	}

	abstract class CommonBuilder
	{
		private static final int INITIAL_CAPACITY = 16;
		private int count;
		private char[] value;
		private boolean shared;

		CommonBuilder(MyString string)
		{
			count = string.length();
			shared = false;
			value = new char[count + INITIAL_CAPACITY];
			string._getChars(0, count, value, 0);
		}

		protected int indexof(String subString, int start)
		{
			if (start < 0)
				start = 0;
			int subCount = subString.length();
			if (subCount > 0)
			{
				if (subCount + start > count)
					return -1;
				char firstChar = subString.charAt(0);
				while (true)
				{
					int i = start;
					boolean found = false;
					for (; i < count; i++)
					{
						if (value[i] == firstChar)
						{
							found = true;
							break;
						}
					}
					if (!found || subCount + i > count)
					{
						return -1;
					}
					int o1 = i, o2 = 0;
					while (++o2 < subCount
							&& value[++o1] == subString.charAt(o2))
					{
						// do nothing
					}
					if (o2 == subCount)
					{
						return i;
					}
					start = i + 1;
				}
			}
			return (start == 0 || start < count) ? start : count;
		}

		protected void ensureCapacity(int min)
		{
			if (min < value.length)
			{
				int ourMin = (value.length * 2) + 2;
				enlargeBuffer(Math.min(ourMin, min));
			}
		}

		private void enlargeBuffer(int min)
		{
			int newCount = ((value.length >> 1) + value.length) + 2;
			char[] newData = new char[min > newCount ? min : newCount];
			System.arraycopy(value, 0, newData, 0, count);
			count = newCount;
			shared = false;
		}

		final void append0(char[] chars)
		{
			int newCount = count + chars.length;
			if (newCount > value.length)
			{
				enlargeBuffer(newCount);
			}
			System.arraycopy(chars, 0, value, count, chars.length);
			count = newCount;
		}
	}
}
