package medium;

import entity.ListNode;

import java.util.*;

/**
 * @author tortoiselala
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tail = head;
        while(tail != null){
            list.add(tail.val);
            tail = tail.next;
        }
        Integer[] array = new Integer[0];

        array = list.toArray(array);
        int[] lagerArray = new int[array.length];
        for(int i = 0; i < array.length; ++i){
            for(int j = i + 1; j < array.length; ++j){
                if(array[j] > array[i]){
                    lagerArray[i] = array[j];
                    break;
                }
            }
        }
        return lagerArray;
    }

    public int[] lager(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] ans = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }

            stack.push(list.get(i));
        }

        return ans;
    }
}
