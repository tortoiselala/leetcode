package beike.pro1;

import java.util.Scanner;

/**
 * @author tortoiselala
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextLong();
        }

        long minSub = Long.MAX_VALUE;
        int min = 1;
        for (int i = 1; i < n; ++i) {
            long sub = Math.abs(arr[i] - arr[i - 1]);
            if(sub < minSub) {
                min = i;
                minSub = sub;
            }
        }
        System.out.println(arr[min - 1] + " " + arr[min]);
    }
}
