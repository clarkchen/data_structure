package Graph.PrimTree;

import Graph.Dijkstra.DijkstraShortPath;
import Graph.basic.Graph;

/**
 * @author chenxi
 *  聚合类写法将距离更新和找寻最小值写在了一起了，时间复杂度比较与之前的，一个是N一个是 2N，下面这个更好一点
 *  其核心思是空集合A 和全是点的集合B， 不断从B中挑选符合条件的结点加入到A中，仍然是一种贪心算法
 *  算法流程：
 *  1. B中一个 p 点压入A(到A距离变为0)
 *  2. 更新点 所有与 p 相邻的点 到 A的距离, 以及这些点的前置点为 p
 *  3. 更新完成之后挑选最小的点 min，将 p,min 放入新图，min作为新的p点，回到步骤1
 *  
 */
public class Prim {
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
	 

}
