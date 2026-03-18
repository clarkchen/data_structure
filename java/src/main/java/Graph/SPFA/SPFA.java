package Graph.SPFA;

import java.util.LinkedList;
import java.util.Queue;

import Graph.basic.EdgePoint;
 import Graph.basic.GraphList;
 
/**
 * @author chenxi
 * 中国人原创算法，屌炸天
 * http://en.wikipedia.org/wiki/Shortest_Path_Faster_Algorithm
 * 当然最关键的问题，他能够轻松解决两点之间多条边的问题，而不需要做过多的判断
 * 想法超级自然，利用邻接链表的结构来做
 * 
 * 1. 源点入队列
 * 2. cur表示队首元素（dis是最新的值），弹出来
 * 3. 更新所有和 cur 相连接的点，如果被更新的点，切不在q中，压入q
 * 4. q不为空回到步骤2
 * 
 */
public class SPFA {
	public int [] spfa(int s, GraphList g  )
	{
		int dis[] = new int[g.count];
		for(int i=0;i<dis.length;i++) dis[i] = Integer.MAX_VALUE;
		Queue<Integer>  q =  new LinkedList<Integer>();
		q.offer(s);
		dis[s] = 0;
		while(!q.isEmpty())
		{
			int cur = q.poll();
			EdgePoint e = g.AdjecentList.get(cur).firstEdge;
			while(e!=null)
			{
				int alter = dis[cur] + e.weight;
				if(dis[e.index]> alter)
				{
					dis[e.index] = alter;
					if(!q.contains(e.index))
						q.offer(e.index);
				}
				e = e.next;
			}
		}
		return dis;
	}
}
