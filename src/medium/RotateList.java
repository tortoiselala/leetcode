package medium;

import entity.ListNode;

/**
 * @author tortoiselala
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return null;
        }

        ListNode from = head, to = head;
        int kb = k;
        while(kb > 0 && from != null){
            from = from.next;
            --kb;
        }

        // 要旋转的长度恰好是链表长度
        // [1, 2, 3], k = 3
        if(kb == 0 && from == null){
            return head;
        }



        // 链表长度太短，k大于了反转长度
        // [1, 2, 3], k = 4
        // kb = 1
        if(kb > 0){
            // 相当于取模
            return rotateRight(head, kb % (k - kb));
        }

        // 链表长度大于k
        while(from.next != null){
            from = from.next;
            to = to.next;
        }

        from.next = head;
        head = to.next;
        to.next = null;
        return head;
    }
}
