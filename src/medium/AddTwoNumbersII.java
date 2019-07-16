package medium;

import entity.ListNode;

import java.util.Stack;

/**
 * @author tortoiselala
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        Stack<Integer> result = new Stack<>();
        ListNode loop = l1;
        while (loop != null) {
            num1.push(loop.val);
            loop = loop.next;
        }
        loop = l2;
        while (loop != null) {
            num2.push(loop.val);
            loop = loop.next;
        }

        if (num1.size() < num2.size()) {
            Stack<Integer> tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int carry = 0;
        int sum = 0;
        while(!num2.isEmpty()){
            sum = num2.pop() + num1.pop() + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.push(sum);
        }
        while(!num1.isEmpty()){
            sum = num1.pop() + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.push(sum);
        }
        if(carry != 0){
            result.push(carry);
        }

        ListNode head = null, tail = null;
        while(!result.isEmpty()){
            if(head == null){
                head = new ListNode(result.pop());
                tail = head;
            }else{
                tail.next = new ListNode(result.pop());
                tail = tail.next;
            }
        }

        return head;
    }
}
