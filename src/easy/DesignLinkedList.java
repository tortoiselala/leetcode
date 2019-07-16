package easy;

/**
 * @author tortoiselala
 */
public class DesignLinkedList {

}
class MyLinkedList{

    class ListNode{
        int val;
        ListNode next;
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > size){
            return -1;
        }
        ListNode loop = head;
        while(index > 0){
            loop = loop.next;
            --index;
        }
        return loop.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode n = new ListNode();
        n.val = val;
        n.next = head;
        head = n;
        ++size;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode n = new ListNode();
        n.val = val;
        if(head == null){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            tail = tail.next;
        }

        ++size;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == size){
            addAtTail(val);
        }else if(index > size){
        }else{
            ListNode tmp = head;
            while (index > 0){
                --index;
                tmp = tmp.next;
            }
            ListNode n = new ListNode();
            n.val =val;
            n.next = tmp.next;
            tmp.next = n;
            ++size;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }
}
