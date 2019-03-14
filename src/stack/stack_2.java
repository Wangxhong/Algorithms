package stack;

import java.util.Stack;

/*
 * 用两个栈实现队列
 */
public class stack_2
{
	private Stack<Integer> in = new Stack<>();
	private Stack<Integer> out = new Stack<>();

	public int pop() throws Exception
	{
		if (out.isEmpty())
		{
			while (!in.isEmpty())
			{
				out.push(in.pop());
			}
			if (out.isEmpty())
				throw new Exception("stack is empty");
		}
		return out.pop();
	}

	public void push(int node)
	{
		in.push(node);
	}

}
