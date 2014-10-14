package AVL;

public class AvlPoint {
	
	public int value, height,bf;
	public AvlPoint r,l,parent;
	public AvlPoint(int v)
	{
		r = l = parent =null;
		value = v;
		height = 1;
		bf=  0;
	}
	
}
