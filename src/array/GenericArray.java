package array;

/**
 * 泛型动态数组
 * 
 * @author xhwang
 */
public class GenericArray<T>
{

	private T[] data;
	private int size;

	public GenericArray()
	{
		this(10);
	}

	public GenericArray(int capacity)
	{
		this.data = (T[]) new Object[capacity];
		
		
		
		
		
		this.size = 0;
	}

}
