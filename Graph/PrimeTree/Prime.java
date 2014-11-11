package PrimeTree;

import Dijskra.DijskraShortPath;
import basic.Graph;

/**
 * @author chenxi
 *  聚合类写法将距离更新和找寻最小值写在了一起了，时间复杂度比较与之前的，一个是N一个是 2N，下面这个更好一点
 *  
 */
public class Prime {
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
