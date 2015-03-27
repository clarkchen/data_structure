package Graph.Floyd;
import Graph.basic.Graph;

/**
 * @author chenxi
 * Folyd 算法实际上是一个全局求解路径的方法，和Dijsktra不同， Folyd直接是计算全部点的最短路径
 * 其时间复杂度是 N^3 ，而且只有当整个算法遍历结束之后才能，得出最终的最短路径
 * 算法步骤简单粗暴
 * DIS[N][N]
 * 
 * for k in [1...N]
 * 	  for i in [1..N]
 *       for j in [1..N]
 *       	if( dis[i][j]<dis[i][k]+dis[k][i])
 *          	 dis[i][j] =  dis[i][k]+dis[k][i];
 *          
 *      
 * 就是这么暴力，但是可能书上没有讲太明白，这个动态规划，本质上实际上是一个三维的状态转移方程
 * http://zh.wikipedia.org/zh-cn/弗洛伊德算法   
 * D_{i,j,k}  = D_{i,k,k-1} + D{k,j,k-1}
 * 
 * Path[i][j] 表示 i 到 j ，j 前
 * 一位是多少，所以在原图上，如果相邻就设置为i，否则就是-1
 * 
 */
public class FolydShortPath {
	int [][]Dis;
	int [][]Path;
	static int max = 1000;
	public void runFolydShortPath(Graph g)
	{
		Dis =  g.AdjacentMatrix;
		Path =  new int[g.count][g.count];
		
		int i,j,k;
		for(i=0;i<g.count;i++)
		{
			for(j=0;j<g.count;j++)
			{
				
				if(Dis[i][j]==0) 
				{
					Dis[i][j] = FolydShortPath.max;
					Path[i][j] = -1;
				}
				else{
					Path[i][j] = i;
				}
			}
		}
		
		for(k=0;k<g.count;k++)
		{
			for(i=0;i<g.count;i++)
			{
				for(j=0;j<g.count;j++)
				{
					if(i==j) continue;
					 
					 if(Dis[i][j] >  Dis[i][k]+Dis[k][j])
					{
						Dis[i][j] = Dis[i][k]+Dis[k][j];
						Path[i][j] = Path[k][j];
					}
				}
				
			}
		}
		
	}
	public Graph getNewGraph(int source, Graph g)
	{
		Graph rt = new Graph(Dis.length);
 		for(int i = 0;i<g.count;i++)
		{
 			 if(i==source) continue;
			 if(Path[source][i] == source ) rt.addEdge( source,i, Dis[source][i]); 
			 else
			 {
				 int  j = i;
				 while(Path[source][j] != source)
				 {
					 rt.addEdge(j, Path[source][j],Dis[j][Path[source][j]]);
					 j = Path[source][j];
				 }
			 }
		 
		}
		return rt;
	}

}
