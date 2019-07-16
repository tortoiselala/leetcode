package medium;

import entity.ListNode;
import org.junit.Test;
import util.LinkedListUtil;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class ReorderListTest {

    @Test
    public void reorderList() {
        ListNode head = LinkedListUtil.make(new int[]{1, 2, 3, 4, 5});
        new ReorderList().reorderList(head);
        LinkedListUtil.print(head);
    }
}