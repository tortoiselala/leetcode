package easy;

import entity.TreeNode;

/**
 * @author tortoiselala
 */
public class MinimumDepthofBinaryTree {

    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        helper(1, root);
        return root == null ? 0 : minDepth;
    }

    private void helper(int depth, TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            minDepth = minDepth < depth ? minDepth : depth;
            return;
        }
        helper(depth + 1, root.left);
        helper(depth + 1, root.right);
    }
}
