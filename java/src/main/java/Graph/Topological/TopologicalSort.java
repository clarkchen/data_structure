package  Graph.Topological;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import  Graph.basic.GraphList;
import  Graph.basic.GraphPoint;

public class TopologicalSort {
	
	
	GraphList glf = null;
	public static GraphList init()
	{
		GraphList rt =  new GraphList(14);
		
		rt.addEdge(0, 4);
		rt.addEdge(0, 5);
		rt.addEdge(0, 11);
		
		rt.addEdge(1, 4);
		rt.addEdge(1, 8);
		rt.addEdge(1, 2);
		
		rt.addEdge(2, 5);
		rt.addEdge(2, 6);
		rt.addEdge(2, 9);
		
		rt.addEdge(3, 2);
		rt.addEdge(3, 13);
		
		rt.addEdge(4, 7);

		rt.addEdge(5, 8);
		rt.addEdge(5, 12);
		
		rt.addEdge(6, 5);
		rt.addEdge(8, 7);
		
		rt.addEdge(9, 11);
		rt.addEdge(9, 10);
		
		rt.addEdge(10, 13);
		
		rt.addEdge(12, 9);
		
		return rt;
	}
	
	public void show(int i)
	{
		System.out.print(i+"-->");
	}
	public void show(ArrayList<GraphPoint> rt)
	{
		Iterator<GraphPoint > gp = rt.iterator();
		while(gp.hasNext())
		{
			show(gp.next().index);
		}
	}
	public ArrayList<GraphPoint> getTopologicalSort(GraphList glf)
	{
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<GraphPoint> rt = new ArrayList<GraphPoint>();
		Integer i;
		glf.findInZeros(s);
		while(!s.isEmpty())
		{
			i = s.pop();
			
			GraphPoint gp = glf.getPoint(i);
			
			glf.clearEdge(i);
			
			rt.add(gp);
			
			glf.findInZeros(s);
		};
		
		return rt;
	}
	
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphList glf =  TopologicalSort.init();
		TopologicalSort ts = new TopologicalSort();
		ts.show(ts.getTopologicalSort(glf));
		
	}

}
