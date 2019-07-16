package easy;

import entity.TreeNode;

/**
 * @author tortoiselala
 */
public class MaximumDepthofBinaryTree {

    private int max;

    public int maxDepth(TreeNode root) {
        max = 0;
        if(root == null){
            ;
        }else{
            maxDepthHelper(root, 1);
        }
        return this.max;
    }

    private void maxDepthHelper(TreeNode node, int level){
        if(level > max){
            max = level;
        }
        if(node.left != null){
            maxDepthHelper(node.left, level + 1);
        }

        if(node.right != null){
            maxDepthHelper(node.right, level + 1);
        }
    }
}
