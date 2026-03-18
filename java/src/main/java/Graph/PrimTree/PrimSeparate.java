package Graph.PrimTree;

import Graph.Dijkstra.DijkstraShortPath;
import Graph.basic.Graph;

import java.util.*;


/**
 * @author chenxi
 * Prim Tree 分步编程, 将Prime算法分开写成了三个步骤，思路较为清晰
 * 但是时间复杂度上变成了 2*N
 * 
 */
public class PrimSeparate {
	//put the selected node into the new graph, and set the dis to be 0
	public void add(int i ,int[] dis,int []pre, Graph rt )
	{
		//the first one
		if(i>0) rt.addEdge(i, pre[i],dis[i]);
		dis[i] = 0;
	}
	
	//uupdate the distance of related nodes and the reference node 
	protected void update(int n, int []dis, Graph G, int []pre)
	{
		int foo ;
		 for(int i =0;i<dis.length;i++)
		 {
			 if(i==n||dis[i]==0||G.AdjacentMatrix[n][i]==0) continue;
			 //if foo ==0 means that  n and are not connected 
			 foo = G.AdjacentMatrix[n][i];
			 
			 if( dis[i] > foo)
			 {
				 dis[i] = foo;
				 pre[i] = n;
			 }
		 }
	}
	
	//find the least distance 
	protected int findMin(int []dis)
	{
		int min = Integer.MAX_VALUE;
		for(int i =0;i<dis.length;i++)
		{
			//already in 
			if(dis[i]==0) continue;
			
			if(min==Integer.MAX_VALUE) min = i;
			if(dis[min]>dis[i])
			{
				min = i;
			}
		}
		return min;
	}
	
	public Graph runPrime(Graph G)
	{
		if(G==null || G.count==0)return null;
		if(G.count<3) return G;
		
		//Init Set and its value means the distance to set A;
		int [] dis =  new int[G.count];
		//If the value is not -1 and it means the node absorb it into A with the minimum lenght 
		int [] pre = new int[G.count];
		Graph rt = new Graph(G.count);
		for(int i=0;i<G.count;i++)
		{
			dis[i] =Integer.MAX_VALUE;

			pre [i] = -1;
		}
		int n = 0;
		
		int count = G.count;
		
		while(count>0)
		{
			
			this.add(n, dis, pre,rt);
			 
			this.update(n, dis, G, pre);
			 
			n = this.findMin(dis);
			
			count--;
		}
		return rt;
	}
 

}
