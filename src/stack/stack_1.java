package stack;

import java.util.Stack;

/*
 * �ж���Ч������
 */
public class stack_1
{

	// {([])}
	// ��������ջ
	public boolean isValid(String str)
	{
		Stack<Character> stack = new Stack<>();
		int len = str.length();
		Character ch;
		for (int i = 0; i < len; i++)
		{
			ch = str.charAt(i);
			if (stack.isEmpty())
			{
				stack.push(ch);
			}
			else if (isMatch(stack.peek(), ch))
			{
				stack.pop();
			}
			else
			{
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}

	private boolean isMatch(char c1, char c2)
	{
		return c1 == '(' && c2 == ')' || c1 == '{' && c2 == '}' || c1 == '['
				&& c2 == ']';
	}

}
