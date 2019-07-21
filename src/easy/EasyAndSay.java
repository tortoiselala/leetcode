package easy;

/**
 * @author tortoiselala
 */
public class EasyAndSay {
    public String countAndSay(int n) {
        StringBuilder pre = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        pre.append('1');
        for(int i = 2; i <= n; ++i){
            int preLength = pre.length();
            char preChar = 0;
            int preCount = 0;
            for(int j = 0; j < preLength; ++j){
                if(preCount == 0){
                    preChar = pre.charAt(j);
                    ++preCount;
                    continue;
                }
                if(pre.charAt(j) == preChar){
                    ++preCount;
                }else{
                    cur.append(preCount);
                    cur.append(preChar);
                    preCount = 1;
                    preChar = pre.charAt(j);
                }
            }
            if(preCount != 0){
                cur.append(preCount);
                cur.append(preChar);
            }
            pre = cur;
            cur = new StringBuilder();
        }
        return pre.toString();
    }
}
