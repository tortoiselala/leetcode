package easy;

// https://leetcode.com/problems/valid-perfect-square/submissions/
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1){
            return true;
        }
        int l = 1, r = num, m;
        while(l <= r){
            m = l + (r - l) / 2;
            if(m == num / m && m * m == num){
                return true;
            }else if(m > num / m){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return false;
    }
}
