package medium;

import org.junit.Test;
import sun.nio.cs.ext.IBM037;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void minimumTotal() {
        int count = 2;
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> e = new LinkedList<>();
        e.add(2);
        list.add(e);
        e = new LinkedList<>();
        e.add(3);
        e.add(4);
        list.add(e);
        e = new LinkedList<>();
        e.add(6);
        e.add(5);
        e.add(7);
        list.add(e);
        e = new LinkedList<>();
        e.add(4);
        e.add(1);
        e.add(8);
        e.add(3);
        list.add(e);



       print(new Triangle().minimumTotal(list));

    }
    private static void print(List<List<Integer>> list) {
        for (List<Integer> e : list) {
            for (Integer s : e) {
                System.out.printf("%d ", s);
            }
            System.out.println();
        }
    }
}