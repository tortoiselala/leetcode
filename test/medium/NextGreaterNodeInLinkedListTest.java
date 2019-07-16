package medium;

import entity.ListNode;
import org.junit.Test;
import util.LinkedListUtil;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class NextGreaterNodeInLinkedListTest {

    @Test
    public void nextLargerNodes() {
        ListNode head = LinkedListUtil.make(new int[]{2, 7, 4, 3, 5});
        System.out.println(Arrays.toString(new NextGreaterNodeInLinkedList().nextLargerNodes(head)));
    }

    @Test
    public void lager() {
        ListNode head = LinkedListUtil.make(new int[]{2, 7, 4, 3, 5});
        System.out.println(Arrays.toString(new NextGreaterNodeInLinkedList().lager(head)));
    }
}