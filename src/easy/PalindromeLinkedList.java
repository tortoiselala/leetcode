package easy;

import entity.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tortoiselala
 */
public class PalindromeLinkedList {
    private ListNode head;

    public boolean isPalindrome(ListNode head) {
        return recurse(head);
    }

    private boolean recurse(ListNode tail){
        if(tail == null){
            return true;
        }

        head = (head == null) ? tail : head;

        if(recurse(tail.next) && head.val == tail.val){
            head = head.next;
            return true;
        }
        return false;
    }

    private boolean arrayList(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode tail = head;
        while(tail != null){
            list.add(tail.val);
        }
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
             if(list.get(l++).equals(list.get(--r))){
                 ;
             }else{
                 return false;
             }
        }
        return true;
    }
}
