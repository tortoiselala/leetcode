package easy;

import entity.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry + ((l1 == null) ? 0 : l1.val);
             sum += ((l2 == null) ? 0 : l2.val);
            if(result == null){
                result = new ListNode(sum % 10);
                tail = result;
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
        }
        return result;
    }
}