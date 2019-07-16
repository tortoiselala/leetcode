package easy;

/**
 * @author tortoiselala
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] cs = s.toCharArray();
        while(l < r){
            if(!Character.isLetterOrDigit(cs[l])){
                ++l;
            }else if(!Character.isLetterOrDigit(cs[r])){
                --r;
            }else if(cs[l++] != cs[r++]){
                return false;
            }
        }
        return true;
    }
}
