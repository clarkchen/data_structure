package Trees.traverse;
import Trees.basic.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Tree {
	public Node root =null;
	public void createTree(int a[])
	{
		if (a.length==0) return ;
		if(root == null) 
		{
			root = new Node(a[0]);
		}
		int i =0;
		Node cur = null;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		//Node left,right;
		while(i<a.length)
		{
			cur = q.poll();
			if(2*i+1<a.length){
				cur.left = new Node(a[2*i+1]) ;
				q.offer(cur.left);
			}
			if(2*i+2 < a.length)
			{
				cur.right = new Node(a[2*i+2]);
				q.offer(cur.right);
			}
			
			i++;
			
		}
	}
	public void visit(Node n)
	{
		n.visited=1;
		System.out.print(n.Value+" ");
	}
	public void BFS(Node Root)
	{
		if(Root ==null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		Node cur ;
		while(!q.isEmpty())
		{
			cur = q.poll();
			visit(cur);
			if(cur.left!=null) q.offer(cur.left);
			if(cur.right!=null) q.offer(cur.right);
		}
		
	}
	
	public void preOrder(Node Root)
	{
		if(Root ==null) return;
		visit(Root);
		preOrder(Root.left);
		preOrder(Root.right);
	}
	
	public void preOrder2(Node Root)
	{
		if(Root ==null) return;
		Stack<Node> s = new Stack<Node>();
		s.push(Root);
		Node cur;
		while (!s.isEmpty())
		{
			cur = s.pop();
			visit(cur);
			if(cur.right!=null) s.push(cur.right);
			if(cur.left!=null) s.push(cur.left);
		}
	}
	public void midOrder(Node Root)
	{
		if(Root==null) return;
		midOrder(Root.left);
		visit(Root);
		midOrder(Root.right);
	}
	//注意栈内变化，模拟栈内变化
	public void midOrder3(Node Root)
	{	
		if(Root==null) return;
		Stack<Node> s = new Stack<Node>();
		Node cur = Root;
		while(cur!=null||!s.isEmpty())
		{
			//左结点访问结束的标志是 pre为空
			while(cur!=null)
			{
				s.push(cur);
				cur = cur.left;
			}
			if(!s.isEmpty())
			{
				cur = s.pop();
				visit(cur);
				cur = cur.right;
			}
			
		}
	}
	
	public void postOrder(Node Root)
	{
		if(Root==null) return;
		postOrder(Root.left);
		postOrder(Root.right);
		visit(Root);
	}
	
	public void postOrder3(Node Root)
	{
		if(Root==null) return;
		this.recoverVisited(Root);
		Stack<Node> s = new Stack<Node>();
		Node cur = Root;
		while((cur!=null&& cur.visited==0)||!s.isEmpty())
		{
			//左结点访问结束的标志是 pre为空
			while(cur!=null && cur.visited==0)
			{
				s.push(cur);
				cur = cur.left;
				
			}
			if(!s.isEmpty())
			{
				cur = s.pop();
					if (cur.right!=null && cur.right.visited==0) {
					s.push(cur);
					cur = cur.right;
				}
				else visit(cur);
				
				
			}
			
		}
	}
	
	void recoverVisited(Node Root)
	{
		if(Root ==null) return;
		Root.visited = 0;
		recoverVisited(Root.left);
		recoverVisited(Root.right);
	}
	
	public void midOrder2(Node Root)
	{
		if(Root==null) return;
		recoverVisited(Root);
		Stack<Node> s = new Stack<Node>();
		s.push(Root);
		Node cur;
		Node last;
		while(!s.isEmpty())
		{
			cur = s.pop();
			if(cur.left==null|| cur.left.visited==1)
				visit(cur);
			else 
			{
				if(cur.right!=null) s.push(cur.right);
				s.push(cur);
				s.push(cur.left);
			}
		}
	}
	boolean sonsVisited(Node root)
	{
		return (root.left==null||root.left.visited==1) && (root.right==null||root.right.visited==1);
	}
	public void postOrder2(Node Root)
	{
		if(Root==null) return;
		recoverVisited(Root);
		Stack<Node> s = new Stack<Node>();
		s.push(Root);
		Node cur;
		Node last;
		while(!s.isEmpty())
		{
			cur = s.pop();
			if((cur.left==null&& cur.right==null)||sonsVisited(cur))
			{
				if(cur.visited==0) 
					visit(cur);
			}			
			else 
			{
				s.push(cur);
				if(cur.right!=null && cur.right.visited==0) s.push(cur.right);
				if(cur.left!=null && cur.left.visited ==0) {s.push(cur.left);}
			}
			
		
		}
	}
	public static void testOrders(Tree t)
	{
		System.out.println("宽度优先递归");
		t.BFS(t.root);
		System.out.println("\n前序递归");
		t.preOrder(t.root);
		
		System.out.println("\n前序非递归");
		t.preOrder2(t.root);
		
		System.out.println("\n中序递归");
		t.midOrder(t.root);
		System.out.println("\n中序非递归");
		t.midOrder2(t.root);
		System.out.println("\n中序非递归");
		t.midOrder3(t.root);
		
		System.out.println("\n后序递归");
		t.postOrder(t.root);
		System.out.println("\n后序非递归");
		t.postOrder2(t.root);
		System.out.println("\n后序非递归");
		t.postOrder3(t.root);
		
		System.out.println("");
	}
	
	public static void main(String[] args)
	{
		int [] a =  new int[]{1,2,3,4,5,6,7,8,9,10};
		Tree t =  new Tree();
		t.createTree(a);
		Tree.testOrders(t);
		
		
		
	}	
	
}
