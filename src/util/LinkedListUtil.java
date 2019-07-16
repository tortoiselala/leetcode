
package util;

import entity.ListNode;

import java.util.LinkedList;

/**
 * @author tortoiselala
 */
public class LinkedListUtil {
    public static ListNode make(int[] array){
        ListNode head = null, tail = null;
        for(int elem : array){
            if(head == null){
                head = new ListNode(elem);
                tail = head;
            }else{
                tail.next = new ListNode(elem);
                tail = tail.next;
            }
        }
        return head;
    }

    public static void print(ListNode head){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode tail = head;
        while(tail != null){
            sb.append(tail.val);
            tail = tail.next;
            if(tail != null){
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
