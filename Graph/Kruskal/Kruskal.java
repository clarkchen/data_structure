package Kruskal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import basic.Edge;

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
		for(Iterator< Edge> i = g.edges.iterator();i.hasNext();)
		{
			Edge edge = i.next();
			edges.offer(edge);
		}
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
			System.out.print(i++); 
			rt.addEdge(e);
			
		}
		return rt;
	}
	public static kGraph init(int vertexNum)
	{
		kGraph G = new kGraph(vertexNum);

		G.addEdge(0, 1,10);
		G.addEdge(0, 5, 11);
		G.addEdge(1, 2, 18);
		G.addEdge(1, 6, 16);
		G.addEdge(1, 8, 12);
		G.addEdge(2, 3, 22);
		G.addEdge(2, 8, 8);
		G.addEdge(3, 4, 20);
		G.addEdge(3, 7, 16);
		G.addEdge(3, 8, 21);
		G.addEdge(4, 5,26);
		G.addEdge(4, 7,7);
		G.addEdge(5, 6, 17);
		G.addEdge(6, 7, 19);
		return G;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kGraph g =  Kruskal.init(9);
		Kruskal k = new Kruskal();
		g = k.runKruskal(g);
		g.printEdges();
	}

}
