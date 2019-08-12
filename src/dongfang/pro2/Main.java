package dongfang.pro2;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i){
            arr[i] = in.nextInt();
        }

        int minPrice = arr[0];
        int[] f = new int[n];
        int[] b = new int[n];

        for(int i = 1; i < n; ++i){
            f[i] = Integer.max(f[i - 1], arr[i] - minPrice);
            minPrice = Integer.min(arr[i], minPrice);
        }

        int maxPrice = arr[n - 1];
        for(int i = n - 2; i >= 0; --i){
            b[i] = Integer.max(b[i + 1], maxPrice - arr[i]);
            maxPrice = Integer.max(maxPrice, arr[i]);
        }

        int res = 0;
        for(int i = 0; i < n - 1; ++i){
            res = Integer.max(f[i] + b[i + 1], f[i]);
        }

        res = Integer.max(res, f[n - 1]);
        System.out.println(res);
    }
}