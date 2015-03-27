/**
 * 
 */
package List.MyList;
import java.util.*;
/**
 * @author chenxi
 * 双向链表，和之前的单向链表相同
 */
public class DoubleList<E> extends MyList<E>{

	@Override
	public void insert(E value) {
		// TODO Auto-generated method stub
		Node<E> temp = new Node<E> (value);
		if(size==0){
			head = tail =  temp;
			size++; return;
		}
		temp.pre = tail;
		tail.next = temp;
		tail = temp;
		size++;
	}

	@Override
	public void insertBeforeHead(E value) {
		// TODO Auto-generated method stub
		if(size==0) {insert(value);return;}
		Node<E> temp = new Node<E> (value);
		temp.next = head;
		head.pre = temp;
		head = temp;
		size++;
	}

	@Override
	public void insert(E value, int index) {
		// TODO Auto-generated method stub
		if(size==0 ||index>=size) insert(value);
		else if(index<=0) insertBeforeHead(value);
		else
		{
			int i=0;
			Node<E>pre =head, cur = head.next;
			while(cur!=tail && i<index)
			{
				i++;pre=cur;cur = cur.next;
			}
			Node<E> temp = new Node<E> (value);
			temp.pre = pre;
			pre.next = temp;
			
			temp.next = cur;
			cur.pre = temp;
			size++;
		}
	}

	

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		if(size==0 || index>=size) return ;
		if(index<0) return;
		if(index==0){
			head = head.next;
			size--;
			if(size==0) tail = head;
			else head.pre = null;
			return;
		}
		
		Node<E>pre=head, cur= head.next;
		int i=0;
		while(cur!=null&&i++<index-1){pre=cur;cur= cur.next;}
		if(cur==tail)
		{
			tail = pre;pre.next = cur.next;
		}
		else{
			pre.next = cur.next;
			cur.next.pre = pre;
		}
		size--;
		
		
		
	}

	@Override
	public void delete(E obj) {
		// TODO Auto-generated method stub
		if(size==0||head.Value==obj) { delete(0);return;}
		Node<E>pre=head, cur= head.next;
		while(cur!=null&&cur.Value!=obj){pre=cur;cur= cur.next;}
		if(cur!=null){
			if(cur==tail)
			{
				tail = pre;pre.next = cur.next;
			}
			else{
				pre.next = cur.next;
				cur.next.pre = pre;
			}
			size--;
		}
	}

	
}
