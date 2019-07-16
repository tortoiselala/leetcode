package entity;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode create(int[] a){
        boolean s = true;
        ListNode head = null;
        ListNode tail = null;
        for(int e : a){
            if(s){
                head = new ListNode(e);
                tail = head;
                s = false;
            }else{
                tail.next = new ListNode(e);
                tail = tail.next;
            }
        }
        return head;
    }

    public static void print(ListNode head){
        System.out.printf("[");
        while(head != null){
            System.out.printf("%d, ", head.val);
            head = head.next;
        }
        System.out.printf("]");
    }
}