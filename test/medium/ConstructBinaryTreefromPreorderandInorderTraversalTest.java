package medium;

import entity.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class ConstructBinaryTreefromPreorderandInorderTraversalTest {

    @Test
    public void buildTree() {
        int[] pre = new int[]{3, 9, 20, 15,7};
        int[] in = new int[]{9, 3,15, 20, 7};

        TreeNode.print(new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(pre, in), 0);
    }
}