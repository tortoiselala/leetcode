package medium;

import entity.ListNode;
import org.junit.Test;
import util.LinkedListUtil;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class SplitLinkedListinPartsTest {

    @Test
    public void splitListToParts() {
        ListNode head = LinkedListUtil.make(new int[]{0});
        for(ListNode elem : new SplitLinkedListinParts().splitListToParts(head, 3)){
            LinkedListUtil.print(elem);
        }
    }
}