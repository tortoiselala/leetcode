package easy;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tortoiselala
 */
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        return convertToArray(head);
    }

    private ListNode usingLength(ListNode head){
        int length = 0;
        ListNode tail = head;
        while(tail != null){
            ++length;
            tail = tail.next;
        }

        length /= 2;

        tail = head;
        while(length > 0){
            tail = tail.next;
            --length;
        }
        return tail;
    }

    private ListNode fastAndSlowPointer(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode convertToArray(ListNode head){
        List<ListNode> list = new ArrayList<>();
        ListNode tail = head;
        while(tail != null){
            list.add(tail);
            tail = tail.next;
        }

        return list.get(list.size() / 2);
    }
}
