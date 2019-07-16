package easy;

public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(2147395599));
    }


    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int l = 1, r = x, mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(mid > x / mid){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
}