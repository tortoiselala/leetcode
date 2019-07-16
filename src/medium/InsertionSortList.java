package medium;

import entity.ListNode;

/**
 * @author tortoiselala
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {

        ListNode sortedHead = head, sortedTail = head;
        ListNode loop = null;
        if (head != null) {
            loop = head.next;
        }else{
            return null;
        }
        ListNode insert = null;
        ListNode loopForInsert;
        if (sortedTail.next != null) {
            sortedTail.next = null;
        }
        while (loop != null) {
            insert = loop;
            loop = loop.next;
            loopForInsert = sortedHead;
            // 应该插入到第一个元素
            if (insert.val < loopForInsert.val) {
                insert.next = loopForInsert;
                sortedHead = insert;
            }else{
                // 应该插入到除了第一个元素
                while(loopForInsert != sortedTail){

                    if(insert.val < loopForInsert.next.val){
                        insert.next = loopForInsert.next;
                        loopForInsert.next = insert;
                        break;
                    }
                    loopForInsert = loopForInsert.next;
                }
                // 插入到最后一个
                if(loopForInsert == sortedTail){
                    insert.next = sortedTail.next;
                    loopForInsert.next = insert;
                    sortedTail = insert;
                }
            }
        }
        return sortedHead;
    }
}
