package Graph.basic;

import java.util.ArrayList;


public class GraphPoint {
	
	public int index;
	//入度
	public int in=0;
	
	public Boolean disabled = false;
	
	public EdgePoint firstEdge = null;
	public GraphPoint(int index)
	{
		this.index = index;
	}
	
	public void addEdge(int e,int weight)
	{
		EdgePoint temp =  new EdgePoint();
		temp.index = e;
		temp.weight = weight;
		temp.next = null;
		
		if(firstEdge==null){
			firstEdge = temp;
			return;
		}
		
		EdgePoint cur = firstEdge;
		while (cur.next!=null)
		{
			cur = cur.next;
		}
		cur.next = temp;
	}
	
	public void delEdge(int e)
	{
		EdgePoint pre = firstEdge;
		if (pre ==null ) return;
		if(pre.index==e) firstEdge = null;
		
		EdgePoint ep = pre.next;
		
		while(ep.next!=null && ep.index!=e)
		{
			pre = pre.next;
			ep =ep.next;
		}
		pre.next = null;
	}


	
	
	
}
