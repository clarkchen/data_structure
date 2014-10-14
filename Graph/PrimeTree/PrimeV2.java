package PrimeTree;

import Dijskra.DijskraShortPath;
import basic.Graph;

public class PrimeV2 {
	public Graph runPrime(Graph g)
	{
		Graph rt  = new Graph(g.count);
		int []distance = new int[g.count];
		int pre[] = new int[g.count];
		for(int i=0;i<distance.length;i++) distance[i]= Integer.MAX_VALUE;
		int cur =0;
		do{
			distance[cur] = 0;
			int min = Integer.MAX_VALUE;
			int minI=min;
			for(int i=0;i<g.count;i++)
			{
				if(distance[i]>0)
				{
					if(g.AdjacentMatrix[i][cur]!=0 && distance[i]>g.AdjacentMatrix[i][cur] ){
						distance[i] = g.AdjacentMatrix[i][cur];
						pre[i] = cur;
					}
					if(min> distance[i])
					{
						min = distance[i];
						minI= i;
					}
				}
			}
			
			cur = minI;
			if(cur!=Integer.MAX_VALUE)
				rt.addEdge(cur, pre[cur], min);
			
		}while(cur!=Integer.MAX_VALUE);
		return rt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeV2 p = new PrimeV2();
 		Graph G = Prime.init();
		 
 		Graph rt = p.runPrime(G);
		rt.printEdges();
	}

}
