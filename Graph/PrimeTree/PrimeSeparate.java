package PrimeTree;

import Dijskra.DijskraShortPath;
import basic.Graph;

import java.util.*;
public class Prime {
	
	 
	//input the edges
	public static Graph init()
	{
		int vertexNum=9;
		Graph G = new Graph(vertexNum);

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
		G.addEdge(3, 6, 24);
		
		G.addEdge(4, 5,26);
		G.addEdge(4, 7,7);
		G.addEdge(5, 6, 17);
		G.addEdge(6, 7, 19);
		return G;
	}
	public void add(int iB ,int[] B,int []pre, Graph rt )
	{
		//the first one
		if(iB>0) rt.addEdge(iB, pre[iB],B[iB]);
		B[iB] = 0;
	}
	protected void update(int n, int []B, Graph G, int []pre)
	{
		 
		 for(int i =0;i<B.length;i++)
		 {
			 if(i==n||B[i]==0) continue;
			 int dis = G.AdjacentMatrix[n][i];
			 if(dis > 0 && B[i]> dis)
			 {
				 B[i] = dis;
				 pre[i] = n;
			 }
		 }
	}
	protected int findMin(int []B)
	{
		int min = Integer.MAX_VALUE;
		for(int i =0;i<B.length;i++)
		{
			if(B[i]==0) continue;
			if(min==Integer.MAX_VALUE) min = i;
			if(B[min]>B[i])
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
		
		//Init Set and its value means the lenght to set A;
		int [] B =  new int[G.count];
		//If the value is not -1 and it means the node absorb it into A with the minimum lenght 
		int [] pre = new int[G.count];
		Graph rt = new Graph(G.count);
		for(int i=0;i<G.count;i++)
		{
			B[i] =Integer.MAX_VALUE;

			pre [i] = -1;
		}
		int n = 0;
		
		int count = G.count;
		
		while(count>0)
		{
			
			this.add(n, B, pre,rt);
			 
			this.update(n, B, G, pre);
			 
			n = this.findMin(B);
			
			count--;
		}
		return rt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prime p = new Prime();
//		Graph G = p.init(9);
		Graph G = DijskraShortPath.init();
		G = p.runPrime(G);
		G.printEdges();
		
	}

}
