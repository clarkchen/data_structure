package Trees.ReadBalckTree;

public class RBNode {
	public Integer value;
	public int color;//1 means read and 0 means black
	public RBNode left,right, parent;
	public RBNode(RBNode parent)
	{
		value = null;
		this.parent = parent;
		left  = right = null;
		color = 0;
	}
	public void changeColor()
	{
		color = color ^ 1;
	}
	public RBNode(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.color = 1;
		parent = null;
		right =  new RBNode(this);
		left = new RBNode(this);
		
	}

	public RBNode(int value, RBNode parent) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.color = 1;
		this.parent = parent;
		right =  new RBNode(this);
		left = new RBNode(this);
	}
	public void setNewValue(int value)
	{
		this.value = value;
		this.color = 1;
		if(right==null) right =  new RBNode(this);
		if(left ==null) left = new RBNode(this);
	}
	public boolean isNil()
	{
		return value==null;
	}
	 
	
}
