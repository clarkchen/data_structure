package Floyd;

import Dijskra.DijskraShortPath;
import basic.Graph;

public class FolydShortPath {
	int [][]Dis;
	int [][]Pre;
	static int max = 1000;
	public void runFolydShortPath(Graph g)
	{
		Dis =  g.AdjacentMatrix;
		Pre =  new int[g.count][g.count];
		
		int i,j,k;
		for(i=0;i<g.count;i++)
		{
			for(j=0;j<g.count;j++)
			{
				
				if(Dis[i][j]==0) 
				{
					Dis[i][j] = FolydShortPath.max;
					 
				}
				Pre[j][i] = i;
			}
		}
		
		for(k=0;k<g.count;k++)
		{
			for(i=0;i<g.count;i++)
			{
				for(j=0;j<g.count;j++)
				{
					if(i==j) continue;
					 
					 if(Dis[i][j] >  Dis[i][k]+Dis[k][j])
					{
						Dis[i][j] = Dis[i][k]+Dis[k][j];
						Pre[i][j] = Pre[i][k];
					}
				}
				
			}
		}
		
	}
	public Graph getNewGraph(int source, Graph g)
	{
		Graph rt = new Graph(Dis.length);
 		for(int i = 0;i<g.count;i++)
		{
 			 if(i==source) continue;
			 if(Pre[i][source] == source ) rt.addEdge( source,i, Dis[source][i]); 
			 else
			 {
				 int  j = i;
				 while(Pre[j][source] != source)
				 {
					 rt.addEdge(j, Pre[j][source],Dis[j][Pre[j][source]]);
					 j = Pre[j][source];
				 }
			 }
		 
		}
		return rt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = DijskraShortPath.init();
		FolydShortPath fsp = new FolydShortPath();
		fsp.runFolydShortPath(g);
		Graph rt = fsp.getNewGraph(0, g);
		rt.printEdges();
	}

}
