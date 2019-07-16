package medium;

// https://leetcode.com/problems/swap-nodes-in-pairs/

import entity.ListNode;

/**
 * Given a linked list,
 * swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes,
 * only nodes itself may be changed.
 * @author tortoiselala
 */
public class SwapNodesInPairs {
    private ListNode h;

    public ListNode swapPairs(ListNode head) {
        h = head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode next = cur.next.next;
            if(pre == null){
                h = cur.next;
                h.next = cur;
            }else{
                pre.next = cur.next;
                pre.next.next = cur;
            }
            cur.next = next;
            pre = cur;
            cur = cur.next;
        }
        return h;
    }
}
