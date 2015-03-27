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
public abstract class MyList<E> {
	Node <E> head, tail;
	int size;
	
	public MyList( )
	{
		head = tail = null;size = 0;
	}
	//Insert 
	//insert from tail
	public abstract void insert(E value);
	
	public abstract void insertBeforeHead(E value);

	//insert before index
	public abstract void insert(E value, int index);
	
		
	//delete
	//delete by index
	public abstract void delete( int index );
	 
	//delete by Object 
	public abstract void delete(E obj);
	
	//Search
	public Node<E> find(int index)
	{
		if(head ==null) return head;
		if(index>=size) return null;
		Node<E> cur = head;
		int i=0;
		while(cur!=null && i<index)
		{
			i++; cur = cur.next;
		}
		return cur;
	}
	//Search by object
	public Node<E> find (E object)
	{
		if(head ==null) return head;
		Node<E> cur = head;
	 	while(cur!=null && cur.Value.equals(object))
		{
		  cur = cur.next;
		}
		return cur;
	}
	
	public Node<E> get(int index)
	{
		return find(index);
	}
	//update value by index
	public void update(int index, E value) {
		// TODO Auto-generated method stub
		Node<E> cur= get(index);
		if(cur!=null) cur.Value = value;
	}
	
	//输出检查
	public String toString()
	{
		String res ="[";
		Node<E> cur = head;
		while(cur!=null){
			res+=cur.Value+","; 
			cur = cur.next;
		}
		return res.substring(0,res.length()-1)+"]";
	}
	//for test
	public boolean equalsList(List<E> values)
	{
		
		if(values.size()!=size) return false;
		Node<E> cur = head;
		
		for(int i=0;i<values.size();i++)
		{
			if(!values.get(i).equals(cur.Value)) return false;
				 
			cur = cur.next;
		}
		return true;
	}
	
 
	//反响判断
	public boolean equalReverseList(List<E> l)
	{
		if(l.size()!=size) return false;
		if(size==0) return true;
		Node<E> cur = tail;
		for(int i=size-1;i>=0;i--,cur=cur.pre)
		{
			if(!l.get(i).equals(cur.Value)) return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{ 
	}

}
