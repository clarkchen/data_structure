package Trees.basic;
public class Node {
	public int Value;
	public Node right;
	public Node left;
	public int visited;
	public Node(int Value)
	{
		this.Value = Value;
		right = null;
		left = null;
		visited = 0;
	}

}
