package Kruskal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import basic.Edge;

/**
 * @author chenxi
 * Kruskal 算法和点完全没有关系了，直接就是边的情况处理，在针对边多点少的情况下应该是最正确的选择
 * 
 */
public class Kruskal {
	public int Find(int f, int []parent)
	{
		if (f!=parent[f]) {
			 parent[f] = Find(parent[f],parent);
		}
		return parent[f];
	}
	public Boolean Union(int []parent, int f, int s)
	{
		int father=  Find(f,parent);
		int son =Find(s,parent) ;
		if( father == son ) return false;
		parent[son] = father; 
		return true;
	}
	
	protected PriorityQueue<Edge> getPQ(kGraph g)
	{
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>(11, new Comparator<Edge>() {
			public int compare(Edge h1,Edge h2)
			{
				return h1.weight-h2.weight;
			}
		});
		for(Edge edge: g.edges) edges.offer(edge);
	 	return edges;
	}
	
	public kGraph runKruskal(kGraph g)
	{
		kGraph rt = new kGraph(g.count);
		int [] parent  =  new int [g.count];
		for(int i =0 ;i<parent.length;i++) parent[i] = i;
	
		PriorityQueue<Edge> edges = this.getPQ(g);
		Edge e =null;
		int i=0;
		while(!edges.isEmpty()){
			
			e = edges.poll();
			
			if(this.Union(parent, e.s, e.e) ==false){
				continue;
			}
 			rt.addEdge(e);			
		}
		return rt;
	}
	 


}
