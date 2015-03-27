package Graph.Floyd;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import Graph.basic.Graph;
public class FolydShortPathTest {

	Graph g ;
	@Before
	public void setUp() throws Exception {
		int v= 9;
		g = new Graph(v);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 5);
		g.addEdge(1, 2, 3); 
		g.addEdge(1, 3, 7);
		g.addEdge(1, 4, 5);
		g.addEdge(2, 4, 1);
		g.addEdge(2, 5, 7);
		g.addEdge(3, 6, 3);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 6);
		g.addEdge(4, 7, 9);
		g.addEdge(5, 5, 5);
		g.addEdge(6, 7, 2);
		g.addEdge(6, 8, 7);
		g.addEdge(7, 8, 4);
	}
	boolean valid(Graph G)
	{
		 
		return  G.getEdgeWeight(1, 0) == 1&&
				G.getEdgeWeight(1, 2) == 3 && 
				G.getEdgeWeight(2,4) == 1 && 
				G.getEdgeWeight(3, 4)== 2 &&
				G.getEdgeWeight(3, 6) == 3 &&
				G.getEdgeWeight(7, 6) == 2 && 
				G.getEdgeWeight(7, 8) == 4 &&
				G.getEdgeWeight(4, 5) == 3; 
	}
	@Test
	public void test() {
		FolydShortPath fsp = new FolydShortPath();
		fsp.runFolydShortPath(g);
		Graph rt = fsp.getNewGraph(0, g);
		assertTrue(valid(rt));;
		rt.printEdges();
	}

}
