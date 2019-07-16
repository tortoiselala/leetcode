package weeklycontest.w140;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tortoiselala
 */
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] textSpiltArray = text.split(" ");
        List<String> list = new LinkedList<>();
        for(int i = 0; i < textSpiltArray.length - 2; ++i){
            if(textSpiltArray[i].equals(first) && textSpiltArray[i + 1].equals(second)){
                list.add(textSpiltArray[i + 2]);
            }
        }
        return list.toArray(new String[0]);
    }
}
