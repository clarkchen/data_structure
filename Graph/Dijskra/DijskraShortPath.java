package Dijskra;

import basic.Graph;

public class DijskraShortPath {
	public static Graph init(){
		int v= 9;
		Graph g  = new Graph(v);
		
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 5);
		g.addEdge(1, 2, 3); 
		g.addEdge(1, 3, 7);
		g.addEdge(1, 4, 5);
		g.addEdge(2, 4, 1);
		g.addEdge(2, 5, 7);
		g.addEdge(3, 6, 3);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 6);
		g.addEdge(4, 7, 9);
		g.addEdge(5, 5, 5);
		g.addEdge(6, 7, 2);
		g.addEdge(6, 8, 7);
		g.addEdge(7, 8, 4);
		return g;
	}
	
	public Graph shortestPath(int source,Graph g)
	{
		Graph rt = new Graph(g.count);
		int [] dis = new int [g.count] ;
		
		int [] visited = new int[g.count];
		int [] pre  = new int[g.count];
		int i,j;
		dis[source] =  0;
		visited[source] = 1;
		for(i = 1;i<dis.length;i++)
		{
			visited [i] = 0;
			dis[i] = Integer.MAX_VALUE;
			pre [i] =-1;
		}
		int k=source;
		for(i=0;i<g.count;i++)
		{
			
			for(j=0;j<dis.length;j++)
			{
				if(visited[j] == 1) continue;
				if(g.AdjacentMatrix[k][j]==0) continue;
				if(dis[j]>dis[k]+g.AdjacentMatrix[k][j]){
					dis[j] = dis[k]+g.AdjacentMatrix[k][j];
					pre [j] = k;
				}
			}
			int min =Integer.MAX_VALUE;
			
			for(j = 0;j<dis.length;j++)
			{
				if(visited[j] == 0 && min > dis[j])
				{
					min = dis[j];
					k = j;
				}
			}
			visited[k] = 1;
			rt.addEdge(k,pre[k] , g.AdjacentMatrix[pre[k]][k]);
			
		}
		return rt;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijskraShortPath dsp = new DijskraShortPath();
		Graph g = dsp.init();
		Graph rt =  dsp.shortestPath(0, g);
		rt.printEdges();
	}

}
