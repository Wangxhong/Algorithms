package greedy;

/**
 * ̰���㷨   �� ɾ��������k�����֣����ɾ�������Сֵ
 * 
 * @param num
 *            ԭ����
 * @param k
 *            ɾ������
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
	 * ����̫��ʹ���ַ�����ʾ ׼�����������͵�ջ����װѡ������� ʱ�临�ӣ�O(n) �ռ临�ӣ�O(n)
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
		// ȥ��ջ�е�ǰ�����
		int offset = 0;
		while (offset < newLength && stack[offset] == '0')
		{
			offset++;
		}
		return offset == newLength ? "0" : new String(stack, offset, newLength
				- offset);
	}
}
