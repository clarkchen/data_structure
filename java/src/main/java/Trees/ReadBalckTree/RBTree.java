package Trees.ReadBalckTree;

import Trees.AVL.AvlPoint;

public class RBTree {
	RBNode root;
	RBNode lastInsert= null;
	//take advantage of Nil is also a node
	public RBNode insert(int value)
	{
		RBNode cur = root;
 		if(root==null){return new RBNode(value);}
		while(!cur.isNil())
		{
			if(cur.value==value) return null;
			if(cur.value>value ) cur = cur.left;
			else if(cur.value<value) cur = cur.right;  
			 
		}
		cur.setNewValue(value);
		return cur;
	}
	RBNode grandpa(RBNode rb)
	{
		if(rb.parent!=null && rb.parent.parent!=null)
			return rb.parent.parent;
		return null;
	}
	RBNode Sibling(RBNode rb)
	{
		if(rb.parent!=null) 
		{
			if(rb.parent.value>rb.value) return rb.parent.right;
			if(rb.parent.value<rb.value) return rb.parent.left;
		}
		return null;
	}
	RBNode uncle(RBNode rb)
	{
		RBNode g = grandpa(rb);
		if(g!=null)
		{
			if(g.value>rb.value) return g.right;
			else if(g.value<rb.value) return g.left;
		}
		return null;
	}
	//case1: root is empty
	void insert_case1(RBNode cur)
	{
		if(root==null || cur.parent==null)
		{
			root = cur;
			root.color = 0;
		}
		else insert_case2(cur);
	}
	 
	void insert_case2(RBNode cur)
	{
		 if(cur.parent.color==0){}
		 else insert_case3(cur);
	}
	void insert_case3(RBNode cur){
		if(cur.parent.color==1 && uncle(cur).color==1)
		{
			grandpa(cur).changeColor();
			cur.parent.changeColor();
			uncle(cur).changeColor();
			insert_case1(grandpa(cur));
		}
		else insert_case4(cur);
	}
	
	void insert_case4(RBNode cur){
		if(cur.parent.color==1 && uncle(cur).color==0)
		{
			RBNode temp;
			if(cur==cur.parent.left && cur.parent==grandpa(cur).right)
			{
				temp = cur.parent;
				RoateRight(cur.parent);
				insert_case5(temp);
				
			}
			else if(cur==cur.parent.right && cur.parent == grandpa(cur).left)
			{
				temp = cur.parent;
				RoateRight(cur.parent);
				insert_case5(temp);
				
			}
			
			else insert_case5(cur);
			
		}
		
	}
	void insert_case5(RBNode cur){
		cur.parent.parent.changeColor();
		cur.parent.changeColor();
		
		if(cur==cur.parent.left )
		{
			RoateRight(cur.parent.parent);
			
		}
		else if(cur==cur.parent.right)
		{
			RoateLeft(cur.parent.parent);
		}
	}
	
	public RBNode Search(int value)
	{
		RBNode cur =root;
		if(cur==null) return cur;
		while(cur.value!=null && cur.value!=value)
		{
			if(cur.value>value) cur = cur.left;
			else if(cur.value<value) cur = cur.right;
		}
		if(cur.value==null) return null ;
		return cur;
	}
	//find the node to replace the cur and we focused on the effects for the new node
	//only find the replace node from left tree ,if there is no left tree 
	//cur also meets the condition that node to delete has only one branch
	RBNode replaceNode(RBNode cur)
	{
		RBNode temp = null;
		if(cur.left.value!=null)
		{
			temp = cur.left;
			while(temp.right.value!=null)
			{
				temp  = temp.right;
			}
		}
		if(temp==null)
		{
			return cur;
		}
		cur.value = temp.value;
		return temp;
		
	}
	public void delete(int value)
	{
		RBNode cur = Search(value);
		cur = replaceNode(cur);
		if(cur.color==1)
		{
			clear(cur);
		}
		else if(cur.color==0 && cur.left.color==1)
		{
			cur.left.changeColor();
			clear(cur);
		}
		
		else {
			delete_case1(cur);
			clear(cur);
		}
	}
	//remove the node from the tree
	void clear(RBNode cur)
	{
		cur.left.parent = cur.parent;
		if(cur.parent.value>cur.value) cur.parent.left = cur.left;
		else cur.parent.right = cur.left;
	}
	//cur is root
	//cur only may has left son
	void delete_case1(RBNode cur){
		if(cur.parent!=null)
			delete_case2(cur);
	}
	
