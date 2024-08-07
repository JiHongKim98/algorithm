package 구현.색종이_2563;
/* 백준(구현) - 색종이
 *
 * https://www.acmicpc.net/problem/2563
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int total = 0;  // 검은 영역의 넓이

		boolean[][] arr = new boolean[101][101];  // 도화지

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// (x,y)부터 (x+9, y+9)까지의 영역을 하나씩 체크한 후 총 넓이에 더해준다
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (!arr[j][k]) {
						arr[j][k] = true;
						total++;
					}
				}
			}
		}
		System.out.print(total);
	}
}
