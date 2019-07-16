package tmp;

import entity.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reverse = reverse(l1);
        ListNode l2Reverse = reverse(l2);
        ListNode result = null;
        ListNode tail = null;
        int carry = 0;
        while(l1Reverse != null && l2Reverse != null){
            int sum = carry + l1Reverse.val + l2Reverse.val;
            carry = sum % 10;
            if(result == null){
                result = new ListNode(sum / 10);
                tail = result;
            }else{
                tail.next = new ListNode(sum / 10);
                tail = tail.next;
            }
            l1Reverse = l1Reverse.next;
            l2Reverse = l2Reverse.next;
        }
        if(l1Reverse != null){
            while(l1Reverse != null){
                int sum = carry + l1Reverse.val;
                carry = sum % 10;
                if(result == null){
                    result = new ListNode(sum / 10);
                    tail = result;
                }else{
                    tail.next = new ListNode(sum / 10);
                    tail = tail.next;
                }
                l1Reverse = l1Reverse.next;
            }
        }
        if(l2Reverse != null){
            while(l2Reverse != null){
                int sum = carry + l2Reverse.val;
                carry = sum % 10;
                if(result == null){
                    result = new ListNode(sum / 10);
                    tail = result;
                }else{
                    tail.next = new ListNode(sum / 10);
                    tail = tail.next;
                }
                l2Reverse = l2Reverse.next;
            }
        }

        if(carry != 0){
            if(result == null){
                result = new ListNode(carry / 10);
                tail = result;
            }else{
                tail.next = new ListNode(carry / 10);
                tail = tail.next;
            }
        }
        return reverse(result);
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head, cur = pre.next, next = cur.next.next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode r = new AddTwoNumbers().reverse(l1);
        while(r != null){
            System.out.print(r.val + "  ");
            r = r.next;
        }
    }
}
