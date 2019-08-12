package medium;

public class DecodeWays {
    public int numDecodings(String s) {
        int len;
        if(s == null || (len = s.length()) == 0){
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i < len + 1; ++i){
            int var1 = Integer.valueOf(s.substring(i - 1, i));
            int var2 = Integer.valueOf(s.substring(i - 2, i));
            if(var1 >= 1 && var1 <= 9){
                dp[i] += dp[i - 1];
            }

            if(var2 >= 10 && var2 <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
