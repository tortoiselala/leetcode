package weeklycontest.w140;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tortoiselala
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();

        for(int depth = 1; depth < tiles.length() + 1; ++depth){

        }
        return set.size();
    }
    private void backtrack(char[] chars, int i){
        //
    }

    private void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
