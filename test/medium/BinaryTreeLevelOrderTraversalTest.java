package medium;

import entity.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class BinaryTreeLevelOrderTraversalTest {

    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }
}