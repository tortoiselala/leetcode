package medium;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tortoiselala
 */
public class PathSumII {
    List<List<Integer>> re = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return re;
        }
        dfs(root, sum, 0, new LinkedList<Integer>());
        return re;
    }

    private void dfs(TreeNode root, int target, int sum, List<Integer> cur){
        cur.add(root.val);
        int c = sum + root.val;
        if(c == target && root.left == null && root.right == null){
            re.add(new LinkedList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }

        if(root.left != null){
            dfs(root.left, target, c, cur);
        }

        if (root.right != null) {
            dfs(root.right, target, c, cur);
        }

        cur.remove(cur.size() - 1);
    }
}
