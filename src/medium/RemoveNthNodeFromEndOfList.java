package medium;

import entity.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode h = ListNode.create(new int[]{1, 2, 3, 4});

       ListNode.print(new RemoveNthNodeFromEndOfList().removeNthFromEnd(h, 4));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head, next = head, cur = head;
        int i = 0;
        while(i < n){
            next = next.next;
            ++i;
        }
        boolean begin = true;
        while(next != null){
            if(begin){
                begin = false;;
            }else{

                pre = pre.next;
            }
            cur = cur.next;
            next = next.next;
        }
        if(pre == cur){
            return pre.next;
        }else{
            pre.next = cur.next;
        }
        return head;
    }


}
