package Graph.PrimTree;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import Graph.basic.Graph;



/**
 * @author chenxi
 * Prime Tree 测试脚本
 */
public class PrimTreeTest {
	Graph G;
	@Before
	public void setUp() throws Exception {
		int vertexNum=9;
		G = new Graph(vertexNum);

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
		G.addEdge(3, 6, 24);
		
		G.addEdge(4, 5,26);
		G.addEdge(4, 7,7);
		G.addEdge(5, 6, 17);
		G.addEdge(6, 7, 19);
	}
	boolean validate(Graph G)
	{
		return G.getEdgeWeight(1, 0) == 10&&
				G.getEdgeWeight(5, 0)  == 11 && 
				G.getEdgeWeight(6,1) ==16 && 
				G.getEdgeWeight(8, 1)== 12 &&
				G.getEdgeWeight(8, 2) == 8 &&
				G.getEdgeWeight(7, 3) == 16 && 
				G.getEdgeWeight(7, 4) == 7 &&
				G.getEdgeWeight(7, 6) == 19 
				 ;
		 
		 
	}
	@Test
	public void test() {
		// TODO Auto-generated method stub
		Prim p2 = new Prim();
		Graph rt = p2.runPrime(G);
		//rt.printEdges();
		assertTrue(validate(rt));
		
		PrimSeparate p = new PrimSeparate();
		rt = p.runPrime(G);
		assertTrue(validate(rt));
	}

}
