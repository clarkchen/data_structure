package Trees.basic;

public class ThreadNode  {
	public int Value;
	public ThreadNode right;
	public ThreadNode left;
	public int visited;
	public int ltag,rtag;
	public ThreadNode(int Value) {
		this.Value = Value;
		right = null;
		left = null;
		visited = 0;
		ltag = 0;
		rtag = 0;
		// TODO Auto-generated constructor stub
	}

}
