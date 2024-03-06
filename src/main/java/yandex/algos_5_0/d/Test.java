package yandex.algos_5_0.d;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chess = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine().trim();
            for (int j = 0; j < 8; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[i][j] == '*') {
                    if (!isUnderAttack(chess, i, j)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isUnderAttack(char[][] board, int x, int y) {
        for (int i = 0; i < 8; i++) {
            if (board[x][i] == 'R' || board[i][y] == 'R') {
                return true;
            }
        }

        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            if (board[i][j] == 'B') {
                return true;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'B') {
                return true;
            }
        }
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            if (board[i][j] == 'B') {
                return true;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            if (board[i][j] == 'B') {
                return true;
            }
        }
        return false;
    }
}
