package easy;

import entity.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 * @author tortoiselala
 */
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        return root == null ? 0 : Math.abs(getSum(root.left) - getSum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int getSum(TreeNode r){
        if(r == null){
            return 0;
        }
        return r.val + getSum(r.left) + getSum(r.right);
    }
}
