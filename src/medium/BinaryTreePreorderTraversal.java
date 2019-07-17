package medium;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author tortoiselala
 */
public class BinaryTreePreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> r = new LinkedList<>();
        TreeNode l = root;
        while(l != null){
            r.add(l.val);
            if(l.right != null){
                stack.push(l.right);
            }
            if(l.left != null){
                l = l.left;
            }else if(!stack.isEmpty()){
                l = stack.pop();
            }else{
                l = null;
            }
        }
        return r;
    }
}
