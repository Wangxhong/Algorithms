package recursion;

import java.util.HashMap;

/**
 * �ݹ�������Լ��Ż�
 * 
 * ��ջ������ظ����㣻ʱ��Ϳռ临�Ӷȸ�
 * 
 * @author ���ͺ�
 * 
 */
public class Test
{
	// ��ֹ������f(1)=1
	// ���ƹ�ʽ�� f(n)=f(n-1)+1;
	private int func(int n)
	{
		if (n == 1)
			return 1;
		return func(n - 1) + 1;
	}

	// �Ż�
	private int func_1(int n)
	{
		if (n == 1)
			return 1;
		int sum = 1;
		for (int i = 2; i <= n; i++)
		{
			sum = sum + 1;
		}
		return sum;
	}

	// �� n ��̨�ף�ÿ������Կ� 1 ��̨�׻��� 2 ��̨�ף������ж������߷���
	// f(1)==1;f(2)==2
	// f(n)=f(n-1)+f(n-2)
	private int fun(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return fun(n - 1) + fun(n - 2);
	}

	// �Ż����� ,���Լ���ջ����ȣ�Ҳ������ȫ�ֱ������������
	private int fun_1(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		//
		int sum = 0;
		int prepre = 1;
		int pre = 2;
		for (int i = 3; i <= n; i++)
		{
			sum = prepre + pre;
			prepre = pre;
			pre = sum;
		}
		return sum;
	}

	// �����ظ�����
	private HashMap<Integer, Integer> map = new HashMap<>();

	private int fun_2(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		if (map.containsKey(n))
		{
			return map.get(n);
		}
		int res = fun_2(n - 1) + fun_2(n - 2);

		map.put(n, res);
		return res;
	}
}
