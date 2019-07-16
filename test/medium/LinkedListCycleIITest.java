package medium;

import entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class LinkedListCycleIITest {

    @Test
    public void detectCycle() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode node = new LinkedListCycleII().detectCycle(head);

        System.out.println(node.val);
    }
}