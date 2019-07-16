package medium;

import entity.ListNode;
import org.junit.Test;
import util.LinkedListUtil;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class RotateListTest {

    @Test
    public void rotateRight() {
        ListNode head = LinkedListUtil.make(new int[]{1, 2, 3});
        head = new RotateList().rotateRight(head, 2000000000);
        LinkedListUtil.print(head);
    }
}