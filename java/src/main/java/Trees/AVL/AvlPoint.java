package Trees.AVL;

public class AvlPoint {
	
	public int value, height,bf;
	public AvlPoint r,l;
	public AvlPoint(int v)
	{
		r = l  =null;
		value = v;
		height = 1;
		bf=  0;
	}
	
}
