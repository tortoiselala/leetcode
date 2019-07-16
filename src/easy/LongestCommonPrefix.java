package easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for(String str : strs){
            if(str.length() < minLength){
                minLength = str.length();
            }
        }
        if(minLength == 0){
            return "";
        }

        for(int i = 0; i< minLength; ++i){
            char ch = strs[0].charAt(i);
            for(String str : strs){
                if(str.charAt(i) != ch){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLength);
    }

    public static void main(String[] args) {
        String[] strs = {
                "flower","flow","flight"
        };
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
