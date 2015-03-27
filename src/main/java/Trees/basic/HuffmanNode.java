package Trees.basic;

public class HuffmanNode {
	public String Value;
	public int count;
	public HuffmanNode left,right;
	public HuffmanNode(String Value , int count)
	{
		this.Value = Value;
		this.count = count;
		left = right = null;
	}
	public Boolean isLeaf()
	{
		return !this.Value.equals("no");
	}
}
