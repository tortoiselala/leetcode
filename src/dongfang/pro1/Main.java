package dongfang.pro1;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        String str3 = in.next();

        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();

        if(len1 + len2 != len3){
            System.out.println("FALSE");
            return;
        }
        print(len1 == 0 && str2.equals(str3));
        print(len2 == 0 && str2.equals(str3));
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len1; ++i){
            dp[i][0] = dp[i - 1][0] && (str3.charAt(i - 1) == str1.charAt(i - 1));
        }

        for(int i = 1; i <= len2; ++i){
            dp[0][i] = dp[0][i - 1] && (str3.charAt(i - 1) == str2.charAt(i - 1));
        }

        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                int sum = i + j;
                if(str1.charAt(i - 1) == str3.charAt(sum - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }

                if(str2.charAt(j - 1) == str3.charAt(sum - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        print(dp[len1][len2]);
    }

    private static void print(boolean s){
        if(s){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
    }
}