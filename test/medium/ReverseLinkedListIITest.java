package medium;

import entity.ListNode;
import org.junit.Test;
import util.LinkedListUtil;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class ReverseLinkedListIITest {

    @Test
    public void reverseBetween() {
        ListNode head = LinkedListUtil.make(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        head = new ReverseLinkedListII().reverseBetween(head, 3, 6);
        LinkedListUtil.print(head);
    }
}