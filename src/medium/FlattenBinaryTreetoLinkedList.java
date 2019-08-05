package medium;

import entity.TreeNode;

/**
 * @author tortoiselala
 */
public class FlattenBinaryTreetoLinkedList {
    private TreeNode cur;

    public void flatten(TreeNode root) {
        cur = root;
        if(root == null){
            return;
        }
        dfs(root);
    }

    private void dfs(TreeNode root){
        TreeNode rootRight = root.right;

        if(root.left != null){
            cur.right = root.left;
            cur = cur.right;
            dfs(root.left);
        }

        root.left = null;

        if(rootRight != null){
            cur.right = rootRight;
            cur = cur.right;
            dfs(rootRight);
        }
    }
}
