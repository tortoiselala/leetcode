package medium;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tortoiselala on 2019-05-28
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeatSet = new HashSet<>();
        if (head == null || head.next == null) {
            return head;
        }
        set.add(head.val);
        ListNode loop = head;
        while(loop.next != null){
            if(set.contains(loop.val)){
                repeatSet.add(loop.val);
            }else {
                set.add(loop.val);
                loop = loop.next;
            }
        }
        loop = head;
        while (loop.next != null) {
            if(loop == head && repeatSet.contains(loop.val)){
                head = loop.next;
                loop = loop.next;
            }else{

            }

            loop = loop.next;
        }


        return head;
    }
}