	//n是黑色，Child是黑色，S是红色（P是黑色）
	//n一定存在兄弟结点
	void delete_case2(RBNode cur){
		if(cur.color==0 && cur.left.color==0 )
		{
			if(Sibling(cur).color==1)
			{
				Sibling(cur).changeColor();
				cur.parent.changeColor();
				
				if(cur == cur.parent.left)
					RoateLeft(cur.parent);
				else 
					RoateRight(cur.parent);
			}
			delete_case3(cur);
		}
		
	}
	//n是黑色，Child是黑色，S是黑色，P是红色
		void delete_case3(RBNode cur){
				RBNode s = Sibling(cur);
				if(cur.parent.color==1 && s.color==0 && s.left.color==0 && s.right.color==0 )
				{
					cur.parent.changeColor();
					Sibling(cur).changeColor();
					
				}
				else delete_case4(cur);
			}
	//n是黑色，Child是黑色，S是黑色，P是黑色，SL和SR同为黑色i
	void delete_case4(RBNode cur){
		RBNode s= Sibling(cur);
		if(s.color==0 && s.left.color==0 && 0==s.right.color)
		{
			s.changeColor();
			s.parent.changeColor();
			delete_case1(cur.parent);
		}
		else delete_case5(cur);
	}
	
	//SL 和SR 颜色不同 与N方向相反的点为黑色，另一个为红色
	void delete_case5(RBNode cur){
		RBNode s = Sibling(cur);
		if(cur == cur.parent.left && s.left.color==1 && s.right.color==0)
		{
			s.changeColor();
			s.left.changeColor();
			RoateRight(s);
		}
		else if(cur==cur.parent.right && s.right.color==1 && s.left.color==0)
		{
			s.changeColor();
			s.right.changeColor();
			RoateLeft(s);
		}
		delete_case6(cur);
	}
	//与N方向相反的点为红，另一个为黑色或者红色
	void delete_case6(RBNode cur){
		RBNode s = Sibling(cur);
		if(cur == cur.parent.left && s.right.color==1)
		{
			s.right.changeColor();
			RoateLeft(cur.parent);
		}
		else if(cur==cur.parent.right && s.left.color==1)
		{
			s.left.changeColor();
			int temp = s.parent.color;
			s.parent.color = s.color;
			s.color = temp;
			RoateRight(cur.parent);
			
		}
	}
	
	void RoateLeft(RBNode cur)
	{
		RBNode b = cur.right;
		cur.right = b.left;
		b.left.parent = cur;
		
		b.left = cur;
		b.parent = cur.parent;
		if(cur.parent!=null){
			if(cur.parent.value>cur.value) cur.parent.left = b;
			else cur.parent.right = b;
		}
		if(cur.parent==null) root = b;
		cur.parent = b;
	}
	
	void RoateRight(RBNode cur)
	{
		RBNode b = cur.left;
		cur.left = b.right;
		b.right.parent = cur;
		
		b.right = cur;
		b.parent = cur.parent;
		if(cur.parent!=null){
		
			if(cur.parent.value>cur.value) cur.parent.left = b;
			else cur.parent.right = b;
			 
		}
		if(cur.parent==null) root = b;
		cur.parent = b;
		
		
	}
	public void preOrder(RBNode root)
	{
		if(root.value ==null) return;
		System.out.println(root.value+"  color "+root.color);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void midOrder(RBNode root)
	{
		if(root.value ==null) return;
		
		midOrder(root.left);
		System.out.println(root.value+"  color "+root.color);
		midOrder(root.right);
	}
	public void createTree(int []value)
	{
		for(int i=0;i<value.length;i++)
		{
			RBNode cur= insert( value[i]);
			if(cur!=null) insert_case1(cur);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]=new int[]{2,1,3,4,5};
		a=  new int[]{2,1,3,5,4};
		a =new int[] {1,2,3,4,5,10,12,8,7,9};
		a = new int[]{1,2,3,4,5,10,12,8,7,9};
		RBTree rbt  =new RBTree();
		rbt.createTree(a);
		System.out.println("Pre Order");		
		rbt.preOrder(rbt.root);
		System.out.println("mid Order");
		rbt.midOrder(rbt.root);

		System.out.println("delete 12");		
		rbt.delete(12);
		System.out.println("Pre Order");		
		rbt.preOrder(rbt.root);
		System.out.println("mid Order");
		rbt.midOrder(rbt.root);

		System.out.println("delete 7");		
		rbt.delete(7);
		System.out.println("Pre Order");		
		rbt.preOrder(rbt.root);
		System.out.println("mid Order");
		rbt.midOrder(rbt.root);
		
		System.out.println("delete 4");		

		rbt.delete(4);
		System.out.println("Pre Order");		
		rbt.preOrder(rbt.root);
		System.out.println("mid Order");
		rbt.midOrder(rbt.root);		
	}

}
