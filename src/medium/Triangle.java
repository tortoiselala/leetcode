package medium;

import java.util.LinkedList;
import java.util.List;

public class Triangle {
    public List<List<Integer>> minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> book = new LinkedList<>();
        List<Integer> r = new LinkedList<>();
        r.add(triangle.get(0).get(0));
        book.add(r);
        int preLevel = 1;
        int total = 1;
        for(int i = 1; i < triangle.size(); ++i){
            r = new LinkedList<>();
            book.add(r);
            for(int j = 0; j < i + 1; ++j){
                int cur = triangle.get(i).get(j);
                if(j == 0){
                    int pos = ((++total) + preLevel) / 2;
                    r.add(book.get(i - 1).get(pos - 1) + cur);
                }else if (j == i) {
                    int pos = ((++total) + preLevel) / 2;
                    r.add(book.get(i - 1).get(pos - 1) + cur);
                }else {
                    int left = ((++total) + preLevel) / 2;
                    int right = left + 1;
                    r.add(Integer.min(book.get(i - 1).get(left - 1) + cur, book.get(i - 1).get(right - 1) + cur));
                }
            }
        }

        r = book.get(book.size() - 1);
        int min = Integer.MAX_VALUE;
        for(Integer e : r){
            if(e < min){
                min = e;
            }
        }
        System.out.println(min);
        return book;
    }
}
