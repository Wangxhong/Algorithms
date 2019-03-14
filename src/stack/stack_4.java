package stack;

import java.util.Stack;

/*
 * ����min������ջ
 */
public class stack_4
{
	// ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�min�ĺ���

	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int node)
	{
		dataStack.push(node);
		minStack.push(minStack.isEmpty() ? node : Math.min(node,
				minStack.peek()));
	}

	public void pop()
	{
		dataStack.pop();
		minStack.pop();
	}

	public int top()
	{
		return dataStack.peek();
	}

	public int min()
	{
		return minStack.peek();
	}
}
