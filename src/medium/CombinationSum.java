package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tortoiselala
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> s = new HashSet<>();
        for(int e : candidates){
            s.add(e);
        }
        return combinationSum(s, target);
    }
    private List<List<Integer>> combinationSum(Set<Integer> candidates, int target) {
        return null;
    }
}
