package easy;


import entity.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/same-tree/
 * @author tortoiselala
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursion(p, q);
    }

    public boolean recursion(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private boolean iteration(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while(!stack.isEmpty()){
            TreeNode qT = stack.pop();
            TreeNode pT = stack.pop();
            if(qT.val != pT.val){
                return false;
            }

            if(pT.left != null && qT.left != null){
                stack.push(pT.left);
                stack.push(qT.left);
            }else if(pT.left != qT.left){
                return false;
            }

            if(pT.right != null && qT.right != null){
                stack.push(pT.right);
                stack.push(qT.right);
            }else if(pT.right != qT.right){
                return false;
            }
        }
        return true;
    }
}

