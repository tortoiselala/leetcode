package medium;

import entity.ListNode;

/**
 * @author tortoiselala
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode loopOdd = head;

        ListNode evenListHead = null;
        ListNode loopEven;
        ListNode loop;

        if(head != null && head.next != null){
            evenListHead = head.next;
            loopEven = evenListHead;

            loop = head.next.next;

            while(loop != null){
                loopOdd.next = loop;
                loopOdd = loopOdd.next;

                loop = loop.next;

                if(loop != null){
                    loopEven.next = loop;
                    loopEven = loopEven.next;
                    loop = loop.next;
                }
            }
            loopEven.next = null;
        }
        if(loopOdd != null){
            loopOdd.next = evenListHead;
        }
        return head;
    }
}
