package easy;


// https://leetcode.com/problems/length-of-last-word/

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord(""));
    }

    public int lengthOfLastWord(String s) {
        int index = 0;
        for(int i = s.length() - 1; i >= 0; --i){
            char ch = s.charAt(i);
            if(ch== ' ' && index != 0){
                return index;
            }else if((ch >= 'a' && ch <= 'z')||(ch >='A' && ch <= 'Z')){
                ++index;
            }
        }
        return index;
    }
}
