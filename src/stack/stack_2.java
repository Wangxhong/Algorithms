package stack;

import java.util.Stack;

/*
 * ������ջʵ�ֶ���
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
