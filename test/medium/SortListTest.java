package medium;

import entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortListTest {

    @Test
    public void sortList() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        head = new SortList().sortList(head);
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}