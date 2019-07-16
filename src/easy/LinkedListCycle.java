package easy;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tortoiselala
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        return hashSet(head);
    }

    private boolean doublePointer(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        if(head != null && head.next != null){
            fast = fast.next.next;
        }else {
            return false;
        }
        while(true){
            if(slow == fast){
                return true;
            }
            if(fast != null && fast.next != null && slow != null){
                fast = fast.next.next;
                slow = slow.next;

            }else{
                return false;
            }
        }
    }

    private boolean hashSet(ListNode head){
        ListNode tail = head;
        Set<ListNode> set = new HashSet<>();
        while(tail != null){
            if(set.contains(tail)){
                return true;
            }
            set.add(tail);
            tail = tail.next;
        }
        return false;
    }
}
