package medium;

import entity.ListNode;

/**
 * @author tortoiselala
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        ListNode loop = head;
        boolean counting = false;
        while(loop != null){
            if(isElem(G, loop.val)){
                if(counting){
                    ;
                }else{
                    counting = true;
                    ++count;
                }
            }else{
                counting = false;
            }
            loop = loop.next;
        }
        return count;
    }

    private boolean isElem(int[] G, int e){
        for(int el : G){
            if(e == el){
                return true;
            }
        }
        return false;
    }
}
