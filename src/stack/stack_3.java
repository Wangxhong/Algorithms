package stack;

import java.util.Stack;

/*
 * Õ»µÄÑ¹Èë¡¢µ¯³öĞòÁĞ
 */
public class stack_3
{
	// ½èÖú¸¨ÖúÕ»
	// push:{1,2,3,4,5} pop:{5,4,3,2,1}
	public boolean isPopOrder(int[] pushSeq, int[] popSeq)
	{
		Stack<Integer> stack = new Stack<>();
		int len = pushSeq.length;
		int popIndex = 0;
		for (int i = 0; i < len; i++)
		{
			stack.push(pushSeq[i]);
			while (popIndex < len && !stack.isEmpty()
					&& (stack.peek() == popSeq[popIndex]))
			{
				stack.pop();
				++popIndex;
			}
		}
		return stack.isEmpty();
	}
}
