package medium;


import entity.Node;

/**
 * @author tortoiselala
 */
public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        Node tail = head;
        // 创造新链表
        while(tail != null){
            tail.next = new Node(tail.val, tail.next, tail.random);
            tail = tail.next.next;
        }

        // 更该random指针
        tail = head;
        while (tail != null) {
            if(tail.random != null){
                tail.next.random = tail.random.next;
            }

            tail = tail.next.next;
        }
        tail = head;
        Node newListHead = null, newListTail = null;
        while (tail != null) {
            if (newListHead == null) {
                newListHead = tail.next;
                newListTail = newListHead;
            }else{
                newListTail.next = tail.next;
                newListTail = newListTail.next;
            }
            tail.next = newListTail.next;
            tail = tail.next;
        }
        return newListHead;
    }
}
