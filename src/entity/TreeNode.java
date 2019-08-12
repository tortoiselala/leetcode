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

    public static TreeNode makeBinaryTree(int[] array){
        TreeNode root = new TreeNode(array[1]);
        makeBinaryTreeHelper(array, 1, root);
        return root;
    }

    private static void makeBinaryTreeHelper(int[] array, int pos, TreeNode cur){
        if(pos * 2 < array.length){
            cur.left = new TreeNode(array[pos * 2]);
            makeBinaryTreeHelper(array, pos * 2, cur.left);
        }
        if (pos  * 2 + 1 < array.length) {
            cur.right = new TreeNode(array[pos * 2 + 1]);
            makeBinaryTreeHelper(array, pos * 2 + 1, cur.right);
        }
    }
}

