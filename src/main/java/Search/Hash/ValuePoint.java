package Search.Hash;

public class ValuePoint {
	int key;
	int value;
	public ValuePoint()
	{
		this.reset();
	}
	public ValuePoint(int k, int v)
	{
		key  =k;
		value= v;
	}
	public Boolean isEmpty()
	{
		return value==Integer.MIN_VALUE;
	}
	public void set(int k, int v)
	{
		key = k; value = v;
	}
	public void reset()
	{
		key = Integer.MIN_VALUE;
		value = Integer.MIN_VALUE;
	}
	
}
