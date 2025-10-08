/*
 * 백준 - 2xn 타일링
 *
 * https://www.acmicpc.net/problem/11726
 */
package 이xn_타일링_11726;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        System.out.println(dp[n]);
    }
}
