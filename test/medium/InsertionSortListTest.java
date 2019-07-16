package medium;

import entity.ListNode;
import org.junit.Test;
import util.LinkedListUtil;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class InsertionSortListTest {

    @Test
    public void insertionSortList() {
        ListNode head = LinkedListUtil.make(new int[]{-1, 5, 3, 4, 0});
        head = new InsertionSortList().insertionSortList(head);
        LinkedListUtil.print(head);
    }
}