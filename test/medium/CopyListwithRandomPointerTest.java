package medium;

import entity.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class CopyListwithRandomPointerTest {

    @Test
    public void copyRandomList() {
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.random = head.next;
        head.next.val = 2;
        head.next.next = null;
        head.next.random = head.next;

        Node newHead = new CopyListwithRandomPointer().copyRandomList(head);


        System.out.println(head.toString());
        System.out.println(head.next.toString());

        System.out.println("----------");
        System.out.println(newHead.toString());
        System.out.println(newHead.next.toString());
        return;
    }
}