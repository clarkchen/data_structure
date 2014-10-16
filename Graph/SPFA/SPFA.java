package SPFA;

import java.util.LinkedList;
import java.util.Queue;

import basic.EdgePoint;
import basic.Graph;
import basic.GraphList;
import basic.GraphPoint;

//http://en.wikipedia.org/wiki/Shortest_Path_Faster_Algorithm



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
	
	public static GraphList init(){
		int v= 9;
		GraphList g  = new GraphList(v);
		g.addEdge(0, 1, 1,true);
		g.addEdge(0, 2, 5,true);
		g.addEdge(1, 2, 3,true); 
		g.addEdge(1, 3, 7,true);
		g.addEdge(1, 4, 5,true);
		g.addEdge(2, 4, 1,true);
		g.addEdge(2, 5, 7,true);
		g.addEdge(3, 6, 3,true);
		g.addEdge(3, 4, 2,true);
		g.addEdge(4, 5, 3,true);
		g.addEdge(4, 6, 6,true);
		g.addEdge(4, 7, 9,true);
		g.addEdge(5, 5, 5,true);
		g.addEdge(6, 7, 2,true);
		g.addEdge(6, 8, 7,true);
		g.addEdge(7, 8, 4,true);
		return g;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SPFA s = new SPFA();
		GraphList g = SPFA.init();
		int source = 0;
		int [] d = s.spfa(source, g);
		for (int i=0;i<d.length;i++)
		{
			if(i==source) continue;
			System.out.println("Node "+i+" to Source "+source+" distance is " + d[i]);
		}
		
	}

}
