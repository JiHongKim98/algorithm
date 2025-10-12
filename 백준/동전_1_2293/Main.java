/*
 * 백준 - 동전 1
 *
 * https://www.acmicpc.net/problem/2293
 */
package 동전_1_2293;

import java.util.Scanner;

// dp[i] = dp[i] + dp[i - value]
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nk = scanner.nextLine();
        String[] split = nk.split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] arr = new int[n + 1];
            arr[i] = scanner.nextInt();

            for (int j = arr[i]; j <= k; j++) dp[j] += dp[j - arr[i]];
        }

        System.out.println(dp[k]);
    }
}
