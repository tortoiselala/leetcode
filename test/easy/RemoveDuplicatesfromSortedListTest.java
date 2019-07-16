package easy;

import entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tortoiselala on 2019-05-28
 */
public class RemoveDuplicatesfromSortedListTest {

    @Test
    public void deleteDuplicates() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        new RemoveDuplicatesfromSortedList().deleteDuplicates(head);
        print(head);
    }

    public static void print(ListNode head){
        ListNode tail = head;
        while(tail != null){
            System.out.print(tail.val + " ");
            tail = tail.next;
        }
        System.out.println();
    }
}