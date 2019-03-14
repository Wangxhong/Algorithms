package stack;

import java.util.Stack;

/*
 * 包含min函数的栈
 */
public class stack_4
{
	// 定义栈的数据结构，请在该类型中实现一个能够得到min的函数

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
