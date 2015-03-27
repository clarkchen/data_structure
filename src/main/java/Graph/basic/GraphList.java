
package Graph.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphList {
	//each element is just a GraphPoint 
	//The linked list is a varable of GraphPoint
	public ArrayList<GraphPoint> AdjecentList=null;
	public int [] visited =  null;
	public int count = 0;
	
	//public int edgeCount = 0;
	public GraphList(int num)
	{
		AdjecentList  = new ArrayList<GraphPoint>(num);
		visited = new int [num];
		for(int i=0;i<num;i++)
		{
			GraphPoint glf = new GraphPoint(i);
			AdjecentList.add(glf);
			visited[i] = 0;
		}
		count = num;
	}
	void initVist()
	{
		visited = new int[count];
	}
	public void activatePoints()
	{
		for(Iterator<GraphPoint> index = this.AdjecentList.iterator();index.hasNext();)
		{
			
			GraphPoint cur = index.next();
			cur.disabled = false;
		}
	}
	public GraphPoint getPoint(int i)
	{
		GraphPoint cur = this.AdjecentList.get(i);
		if(!cur.disabled) return cur;
		return null;
		//return this.AdjecentList.get(i);
	}
	public void removeNode(int i)
	{
		getPoint(i).disabled = true;
	}
	
	public  void addEdge(int start, int end, int weight)
	{
		GraphPoint s = this.getPoint(start);
		s.addEdge(end, weight);
		GraphPoint e = this.getPoint(end);
	 	e.in++;
 
	}
	public void addEdge(int start, int end ,int weight, Boolean undir)
	{
		this.addEdge(start, end, weight);
		if(undir==true)
		{
			this.addEdge(end,start , weight);
		}
		 
	}
	public void clearEdge(int start)
	{
		GraphPoint cur = this.getPoint(start);
		
		EdgePoint ep = cur.firstEdge;
		
		if (ep ==null )
		{
			this.removeNode(start);
			return;
		}
		while(ep!=null )
		{
			this.getPoint(ep.index).in--;
			ep = ep.next;
		}
		this.removeNode(start);
	}
	public  void addEdge(int start, int end)
	{
		GraphPoint s = this.getPoint(start);
		s.addEdge(end, 1);
		GraphPoint e = this.getPoint(end);
	 	e.in++;
		
	}
	public void findInZeros(Stack<Integer> s)
	{
		for(Iterator<GraphPoint> i = this.AdjecentList.iterator();i.hasNext();)
		{
			
			GraphPoint cur = i.next();
			if(!cur.disabled && cur.in==0 && visited[cur.index]==0)
			{
				visited[cur.index] = 1;
				s.push(cur.index);
			}
		}
	}
	void visit(int start)
	{
		System.out.println("Visit Node "+start);
		visited[start] = 1;
	}
	
	public void DFS_FROM(int start)
	{
		if(visited[start]==1) return ;
		visit(start);
		EdgePoint ep = AdjecentList.get(start).firstEdge;
		while (ep!=null)
		{
			if(visited[ep.index]==0)
			{
				DFS_FROM(ep.index);
			}
			ep = ep.next;
		}
	}
	
	public void DFS()
	{
		this.initVist();
		for(int i=0;i<AdjecentList.size();i++)
		{
			DFS_FROM(i);
		}
	}
	
	public void BFS()
	{
		this.initVist();
		for(int i=0;i<AdjecentList.size();i++){
			if(visited[i] ==1) continue;
			Queue<GraphPoint> q =  new LinkedList<GraphPoint>();
			q.offer(this.AdjecentList.get(i));
			
			while(!q.isEmpty())
			{
				GraphPoint gp =  q.poll();
				visit(gp.index);
				EdgePoint e = gp.firstEdge;
				while(e!=null)
				{
					if(visited[e.index]==0)
					{
						q.offer(this.AdjecentList.get(e.index));
					}
					e = e.next;
				}
			}
		}
	}
	public void printEdges()
	{
		for(GraphPoint gp: AdjecentList)
		{
			EdgePoint ep = gp.firstEdge;
			while(ep!=null)
			{
				System.out.println("Node "+gp.index+" Node "+ep.index+" Edge "+ep.weight);
				ep = ep.next;
			}
		}
	}
	public static void main(String [] args)
	{
		GraphList gl = new GraphList(5);
		gl.addEdge(0, 1);
		
		gl.addEdge(0, 2, 5);
		gl.addEdge(3, 2);
		gl.addEdge(0, 4);
 		gl.addEdge(2,3);
		gl.DFS();
		
	}
}
