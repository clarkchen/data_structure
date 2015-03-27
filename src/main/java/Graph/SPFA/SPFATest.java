package Graph.SPFA;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import Graph.basic.Graph;
import Graph.basic.GraphList;
public class SPFATest {
	GraphList g;
	@Before
	public void setUp() throws Exception {
		int v= 9;
		g  = new GraphList(v);
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
	}

	boolean valid(int []dis)
	{

		return  dis[0] == 0 &&
				dis[1] == 1 &&
				dis[2] == 4 &&
				dis[3] == 7 &&
				dis[4] == 5 &&
				dis[5] == 8 && 
				dis[6] == 10 && 
				dis[7] == 12 && 
				dis[8] == 16 ; 
	}
	@Test
	public void test() {
		SPFA s = new SPFA();
		int source = 0;
		int [] d = s.spfa(source, g);
		assertTrue(valid(d));
		for (int i=0;i<d.length;i++)
		{
			if(i==source) continue;
			System.out.println("Node "+i+" to Source "+source+" distance is " + d[i]);
		}
	}

}
