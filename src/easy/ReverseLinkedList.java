package easy;

import entity.ListNode;

/**
 * @author tortoiselala
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return recursive(head);
    }

    private ListNode iterative(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            if(cur == null){
                return pre;
            }
        }
        return pre;
    }

    private ListNode recursive(ListNode head){
        return recursive(head, null);
    }

    private ListNode recursive(ListNode cur, ListNode pre){
        if(cur == null){
            return pre;
        }else{
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return recursive(cur, pre);
    }
}
