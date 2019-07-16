package easy;


import entity.ListNode;
import org.junit.Test;

public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);

        ListNode r = new AddTwoNumbers().addTwoNumbers(l1, l2);
        while(r != null){
            System.out.print(r.val + "  ");
            r = r.next;
        }
    }

    @Test
    public void reverse() {
    }
}
