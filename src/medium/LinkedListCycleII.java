package medium;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tortoiselala
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        return doublePointer(head);
    }
    // 3 2 0 -4
    private ListNode doublePointer(ListNode head){
        Set<ListNode> set = new HashSet<>();
        ListNode tail = head;
        while(tail != null){
            if(set.contains(tail)){
                return tail;
            }else{
                set.add(tail);
            }
            tail = tail.next;
        }
        return null;
    }
}
