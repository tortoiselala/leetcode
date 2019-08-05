package medium;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue =  new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Queue<Node> nextLevel = new LinkedList<>();
            Node head = queue.poll();
            if(head.left != null) {
                nextLevel.add(head.left);
            }
            if(head.right != null) {
                nextLevel.add(head.right);
            }

            Node t = head;
            while(!queue.isEmpty()) {
                Node tmp = queue.poll();
                t.next = tmp;
                t = t.next;
                if(tmp.left != null) {
                    nextLevel.add(tmp.left);
                }
                if(tmp.right != null) {
                    nextLevel.add(tmp.right);
                }
            }

            queue = nextLevel;
        }
        return root;
    }
}
