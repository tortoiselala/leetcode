package beike.pro4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tortoiselala
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        // 选定j为峰值，递增左右，
        for(int j = n - 1; j >= 0; --j) {
            int[] tmp = Arrays.copyOf(arr, n);
            int minAdd = 0;
            // 递增左边
            for(int i = 0; i < j; ++i) {
                if(i > 0 && tmp[i] <= tmp[i - 1]) {
                    minAdd += tmp[i - 1] + 1 - tmp[i];
                    tmp[i] = tmp[i - 1] + 1;
                }
                if(tmp[i] >= tmp[j]) {
                    minAdd += tmp[i] + 1 - tmp[j];
                    tmp[j] = tmp[i] + 1;
                }
            }

            // 递增右边
            for (int i = n - 1; i > j; --i) {
                if(i + 1 < n && tmp[i + 1] >= tmp[i]) {
                    minAdd += tmp[i + 1] + 1 - tmp[i];
                    tmp[i] = tmp[i + 1] + 1;
                }
                if(tmp[i] >= tmp[j]) {
                    minAdd += tmp[i] + 1 - tmp[j];
                    tmp[j] = tmp[i] + 1;
                }
            }
            if(minAdd < min) {
                min = minAdd;
            }
        }


            System.out.println(min);

    }
}
