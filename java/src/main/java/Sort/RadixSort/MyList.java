package Sort.RadixSort;

/**
 * Created by chenxi on 15/4/29.
 */
public class MyList {
    Node head, tail;
    public  MyList()
    {
        head = tail = null;
    }

    public void inserFromTail(int value)

    {
        if (head ==null)
        {
            head = tail = new Node(value);
        }
        else
        {
            tail.next = new Node(value);
            tail = tail.next;
        }
    }

    //从头结点弹出元素
    public Node popFromHead()
    {
        if (head==null) return null;

        Node ret = head;

        head = head.next;

        if (head==null) tail = head;

        return ret;
    }

}
