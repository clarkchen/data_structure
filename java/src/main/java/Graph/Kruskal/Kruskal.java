package Graph.Kruskal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import Graph.basic.Edge;

/**
 * @author chenxi
 * Kruskal 算法和点完全没有关系了，直接就是边的情况处理，在针对边多点少的情况下应该是最正确的选择
 * 当然如果每次都是挑选最小的话，需要借助优先队列这一数据结构来实现
 * 其核心思想仍然是空集合A 和全是点的集合B， 不断从B中挑选符合条件的结点加入到A中，仍然是一种贪心算法
 * 但虽然是贪心算法，但其整好符合最优子结构，也就是（最优子结构的意思是局部最优解能决定全局最优解），所以得出的结论就是全局最优解
 * 
 * 算法流程：
 * 遍历队列中的所有边
 * 1. 将图中的所有边都压入优先队列中
 * 2. 每次选取最小的边，看是否会和原来的结点形成环（并查集）
 * 3. 如果不形成环，则加入
 * 
 */
public class Kruskal {
	public int Find(int f, int []parent)
	{
		return f!=parent[f]?parent[f] = Find(parent[f],parent): parent[f];
	}
	public Boolean Union(int []parent, int f, int s)
	{
		int father=  Find(f,parent),son =Find(s,parent);
		if( father == son ) return false;
		parent[son] = father; return true;
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
		int edgeCount =0;
		while(!edges.isEmpty()){
			
			if(edgeCount++==g.count-1) break;
			
			e = edges.poll();
			
			if(this.Union(parent, e.s, e.e) ==false){
				continue;
			}
 			rt.addEdge(e);	
 			
		}
		return rt;
	}
	 


}
