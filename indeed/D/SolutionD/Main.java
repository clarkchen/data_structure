package D.SolutionD;

import java.util.*;

public class Main{
	class Node{
		int v,k,dep;
		ArrayList<Node> sons;
	
		//和真实值之间的差距
		long margin;
		
		//记录该分支上能取的k=1时的点
		int ava=-1;
		
		//最小记录
		ArrayList<Node> minSon = new ArrayList<Node>();
		long min=Long.MAX_VALUE;
		
		
		public Node(int v,int k,int dep)
		{
			this.v = v;
			this.k = k;
			this.dep = dep;
			margin = 0;
			sons = new ArrayList<Node>();
			
		}
		public Node(int v,int k,int dep,long pre, int f)
		{
			this.v = v;
			this.k = k;
			this.dep = dep;
			margin = pre + (v-f) * tens(dep);
			sons = new ArrayList<Node>();			
		}
		public Node(int v,int k,int dep,long pre, int f, int ava)
		{
			this.v = v;
			this.k = k;
			this.dep = dep;
			margin = pre + (v-f) * tens(dep);
			sons = new ArrayList<Node>();	
			this.ava = ava;
		}
		
		//used for debuging
		public long getvalue()
		{
			
			return (A+margin)/tens(dep);
		}
		
		//添加子节点的同时，记录最小值
		public void addSon(Node son)
		{
			if(son==null) return;
			
			if(Math.abs(son.margin)<=min){ 
				min = Math.abs(son.margin);
				minSon.add(son);
			}
			sons.add(son);
		}
		
	
	}
	
	//10^n
	long tens(int n)
	{
		return (long) Math.pow(10, n);
	}
	long A;
	int K;
	String As;
	long min;
	public Main(long A, int K)
	{
		this.A = A;
		As = String.valueOf(A);
		this.K = K;
		min = Long.MAX_VALUE;
	}
	//获取字符长度
	int getLen(long A)
	{
		return As.length();
	}
	// return the i th element of A10
	int getVbyindex(int i)
	{
		return As.charAt(As.length()-i)-'0' ;
	}
	int numTypes(long A)
	{
		ArrayList<String> rt = new ArrayList<String>();
		for(int i=0;i<As.length();i++)
		{
			String t1 =String.valueOf(As.charAt(i));
			if(!rt.contains(t1)) rt.add(t1);
		}
		return rt.size();
	}
	
	//BFS + 剪枝
	Node createTree()
	{
		int len  = getLen(A);
		Node empty = new Node(0, K, len);
		if(len<=K) return empty;
		if(numTypes(A)<=K) return empty;
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(empty);
		Node cur = empty;
		
		ArrayList<Integer> ava = new ArrayList<Integer>();
		int i;
		for( i=len;i>0;i--)
		{
			int f = getVbyindex(i);
			long layerMin  = Long.MAX_VALUE;
			ArrayList<Node> Layer =  new ArrayList<Node>();
			int k=Integer.MIN_VALUE;
			while(!q.isEmpty()&& cur.dep==i)
			{
				cur = q.poll();
				k = cur.k;
				
				if(k>1)
				{
					Node nn;
					if(ava.contains(f))
					{ 
						nn =  new Node(f,k,i-1,cur.margin,f);
					}
					else {
						nn= new Node(f,k-1,i-1,cur.margin,f);
						ava.add(f);
					}
					q.offer(nn);cur.addSon(nn);
				}
				else if(k==1)
				{
					Node nn;
					for(int j=0;j<=9;j++)
					{
						nn =null;
						if(ava.contains(j))
						{
							nn = new Node(j, k, i-1,cur.margin,f);
							cur.addSon(nn);
						}
						else if(i==len && j==0 && f==1)
						{
							if(getVbyindex(i-1)==0){
								nn = new Node(0,k,i-1,cur.margin,f,j);
								cur.addSon(nn);
							}
						}
						else 
						{
							nn = new Node(j,k-1,i-1,cur.margin,f,j);
							cur.addSon(nn);
						}
					
					}
					if((len-i)<empty.k)
						for(Node n: cur.sons) q.offer(n);
					else 
						Layer.addAll(cur.minSon);
				}
				else if(k==0)
				{
					for(int j=0;j<=9;j++)
					{
						if(ava.contains(j)||j== cur.ava)
						{
							cur.addSon(new Node(j, k, i-1,cur.margin,f,cur.ava));
						}
						
					}
					
					Layer.addAll(cur.minSon);
					 
				}
				cur = q.peek();
			}
			if(Layer.size()>0){
				for(int m=0;m<5;m++){
					long tempMin=  Long.MAX_VALUE;
					for(Node n: Layer)
					{
						if(!q.contains(n)&&Math.abs(n.margin)<tempMin)
						{
							tempMin = Math.abs(n.margin);
						}
					}
					for(Node n: Layer)
					{
						if(Math.abs(n.margin)==tempMin)
						{
							q.offer(n);
						}
					}
				}
				cur  =q.peek();
			}
		}
		min = Long.MAX_VALUE;
		while (!q.isEmpty())
		{
			cur =q.poll();
			if(Math.abs(cur.margin)<min)
			{
				min = Math.abs(cur.margin);
			}
		}
		 
		
		return empty;
	}
	
	long answer()
	{
		Node start = this.createTree();
		if(start.sons.size()==0) return 0;
//		System.out.println(A+min);
//		System.out.println(A-min);
//		
		return min;
	}
	
    public static void main(String[] args){
 
    	Scanner sc = new Scanner(System.in);
	    long a = sc.nextLong();
	    int k = sc.nextInt();
	    Main m = new Main(a,k);
	    // output
	    System.out.println( m.answer());
    }
}

//987654321987639 2
//
//100000000000000 1
//1

