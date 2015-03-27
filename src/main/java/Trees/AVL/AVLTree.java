package Trees.AVL;

import Graph.basic.Graph;

public class AVLTree {
	int max = 1000;
	AvlPoint root;
	public AVLTree()
	{
		root = null;
	}
	
	public AvlPoint search(AvlPoint cur, int v)
	{
		if(cur == null ) {System.out.println("Not in the tree");return null;}
		else if(cur.value==v){ System.out.println("found "+v);return cur;}
		else if(cur.value>v) return search(cur.l, v);	
		return search(cur.r, v);
	}
	
	//找右子树的最左子树
	AvlPoint findDPointR(AvlPoint cur)
	{
		if(cur.l == null) return cur;
		AvlPoint rt = findDPointR(cur.l);
		if(rt.l==null) cur.l = rt.r;
		getBF(cur);
		return rt;
		
	}
	
	//找左子树的最右子树
	AvlPoint findDPointL(AvlPoint cur)
	{
		if(cur.r == null) return cur;
		AvlPoint rt = findDPointL(cur.r);
		if(cur.r==null) cur.r = rt.l;
		getBF(cur);
		return rt;
	}
	
	public AvlPoint delete(AvlPoint cur, int v)
	{
		if(cur == null ) return null;
		if(cur.value == v)
		{
			AvlPoint replacePoint=null;
			
			if(cur.r!=null) replacePoint = this.findDPointR(cur);
			else if(cur.l!=null)replacePoint = this.findDPointL(cur);

			if(replacePoint!=null){
				replacePoint.l = cur.l;
				replacePoint.r = cur.r;
				getBF(replacePoint);
			}
			return replacePoint;
		}
		
		if(cur.value>v)
		{
			AvlPoint replacePoint=delete(cur.l, v);
			cur.l = replacePoint;
		}
		else if(cur.value<v)
		{
			AvlPoint replacePoint=delete(cur.r, v);
			cur.r  = replacePoint;
		}
		getBF(cur);
		AvlPoint temp = cur;
		if(cur.bf>1)
		{
			if(cur.l.bf>=0) {temp = RoateR(cur);}
			else if (cur.l.bf<0) {
				temp = RoateLR(cur);
			}
		}
		else if(cur.bf<-1)
		{
			if(cur.r.bf<=0){
				temp = RoateL(cur);
			}
			else if(cur.r.bf>0)
			{
				temp = RoateRL(cur);
			}
		}
		if(temp!=cur&&root==cur) root =temp;
		return temp;
	}
	
	AvlPoint insert(AvlPoint cur , int v)
	{
		if(cur==null)
		{
			cur = new AvlPoint(v);
			if(root == null) root = cur;
			return cur;
		}
		else 
		{
			if(cur.value==v) return cur;
			else if(cur.value>v) 
			{
				cur.l = insert(cur.l,v);	
			}
			else if(cur.value<v)
			{
				cur.r = insert(cur.r,v);
			}
			
			getBF(cur);
			AvlPoint temp = cur;
			if(cur.bf>1)
			{
				if(cur.l.bf>=0) {temp = RoateR(cur);}
				else if (cur.l.bf<0) {
					temp = RoateLR(cur);
				}
			}
			else if(cur.bf<-1)
			{
				if(cur.r.bf<=0){temp = RoateL(cur);}
				else if(cur.r.bf>0)
				{
					temp = RoateRL(cur);
				}
			}
			if(temp!=cur&&root==cur) root =temp;
			return temp;
			
		}
		
		
	}

 
	public void getBF(AvlPoint A)
	{
		int r = A.r==null?0:A.r.height;
		int l = A.l==null?0:A.l.height;
		A.height = (r>l?r:l)+1;
		A.bf = l-r;
	}
	AvlPoint RoateR(AvlPoint A )
	{
		AvlPoint B = A.l;
		A.l = B.r;
		B.r = A;
		getBF(A);
		getBF(B);
		return B;
	}
	
	AvlPoint RoateL(AvlPoint A)
	{
		AvlPoint B = A.r;
		A.r = B.l;
		B.l = A;
		getBF(A);
		getBF(B);
		return B;
	}
	AvlPoint RoateRL(AvlPoint A)
	{
		RoateR(A.r);
		return RoateL(A);
	}
	
	AvlPoint RoateLR(AvlPoint A)
	{
		RoateL(A.l);
		return RoateR(A);
	}
	
	//this method is clear and works well 
	//it take advantage of the Recursion as the parent
	public void createAVL(int[]a)
	{
		for(int i=0;i<a.length;i++)
		{
			insert(root, a[i]);
		}
	}
	public void preOrder(AvlPoint root)
	{
		if(root ==null) return;
		System.out.print(root.value+"  ");
		preOrder(root.l);
		preOrder(root.r);
	}
	public void midOrder(AvlPoint root)
	{
		if(root ==null) return;
		midOrder(root.l);
		System.out.print(root.value+"  ");
		midOrder(root.r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1,2,3,4,5,10,12,8,7,9};
		a = new int[]{1,5,10,6, 11};
		AVLTree av = new AVLTree();
		av.createAVL(a);
		av.preOrder(av.root);
		System.out.println(" ");
		av.midOrder(av.root);
		
		System.out.println("\n Seach ");
		av.search(av.root, 8);
		av.search(av.root, 9);
		av.search(av.root, 100);
		
		System.out.println("\n Deletes ");
		av.delete(av.root, 1);
		av.preOrder(av.root);
		System.out.println(" ");
		av.midOrder(av.root);
	}

}
