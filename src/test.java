
public class test
{
	private static final Object DELETED = 3;

	public test()
	{
	}
	public static void main(String[] args)
	{
		gc();
	}
	
	private static void gc()
	{
		// Log.e("SparseArray", "gc start with " + mSize);

		int[] mKeys=new int[]{2,4,5,6,9};
		Object[] mValues=new Object[]{1,2,3,4,5};
		int mSize=mValues.length;
		int n = mSize;
		int o = 0;
		int[] keys = mKeys;
		Object[] values = mValues;

		for (int i = 0; i < n; i++)
		{
			Object val = values[i];

			if (val != DELETED)
			{
				if (i != o)
				{
					keys[o] = keys[i];
					values[o] = val;
					values[i] = null;
				}
				o++;
			}
		}
		mSize = o;
		System.out.print("size: "+mValues.length);
		// Log.e("SparseArray", "gc end with " + mSize);
	}

}
