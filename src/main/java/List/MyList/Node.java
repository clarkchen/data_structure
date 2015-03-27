/**
 * 
 */
package List.MyList;
import java.util.*;
/**
 * @author chenxi
 *  
 */
public class Node<E> {
	public E Value;
	Node<E> next;
	Node<E> pre;
	public Node (E v)
	{
		this.Value = v;
		next = null;
		pre = null;
	}
	
}
