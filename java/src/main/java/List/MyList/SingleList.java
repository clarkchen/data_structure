/**
 * 
 */
package List.MyList;
import java.util.*;
/**
 * @author chenxi
 * 简单的链表操作，增，删，改，查，单向链表
 * 增：指定位置增加；头部增加，尾部增加 done
 * 删除，置顶位置删除 
 * 查：按照下标来查找，按照value 来查找 done
 * 改，指定位置修改
 */
public class SingleList<E> extends MyList<E>{
	
	 
	public SingleList( )
	{
		super();
		head = tail = null;size = 0;
	}
	//Insert 
	//insert from tail
	public void insert(E value)
	{
		if(head==null)
		{
			head = new Node<E>(value);
			tail = head;
			size++;
			return ;
		}
		tail.next = new Node<E>(value);
		tail = tail.next;
		size++;
	}
	public void insertBeforeHead(E value)
	{
		if(head==null)
		{
			head = new Node<E>(value);
			tail = head;
			size++;
			return ;
		}
		Node<E> n = new Node<E> (value);
		n.next = head;
		head = n;
		size++;
	}
	//insert before index
	public void insert(E value, int index)
	{
		if (index>=size ||tail ==null) insert(value);
		else if(index<=0 || head ==null) insertBeforeHead(value);
		else {
			Node<E> cur =head;
			int i =0;
			while(i++<index-1){cur=cur.next;}
			Node<E> temp = new Node<E>(value);
			temp.next = cur.next;
			cur.next = temp;
			
		}
		size++;
	}
	
	
	
	//update value by index
	public void update(int index, E value)
	{
		Node<E> n =  get(index);
		if(n!=null) n.Value = value;
	}
	
	//delete
	//delete by index
	public void delete( int index )
	{
		if(index>=size) return ;
		if(index<0) return;
		//删除都结点
		if(index==0) 
		{
			head =head.next;
			size--;
			if(size<=1) tail = head;
			return;
		}
		int i =0;
		Node<E> cur = head;
		while(i++<index-1){cur = cur.next;}
		
		Node<E> temp = cur.next;
		//删除的是尾结点
		if(temp==tail) tail = cur;
		
		cur.next = temp.next;
		size--;
		List<E>l = new ArrayList<E>();
	}
	
	//delete by Object 
	public void delete(E obj)
	{
		if(head == null)  return;
		if(head.Value==obj) {delete(0);return;}
		Node<E> pre =head,cur = head.next;
		while(cur!=null && cur.Value !=obj){pre= cur;cur = cur.next;}
		if(cur!=null)
		{
			if(cur==tail) tail = pre;
		 	pre.next = cur.next;
		 	size--;
		}		
		
	}
		

}
