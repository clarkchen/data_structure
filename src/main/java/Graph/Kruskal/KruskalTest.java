package Graph.Kruskal;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import Graph.basic.Edge;
import Graph.basic.EdgePoint;
import Graph.basic.Graph;
import Graph.basic.GraphList;
import Graph.basic.GraphPoint;


public class KruskalTest {
	kGraph G;
	@Before
	public void setUp() throws Exception {
		int vertexNum = 9;
		G = new kGraph(vertexNum);
		G.addEdge(0, 1,10);
		G.addEdge(0, 5, 11);
		G.addEdge(1, 2, 18);
		G.addEdge(1, 6, 16);
		G.addEdge(1, 8, 12);
		G.addEdge(2, 3, 22);
		G.addEdge(2, 8, 8);
		G.addEdge(3, 4, 20);
		G.addEdge(3, 7, 16);
		G.addEdge(3, 8, 21);
		G.addEdge(4, 5,26);
		G.addEdge(4, 7,7);
		G.addEdge(5, 6, 17);
		G.addEdge(6, 7, 19);
	 
	}
	boolean validEdge(Edge ed, int s, int e, int w)
	{
		return ed.s == s && ed.e == e && ed.weight ==w;
	}
	public boolean Validate(kGraph g)
	{
		
		for(Iterator< Edge>i = g.edges.iterator();i.hasNext();)
		{
			Edge edge = i.next();
			if( !validEdge(edge, 4, 7, 7)&&
				!validEdge(edge,2,8,8) &&
				!validEdge(edge, 0, 1, 10) &&
				!validEdge(edge, 0 ,5, 11) &&
				!validEdge(edge, 1, 8, 12) &&
				!validEdge(edge, 1, 6, 16) &&
				!validEdge(edge, 3, 7, 16) && 
				!validEdge(edge, 6, 7, 19) ) return false;
 		}
		return true;
		 
	}
	@Test
	public void test() {
		Kruskal k = new Kruskal();
		kGraph g = k.runKruskal(G);
		g.printEdges();
		assertTrue(Validate(g));
		System.out.println();
	}
	
	 


}
