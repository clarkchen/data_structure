package Graph.Topological;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import  Graph.basic.EdgePoint;
import  Graph.basic.GraphList;
import  Graph.basic.GraphPoint;

public class KeyPath {
	int [] etv;
	int [] ltv;
	 
	public static GraphList init()
	{
		
		GraphList rt =new GraphList(10);
		
		rt.addEdge(0, 1, 3);
		rt.addEdge(0, 2, 4);
		rt.addEdge(1, 4, 6);
		rt.addEdge(1, 3, 5);
		
		rt.addEdge(2, 3, 8);
		rt.addEdge(2, 5, 7);
		
		rt.addEdge(3, 4, 3);
		rt.addEdge(4, 6, 9);
		rt.addEdge(4, 7, 4);
		
		rt.addEdge(5, 7, 6);
		rt.addEdge(6, 9, 2);
		rt.addEdge(7, 8, 5);
		rt.addEdge(8, 9, 3);
		return rt;
		
	}
	public  void initVariables(int count)
	{
		etv = new int [count];
		ltv = new int [count];
		 
		
	}
	
	public Stack<GraphPoint> TopologicalSort(GraphList glf)
	{
		Stack<Integer> s = new Stack<Integer>();
		Stack<GraphPoint> rt = new Stack<GraphPoint>();
		
		Integer i;
		glf.findInZeros(s);
		 
		while(!s.isEmpty())
		{
			i = s.pop();
			
			GraphPoint gp = glf.getPoint(i);
			
			rt.push(gp);
			
			//clear edge and updte etv
			EdgePoint e =  gp.firstEdge;
			while (e!=null)
			{
				int k = e.index;
				
				if((--glf.getPoint(k).in)==0 )
				{
					
					s.push(k);
				}
				
				if(etv[k] < etv[gp.index] + e.weight )
				{
					etv[k] =  etv[gp.index] + e.weight;
				}
				
				e = e.next;
			}
			
			
		};
		
		return rt;
	}
	
	public void getKeyPath(GraphList glf)
	{
		
		Stack<GraphPoint> s  = TopologicalSort(glf);
		Integer i;
		for(i=0;i<ltv.length ;i++)
		{
			ltv[i] = etv[etv.length-1];
		}
		while(!s.isEmpty())
		{
			GraphPoint gp = s.pop();
			
			EdgePoint e =  gp.firstEdge;
			while (e!=null)
			{
				int k = e.index;
				
				if(ltv[gp.index] > ltv[k] - e.weight )
				{
					ltv[gp.index] = ltv[k] - e.weight;
				}
				
				e = e.next;
			}
		}
		
		
		 
		//构造边的时间s
		int ete,lte;
		for (i=0;i<glf.count;i++)
		{
			GraphPoint gp = glf.getPoint(i);
			EdgePoint e =  gp.firstEdge;
			while(e!=null)
			{
				int k = e.index;
				
				ete = etv[i];
				lte = ltv[k] - e.weight;
				
				if(ete == lte)
				{
					System.out.println("Node "+i+" to Node " + k+" with Edge "+e.weight);
				}
				
				e= e.next;
			}
			
		}
		 
	}
	public void test(GraphList glf)
	{
		Stack<GraphPoint> s  = TopologicalSort(glf);
		
		Iterator<GraphPoint> i = s.iterator();
		while (i.hasNext())
		{
			GraphPoint gp = i.next();
			System.out.print(gp.index+"-->");
		}
		System.out.println();
		
		for(int j = 0;j<etv.length;j++)
		{
			System.out.print(etv[j]+"  ");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyPath kp = new KeyPath();
		GraphList gl = kp.init();
		kp.initVariables(gl.count);
		//kp.test(gl);
		kp.getKeyPath(gl);
		
	}

}
