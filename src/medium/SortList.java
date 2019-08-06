package medium;

import entity.ListNode;

import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode nickHead = new ListNode(0);
        nickHead.next = head;
        ListNode i = nickHead;
        ListNode j;
        while (i.next != null){
            j = i;
            while(j.next != null){
                if(i.next.val > j.next.val){
                    swap(i, j);
                }
                j = j.next;
            }
            i = i.next;
        }

        return nickHead.next;
    }

    private void swap(ListNode i, ListNode j){
        int t = j.next.val;
        j.next.val = i.next.val;
        i.next.val = t;
    }
}
