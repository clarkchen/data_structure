package Graph.Dijkstra;

import Graph.basic.Graph;

/**
 * @author chenxi
 * Dijkstra 是单源最短路劲算法，也就是指定起点，然后求其他各个点到他的距离
 * 这部分代码，求解完最短距离之后，放到了 dis 数组中，并且产生 以最短距离为边的 一个新图
 * 
 * 需要的额外数据，Dis，Visited，Pre（用于建立图，方便回溯输出路径）
 * 算法流程：
 * 1. k点开始，设置 Visited，（点k表示最新更新的点）
 * 2. 更新k点周围的所有的没有被访问过的点（访问过的结点肯定具有更短的长度）
 * 3. 选取最小的点min，k,min 加入新图，min作为新的k点 回到步骤1
 * 
 */
public class DijkstraShortPath {
	int []dis;
 	public Graph shortestPath(int source,Graph g)
	{
		Graph rt = new Graph(g.count);
		int [] dis = new int [g.count] ;
		
		int [] visited = new int[g.count];
		int [] pre  = new int[g.count];
		int i,j;	
		for(i = 0;i<dis.length;i++)
		{
			visited [i] = 0;
			dis[i] = Integer.MAX_VALUE;
			pre [i] =-1;
		}
		dis[source] =  0;
		
		int k=source;
		for(i=0;i<g.count;i++)
		{
			visited[k] = 1;
			System.out.println(k);
			
			for(j=0;j<dis.length;j++)
			{
				if(visited[j] == 1) continue;
				if(g.AdjacentMatrix[k][j]==0) continue;
				if(dis[j]>dis[k]+g.AdjacentMatrix[k][j]){
					dis[j] = dis[k]+g.AdjacentMatrix[k][j];
					pre [j] = k;
				}
				
			}
			//选最小
			int min =Integer.MAX_VALUE;
			for(j=0;j<dis.length;j++){
				if(visited[j] == 1) continue;
				if(min > dis[j])
				{
					min = dis[j];
					k = j;
				}
			}
			
			if(min<Integer.MAX_VALUE){
			 	rt.addEdge(k,pre[k] , g.AdjacentMatrix[pre[k]][k]);
			}
		}
		this.dis = dis;
		return rt;
	}
	
	
 

}
