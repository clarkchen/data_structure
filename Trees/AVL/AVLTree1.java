package AVL;

import basic.Graph;

public class AVLTree1 {
	int max = 1000;
	AvlPoint last;
	AvlPoint root;
	AvlPoint problem;
	public AVLTree1()
	{
		root = null;
	}
	
	Boolean insert(int v)
	{
		Boolean alert =false;
		Boolean taller = false;
		
		last = new AvlPoint(v);
		if(root==null) root = last;
		else{
			AvlPoint cur = root;
			while(cur!=null)
			{
				if(cur.l == null && v < cur.value){
					cur.l = last; ;last.parent=cur;
					if(cur.r==null) taller = true; break;
				}
				else if(cur.r==null && v>=cur.value)
				{
					cur.r  = last;last.parent=cur;
					if(cur.l==null) taller = true; break;
				}
				else if(cur.value>v)
				{	
 					cur = cur.l;
				}
				else if(cur.value<v)
				{
 					cur = cur.r;
				}
				
			}
			while(taller && cur!=null )
			{
				getBF(cur);
				if(!alert && (cur.bf>1 || cur.bf<-1))
				{
					alert = true;
					problem = cur;
					
				}
				cur = cur.parent;
			}
		}
		
		return alert;
		
	}
 
	public void getBF(AvlPoint A)
	{
		int r = A.r==null?0:A.r.height;
		int l = A.l==null?0:A.l.height;
		A.height = (r>l?r:l)+1;
		A.bf = r-l;
	}
	void RoateR(AvlPoint A )
	{
		AvlPoint B = A.l;
		
		A.l = B.r;
		if(B.r!=null)  B.r.parent = A.l;
		B.r = A;
		

		AvlPoint p = A.parent;
		A.parent = B;
		if(p!=null){
			if(A.value < p.value) p.l = B;
			else p.r = B;
			B.parent = p;
		}
		else {
			root = B;
			B.parent = null;
		}
	
	}
	
	void RoateL(AvlPoint A)
	{
		AvlPoint B = A.r;
		A.r = B.l;
		if(B.l!=null) B.l.parent = A;
		B.l = A;
		
		AvlPoint p = A.parent;
		A.parent = B;
		
		if(p!=null){
			if(A.value < p.value) p.l = B;
			else p.r = B;
			B.parent = p;
		}	
		else{
			root = B;
			B.parent = null;
		}

		
	}
	void RoateRL(AvlPoint A)
	{
		AvlPoint B = A.r;
		RoateR(B);
		RoateL(A);
	}
	
	void RoateLR(AvlPoint A)
	{
		AvlPoint B = A.l;
		RoateL(B);
		RoateR(A);
	}
	int findPoints( AvlPoint C)
	{
		AvlPoint cur = problem;
		int type = 0;
			
		AvlPoint next = cur.l;
		if(C.value >= cur.value) next = cur.r;
		
		if(cur.bf==next.bf-1)
		{type=1;}
		if(cur.bf== next.bf+1)
		{type = 2;}
		if(cur.bf== next.bf-3)
		{type = 3;}
		if(cur.bf== next.bf+3)
		{type = 4;}
		return type;
	}
 
	
	void handleAlert(AvlPoint C)
	{
		int type = findPoints(C);
		if(type ==1){RoateR(problem);}
		if(type==2){RoateL(problem);}
		if(type==3){RoateLR(problem);}
		if(type==4){RoateRL(problem);}
		 
		while( problem!=null )
		{
			getBF(problem);
			problem = problem.parent;
		}
	}
	
	//this method is clear and works well 
	//but it is too complicated and space consuming considering about
	//the parent and height 
	public void createAVL(int[]a)
	{
		for(int i=0;i<a.length;i++)
		{
			if(insert(a[i]))
			{
				handleAlert(this.last);
			}
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
		int []a = {1,2,3,4,5,10,12,8,7,6};
		a = new int[]{1,5,10,6, 11};
		AVLTree1 av = new AVLTree1();
		av.createAVL(a);
		av.preOrder(av.root);
		System.out.println(" ");
		av.midOrder(av.root);
	}

}
