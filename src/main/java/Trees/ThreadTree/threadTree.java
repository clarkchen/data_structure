package Trees.ThreadTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Trees.basic.ThreadNode;;
public class threadTree {
	ThreadNode root;
	public void createTree(int a[])
	{
		if (a.length==0) return ;
		if(root == null) 
		{
			root = new ThreadNode(a[0]);
		}
		int i =0;
		ThreadNode cur = null;
		Queue<ThreadNode> q = new LinkedList<ThreadNode>();
		q.offer(root);
		//Node left,right;
		while(i<a.length)
		{
			cur = q.poll();
			if(2*i+1<a.length){
				cur.left = new ThreadNode(a[2*i+1]) ;
				q.offer(cur.left);
			}
			if(2*i+2 < a.length)
			{
				cur.right = new ThreadNode(a[2*i+2]);
				q.offer(cur.right);
			}
			
			i++;
			
		}
	}
	ThreadNode pre=null;
	//lchild for pre and right child for post
	public void createIndex(ThreadNode tn)
	{
		if(tn == null) return;
		createIndex(tn.left);
		if(tn.left==null)
		{
			tn.ltag =1;
			tn.left = pre;
		}
		if(pre!=null && pre.right == null)
		{	
			pre.right = tn;
			pre.rtag = 1;
		}
		pre = tn;
		createIndex(tn.right);
	}
	void visit(ThreadNode Node)
	{
		System.out.print(Node.Value+" ");
	}
	public void inOrder()
	{
		ThreadNode cur = this.root;
		Boolean jump = false;//表示是否是从子树跳跃过来的
		while(cur!=null )
		{
			while(cur!=null && cur.ltag==0 && !jump) cur =cur.left;
			visit(cur);
			jump =cur.rtag ==1?true:false;
			cur = cur.right;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a =  new int[]{1,2,3,4,5,6,7,8,9,10};
		threadTree tt = new threadTree();
		tt.createTree(a);
		tt.createIndex(tt.root);
		tt.inOrder();
	}

}
