/*
 * 백준 - 먹을 것인가 먹힐 것인가
 *
 * https://www.acmicpc.net/problem/7795
 */
package 먹을_것인가_먹힐_것인가_7795;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();

        for (int t = 0; t < tc; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) A[i] = scanner.nextInt();
            for (int i = 0; i < M; i++) B[i] = scanner.nextInt();

            Arrays.sort(B);

            int count = 0;
            for (int currA : A) {
                int min = 0;
                int max = B.length - 1;
                int curr = 0;

                while (min <= max) {
                    int mid = (min + max) / 2;

                    if (currA > B[mid]) {
                        curr = mid + 1;
                        min = mid + 1;
                    } else {
                        max = mid - 1;
                    }
                }

                count += curr;
            }

            System.out.println(count);
        }
    }
}
