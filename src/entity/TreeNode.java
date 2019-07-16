package entity;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static void print(TreeNode root, int level){
        if(root == null){
            return;
        }
        for(int i = 0; i < level; ++i){
            System.out.printf("_");
        }
        System.out.println(root.val);
        print(root.left, level + 1);
        print(root.right, level + 1);
    }
}

