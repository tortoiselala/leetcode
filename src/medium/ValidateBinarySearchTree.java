package medium;

import entity.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * @author tortoiselala
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }

        int val = root.val;
        if(min != null && val <= min){
            return false;
        }

        if(max != null && val >= max){
            return false;
        }

        if(!helper(root.right, val, max)){
            return false;
        }

        if(!helper(root.left, min, val)){
            return false;
        }
        return true;
    }
}
