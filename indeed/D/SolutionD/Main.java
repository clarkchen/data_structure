package D.SolutionD;

import java.util.*;
public class Main{
	class Node{
		int v,k,dep;
		ArrayList<Node> sons;
		public Node(int v,int k,int dep)
		{
			this.v = v;
			this.k = k;
			this.dep = dep;
			
			sons = new ArrayList<Node>();
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
		
		if(A==0) return 1;
		long temp = A;
		int i=0;
		while(temp>0) 
		{
			temp /=10;i++;
		}
			
		return i;
	}
	// return the i th element of A
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
	Node createTree()
	{
		int len  = getLen(A);
		Node empty = new Node(0, K, len);
		if(len<=K) return empty;
		if(numTypes(A)<=K) return empty;
		Queue<Node> q = new LinkedList<Main.Node>();
		q.offer(empty);
		Node cur = empty;
		
		ArrayList<Integer> ava = new ArrayList<Integer>();
		
		for(int i=len;i>0;i--)
		{
			while(!q.isEmpty()&& cur.dep==i)
			{
				cur = q.poll();
				int k = cur.k;
				if(k>1)
				{
					int f = getVbyindex(i);
					Node nn;
					if(ava.contains(f))
					{ 
						nn =  new Node(f,k,i-1);
					}
					else {
						nn= new Node(f,k-1,i-1);
						ava.add(f);
					}
					q.offer(nn);cur.sons.add(nn);
				}
				else if(k==1)
				{
					Node nn;
					for(int j=0;j<=9;j++)
					{
						if(ava.contains(j))
						{
							nn = new Node(j, k, i-1);
						}
						else if(i==len && j==0)
						{
							nn = new Node(0,k,i-1);
						}
						else 
						{
							nn = new Node(j,k-1,i-1);
						}
						q.offer(nn);cur.sons.add(nn);
					}
				}
				else if(k==0)
				{
					Node nn;
					for(int j=0;j<=9;j++)
					{
						if(ava.contains(j) || j==cur.v )
						{
							nn = new Node(j, k, i-1);
							q.offer(nn);cur.sons.add(nn);
						}
						
					}
				}
				
				cur = q.peek();
				
			}
		}
		
		return empty;
	}
	void getMin(Node start, long pre)
	{
		if(start.sons.size()==0)
		{
			long rt = pre + start.v*tens(start.dep);
			if(Math.abs(A-rt)<min) 
			{
				min =  Math.abs(A-rt);
				//System.out.println(rt);
			}
			return ;
		}
		for(Node s: start.sons)
		{
			getMin(s,pre+start.v*tens(start.dep));
		}
		
		
	}
	int answer()
	{
		Node start = this.createTree();
		if(start.sons.size()==0) return 0;
		getMin(start, 0);
		return (int)min;
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

