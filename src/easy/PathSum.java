package easy;

import entity.TreeNode;

/**
 * @author tortoiselala
 */
public class PathSum {
    private boolean flag;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        helper(0, root, sum);
        return flag;
    }

    private void helper(int sum, TreeNode root, int target){
        if(sum + root.val == target && root.left == null && root.right == null){
            flag = true;
            return;
        }

        if(root.left != null){
            helper(sum + root.val, root.left, target);
        }

        if(!flag && root.right != null){
            helper(sum + root.val, root.right, target);
        }
    }
}
