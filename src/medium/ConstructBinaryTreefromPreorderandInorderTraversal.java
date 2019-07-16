package medium;

import entity.TreeNode;

import java.util.Arrays;

/**
 * @author tortoiselala
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }

        int[] tmp = preorder;
        preorder = inorder;
        inorder = tmp;

        int elem = inorder[0];
        int index = -1;
        for(int i = 0; i < preorder.length; ++i){
            if(preorder[i] == elem){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(elem);
        int[] leftLeafPreOrder = new int[index];
        int[] rightLeafPreOrder = new int[preorder.length - index - 1];
        int[] leftLeafInOrder = new int[index];
        int[] rightLeafInOrder = new int[preorder.length - index - 1];

        System.arraycopy(preorder, 0, leftLeafPreOrder, 0, index);
        System.arraycopy(preorder, index + 1, rightLeafPreOrder, 0, rightLeafPreOrder.length);

        int li = 0;
        int ri = 0;

        for(int i = 1; i < inorder.length; ++i){
            int e = inorder[i];
            if(isIn(e, leftLeafPreOrder)){
                leftLeafInOrder[li] = e;
                ++li;
            }else if(isIn(e, rightLeafPreOrder)){
                rightLeafInOrder[ri] = e;
                ++ri;
            }else{
                System.out.println("wrong");
            }
        }

        root.left = buildTree(leftLeafPreOrder, leftLeafInOrder);
        root.right = buildTree(rightLeafPreOrder, rightLeafInOrder);

        return root;
    }

    private boolean isIn(int e, int[] array){
        for(int elem : array){
            if (e == elem){
                return true;
            }
        }
        return false;
    }
}
