package easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {

}
class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        delete(t);
        return queue.size();
    }

    private void delete(int t){
        int from = t - 3000;
        while(!queue.isEmpty()){
            int e = queue.peek();
            if(e < from){
                queue.poll();
            }else{
                return;
            }
        }
    }
}