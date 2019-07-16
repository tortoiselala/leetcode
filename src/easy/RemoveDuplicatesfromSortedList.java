package easy;

import entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tortoiselala on 2019-05-28
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesfromSortedList{
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        if(head == null){
            return head;
        }
        ListNode tail = head;
        map.put(tail.val, tail);
        while(tail.next != null){
            if(map.get(tail.next.val) != null){
                tail.next = tail.next.next;
            }else{
                map.put(tail.next.val, tail.next);
                tail = tail.next;
            }
        }
        return head;
    }
}
