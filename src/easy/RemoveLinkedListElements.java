package easy;

import entity.ListNode;

/**
 * @author tortoiselala
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode tail = head;
        while(tail != null){
            if(tail.val == val){
                if(pre == null){
                    head = tail.next;
                    tail = head;
                }else{
                    pre.next = tail.next;
                    tail = pre.next;
                }
            }else{
                if(pre == null){
                    pre = head;
                    tail = tail.next;
                }else{
                    pre = pre.next;
                    tail = tail.next;
                }
            }
        }
        return head;
    }
}
