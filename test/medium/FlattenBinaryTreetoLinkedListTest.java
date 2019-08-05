package medium;

import entity.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenBinaryTreetoLinkedListTest {

    @Test
    public void flatten() {
        TreeNode root = TreeNode.makeBinaryTree(new int[]{0, 1, 2, 5, 3, 4, 6});


        new FlattenBinaryTreetoLinkedList().flatten(root);

        return;
    }
}