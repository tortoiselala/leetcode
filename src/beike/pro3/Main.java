package beike.pro3;

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

        int maxRaceNum = 0;
        for(int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; j++) {

                int tmin = Math.min(arr[i], arr[j]);
                int tmax = Math.max(arr[i], arr[j]);
                if(tmin >= tmax * 0.9){
                    maxRaceNum ++;
                }

            }
        }
        System.out.println(maxRaceNum);
    }
}
