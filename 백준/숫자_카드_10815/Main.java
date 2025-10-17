/*
 * 백준 - 숫자 카드
 *
 * https://www.acmicpc.net/problem/10815
 */
package 숫자_카드_10815;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int[] mineCards = getCards();
        int[] targetCards = getCards();

        Arrays.sort(mineCards);

        for (int i = 0; i < targetCards.length; i++) {
            if (Arrays.binarySearch(mineCards, targetCards[i]) >= 0) targetCards[i] = 1;
            else targetCards[i] = 0;
        }

        for (int target : targetCards) System.out.print(target + " ");
    }

    private static int[] getCards() {
        int len = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().split(" ");
        int[] cards = new int[len];
        for (int i = 0; i < len; i++) cards[i] = Integer.parseInt(split[i]);
        return cards;
    }
}
