package medium;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class BinarySearchTreetoGreaterSumTree {
    private int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
