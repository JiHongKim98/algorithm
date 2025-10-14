/*
 * 백준 - 동전 2
 *
 * https://www.acmicpc.net/problem/2294
 */
package 동전_2_2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int _INF = 100_001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nk = scanner.nextLine();
        String[] split = nk.split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = scanner.nextInt();
        Arrays.sort(arr);

        int[] map = new int[k + 1];
        Arrays.fill(map, _INF);
        map[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                map[j] = Math.min(map[j], map[j - arr[i]] + 1);
            }
        }

        int result = map[k] == _INF ? -1 : map[k];
        System.out.println(result);
    }
}
