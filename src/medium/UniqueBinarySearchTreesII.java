package medium;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
       if(n == 0){
           return new LinkedList<>();
       }
       return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new LinkedList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; ++i){

            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    result.add(cur);
                }
            }
        }
        return result;
    }
}
