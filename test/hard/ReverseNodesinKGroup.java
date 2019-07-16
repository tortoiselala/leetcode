package hard;

import entity.ListNode;

import java.util.Stack;

/**
 * @author tortoiselala
 */
public class ReverseNodesinKGroup {

    private ListNode h;

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            reverseGroupHelp(pre, cur, k, stack);
            pre = cur;
            cur = cur.next;
        }
        return h;
    }

    private void reverseGroupHelp(ListNode pre, ListNode cur, int k, Stack<ListNode> stack){
        ListNode tail = cur;
        while(k > 0 && tail != null){
            tail = tail.next;
            --k;
        }
        if(k > 0){
            if(h == null){
                h = cur;
            }
            return;
        }
        ListNode loop = cur;
        while(loop != tail){
            stack.push(loop);
            loop = loop.next;
        }
        if(pre == null){
            while(!stack.isEmpty()){
                if(h == null){
                    h = stack.pop();
                    loop = h;
                }else{
                    loop.next = stack.pop();
                    loop = loop.next;
                }
            }
        }else{
            loop = pre;
            while(!stack.isEmpty()){
                loop.next = stack.pop();
                loop = loop.next;
            }
        }
        loop.next = tail;
    }
}
