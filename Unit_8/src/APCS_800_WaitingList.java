import java.util.Iterator;

/**
 * Created by HHUANG on 3/10/2017.
 */
import java.util.*;
public class APCS_800_WaitingList
{
    public static void main(String[] Theory)
    {
        WaitingList list1 = new WaitingList(new ListNode("A"));
        WaitingList list2 = new WaitingList(new ListNode("D"));

        list1.add(new ListNode("B"));
        list1.add(new ListNode("C"));

        list2.add(new ListNode("E"));

        //Test Print of toString and size for list 1
        System.out.println("List 1 and size");
        list1.tostring();
        System.out.println();
        System.out.println(list1.size());

        //Test Print of toString and size for list 2
        System.out.println();
        System.out.println("List 2 and size");
        list2.tostring();
        System.out.println();
        System.out.println(list2.size());


        //End to End method
        System.out.println();
        System.out.println("End to End");
        list1.transferNodesFromEnd(list2);

        //Aftermath print
        System.out.println("List 1 and size");
        list1.tostring();
        System.out.println();
        System.out.println(list1.size());

        System.out.println();
        System.out.println("List 2 and size");
        list2.tostring();
        System.out.println();
        System.out.println(list2.size());
    }
}

class WaitingList{
    private int numNodes;
    private ListNode front;

    //constructor
    public WaitingList(ListNode front)
    {
        this.front = front;
        numNodes = 1;
    }

    // returns the number of nodes in this list
    public int size()
    {
        return numNodes;
    }

    // add stuff to the LinkedList
    public void add(ListNode node)
    {
        ListNode temp = front;

        while (temp.hasNext())
        {
            temp = temp.getNext();
        }
        temp.setNext(node);
        numNodes++;
    }
    public void removelast()
    {
        getKthNode(size()).setNext(null);
        numNodes--;
    }

    // print out the list
    public void tostring()
    {
        ListNode temp = front;

        for(int i=1; i<=size(); i++)
        {
            System.out.print(temp.getData()+ ", ");
            temp = temp.getNext();
        }
    }


    // returns a reference to the node at k (1 == front)
    // precondition: 0 <= k < size()
    public ListNode getKthNode(int k)
    {
        ListNode temp = front;

        for (int i=1; i<k && temp.hasNext() ; i++)
        {
            temp = temp.getNext();
        }
        return temp;
    }

    public void transferNodesFromEnd(WaitingList other)
    {
        for(int i=other.size(); i>0; i--)
        {
            add(other.getKthNode(i));
            other.removelast();
        }
    }
}


class ListNode {
    public String data;       // data stored in this node
    public ListNode next;  // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListNode()
    {
        this(null, null);
    }

    // post: constructs a node with given data and null link
    public ListNode(String data)
    {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(String data, ListNode next)
    {
        this.data = data;
        this.next = next;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData()
    {
        return data;
    }

    public boolean hasNext()
    {
        return next!=null;
    }

    public ListNode getNext()
    {
        return next;
    }

    public void setNext(ListNode next)
    {
        this.next = next;
    }
}