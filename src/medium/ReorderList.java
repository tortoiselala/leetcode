package medium;

import entity.ListNode;

import java.util.Stack;

/**
 * @author tortoiselala
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        int len = getLinkedListLength(head);
        Stack<ListNode> stack = new Stack<>();
        ListNode loop = head;
        int half = len - len / 2;
        while (half > 1) {
            --half;
            loop = loop.next;
        }
        ListNode ex = loop;
        loop = ex.next;
        ex.next = null;

        while (loop != null) {
            stack.push(loop);
            loop = loop.next;
        }

        loop = head;
        while (!stack.isEmpty()) {
            ListNode tmp = loop.next;
            loop.next = stack.pop();
            loop.next.next = tmp;
            loop = loop.next.next;
        }
    }
    private int getLinkedListLength(ListNode head){
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }
}
