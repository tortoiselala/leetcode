//package medium;
//
//import entity.ListNode;
//
//import java.util.Stack;
//
///**
// * @author tortoiselala
// */
//public class ReverseLinkedListII {
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        Stack<ListNode> stack = new Stack<>();
//        if()
//
//        ListNode tail = head;
//        ListNode anotherHalf;
//        int len = n - m;
//        while(m > 0){
//            tail = tail.next;
//            --m;
//        }
//
//
//        ListNode preHalf = tail;
//        while(len > 0){
//            --len;
//            stack.push(tail);
//            tail = tail.next;
//        }
//        anotherHalf = tail.next;
//        tail = preHalf;
//        while(!stack.isEmpty()){
//            tail.next = stack.pop();
//            tail = tail.next;
//        }
//        tail.next = anotherHalf;
//
//        return head;
//    }
//}
