package medium;

import entity.ListNode;
import org.junit.Test;
import util.LinkedListUtil;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class AddTwoNumbersIITest {

    @Test
    public void addTwoNumbers() {
        ListNode list1 = LinkedListUtil.make(new int[]{7, 2, 4, 3});
        ListNode list2 = LinkedListUtil.make(new int[]{5, 6, 4});
        LinkedListUtil.print(new AddTwoNumbersII().addTwoNumbers(list1, list2));
    }
}