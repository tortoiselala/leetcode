package easy;

import entity.ListNode;

import java.util.HashSet;
import java.util.Hashtable;

// https://leetcode.com/problems/intersection-of-two-linked-lists

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */

/**
 * Soultions
 * - Brute Force
 *   O(mn), O(1)
 * - HashTable
 *   O(m + n), O(n)
 * - Two Pointer
 *   O(m + n), O(1)
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        return twoPointersSolution(headA, headB);
        return hashTableSolution(headA, headB);
    }

    private ListNode twoPointersSolution(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode tmp = headA;
        while(tmp != null){
            ++lengthA;
            tmp = tmp.next;
        }
        tmp = headB;
        while(tmp != null){
            ++lengthB;
            tmp = tmp.next;
        }
        if(lengthA > lengthB){
            int subRes = lengthA - lengthB;
            while(subRes > 0){
                headA = headA.next;
                --subRes;
            }
        }else{
            int subRes = lengthB - lengthA;
            while(subRes > 0){
                headB = headB.next;
                --subRes;
            }
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    private ListNode hashTableSolution(ListNode headA, ListNode headB){
        HashSet<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(set.contains(headA)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
