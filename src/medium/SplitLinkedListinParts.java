package medium;

import entity.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tortoiselala
 */
public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null){
            return new ListNode[k];
        }
        int len = getLength(root);
        int e = len / k;
        int res = len - k * e;
        ListNode loop = root;
        int count = e;
        if(res > 0){
            ++count;
            --res;
        }
        List<ListNode> list = new LinkedList<>();
        list.add(root);
        while (loop != null) {
            --count;
            if(count <= 0 && loop.next != null){
                count = e;
                if(res > 0){
                    ++count;
                    --res;
                }
                ListNode tmp = loop.next;
                loop.next = null;
                list.add(tmp);
                loop = tmp;
            }else{
                loop = loop.next;
            }
        }

        int x = k - list.size();
        while(x > 0){
            list.add(null);
            --x;
        }
        return list.toArray(new ListNode[0]);
    }

    private int getLength(ListNode root){
       ListNode loop = root;
       int count = 0;
        while (loop != null) {
            ++count;
            loop = loop.next;
        }
        return count;
    }
}
