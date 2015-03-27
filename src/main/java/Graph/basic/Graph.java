package Graph.basic;

/**
 * XI CHEN
 * 
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	public int[][]AdjacentMatrix =null;
	public int[] visited = null;
	public int count = 0;
	public Graph(int vertexNum)
	{
		AdjacentMatrix = new int[vertexNum][vertexNum];
		for(int i=0;i<AdjacentMatrix.length;i++)
		{
			for(int j=0;j<AdjacentMatrix[i].length;j++)
				AdjacentMatrix[i][j] = 0;
		}
		this.count = vertexNum;
		this.initVisit();
	}
	public void initVisit()
	{
		this.visited = new int[count];
	}
	public int getEdgeWeight(int a, int b)
	{
		return AdjacentMatrix[a][b];
	}
	public void addEdge(int a, int b)
	{
		AdjacentMatrix[a][b] = AdjacentMatrix[b][a] = 1;
	}
	public void addEdge(int a, int b, int v)
	{
		AdjacentMatrix[a][b] = AdjacentMatrix[b][a] = v;
	}
	public void delEdge(int a ,int b)
	{	
		AdjacentMatrix[a][b] = AdjacentMatrix[b][a] = 0;
	}
	public void visit(int Node)
	{
		this.visited[Node] = 1;
		System.out.println("Node "+ Node +" is visited");
	}
	public void BFS()
	{
		this.initVisit();
		for(int i = 0 ;i< count;i++)
		{
			if(visited[i] == 1) continue;
			BFSFromNode(i);
		}
	}
	protected void BFSFromNode(int start)
	{
		if(visited[start] == 1) return;
		Queue<Integer> q= new LinkedList<Integer>();
		q.offer(start);
		int i =0;
		while(!q.isEmpty() && i< count )
		{
			int cur = q.poll();
			this.visit(cur);
			int j=0;
			while(j<count)
			{
				if(this.AdjacentMatrix[cur][j] ==1 && this.visited[j]==0)
				{
					q.offer(j);
				}
				j++;
			}
			i++;
		}
		
	}
	//R means the Recusion form
	//NR means the non-recusion form
	public void DFS(char type)
	{
		this.initVisit();
		for(int j =0;j<count;j++)
		{
			if(this.visited[j]==1) continue;
			if(type=='R') DFSFromNode_R(j);
			else if(type == 'N') DFSFromNode_NonR(j);
		}
	}
	protected void DFSFromNode_R(int start)
	{
		if(this.visited[start]==1) return;
		visit(start);
		int j=0;
		while(j<count)
		{
			if(this.AdjacentMatrix[start][j]==1 && visited[j]==0)
			{
				DFSFromNode_R(j);
			}
			j++;
		}
	}
	protected void DFSFromNode_NonR(int start)
	{
		if(visited[start] == 1) return;
		Stack<Integer>  s = new Stack<Integer>();
		s.push(start);
		int i = 0;
		while (!s.isEmpty()&& i<count)
		{
			int cur = s.pop();
			visit(cur);
			int j=0;
			while(j<count)
			{
				if(this.AdjacentMatrix[cur][j]==1 && this.visited[j]==0)
				{
					s.push(j);
				}
				j++;
			}
			i++;
		}
	}
	public void printEdges()
	{
		for(int i=0;i<this.count;i++)
		{
			for(int j = i+1;j<this.count;j++)
			{
				if(this.AdjacentMatrix[i][j]>0)
				System.out.println("Node "+j +" Node "+i+" Edge " + this.AdjacentMatrix[i][j]);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g =new Graph(5);
		g.addEdge(0, 1);
//		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
//		g.addEdge(4, 2);
		System.out.println("BFS");
		g.BFS();
		System.out.println("DFS non");
		g.DFS('N');
		
		System.out.println("DFS R");
		g.DFS('R');
		
		System.out.println("Show Edges");
		g.printEdges();
	
	}

}
