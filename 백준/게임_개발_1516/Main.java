/*
 * 백준 - 게임 개발
 *
 * https://www.acmicpc.net/problem/1516
 */
package 게임_개발_1516;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] results = new int[n + 1];
        int[] delays = new int[n + 1];
        int[] remains = new int[n + 1];

        List<Integer>[] map = new ArrayList[n + 1];
        for (int i = 0; i < map.length; i++) map[i] = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");

            int currDelay = Integer.parseInt(split[0]);
            delays[i] = results[i] = currDelay;

            for (int j = 1; j < split.length; j++) {
                int value = Integer.parseInt(split[j]);

                if (value == -1) break;
                map[value].add(i);
                remains[i]++;
            }
        }

        Queue<int[]> queue = new LinkedList<>(); // { idx, 지연시간 }
        for (int i = 1; i <= n; i++) {
            if (remains[i] == 0) queue.add(new int[]{i, delays[i]});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currIdx = poll[0];
            int currDelay = poll[1];

            for (int nextIdx : map[currIdx]) {
                remains[nextIdx]--;

                results[nextIdx] = Math.max(results[nextIdx], delays[nextIdx] + currDelay);
                if (remains[nextIdx] == 0) queue.add(new int[]{nextIdx, results[nextIdx]});
            }
        }

        for (int i = 1; i <= n; i++) System.out.println(results[i]);
    }
}
