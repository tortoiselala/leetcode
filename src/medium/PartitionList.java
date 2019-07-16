package medium;

import entity.ListNode;

/**
 * @author tortoiselala
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null, lessTail = null;
        ListNode equalOrGreaterHead = null, equalOrGreaterTail = null;
        ListNode loop = head;
        while(loop != null){
            if(loop.val < x){
                if(lessHead == null){
                    lessHead = loop;
                    lessTail = lessHead;
                }else{
                    lessTail.next = loop;
                    lessTail = lessTail.next;
                }
            }else{
                if(equalOrGreaterHead == null){
                    equalOrGreaterHead = loop;
                    equalOrGreaterTail = equalOrGreaterHead;
                }else{
                    equalOrGreaterTail.next = loop;
                    equalOrGreaterTail = equalOrGreaterTail.next;
                }
            }
            loop = loop.next;
        }
        if(lessTail != null){
            lessTail.next = equalOrGreaterHead;
        }
        if(equalOrGreaterTail != null){
            equalOrGreaterTail.next = null;
        }
        if(lessHead == null){
            lessHead = equalOrGreaterHead;
        }
        return lessHead;
    }
}
