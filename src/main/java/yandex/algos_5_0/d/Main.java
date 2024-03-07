package yandex.algos_5_0.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        char[][] chess = new char[8][8];
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 8; i++) {
                chess[i] = bf.readLine().toCharArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int max = freeSpace(chess);
        System.out.println(max);
    }

    public static int freeSpace(char[][] chess) {
        int[] max = new int[1];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                switch (chess[i][j]) {
                    case 'R' -> {
                        countR(chess, i, j, max);
                        max[0] += 1;
                    }
                    case 'B' -> {
                        countB(chess, i, j, max);
                        max[0] += 1;
                    }
                }
            }
        }
        return 64 - max[0];
    }

    public static void countB(char[][] chess, int indexZ, int indexX, int[] max) {
        countB(chess, indexZ, indexX, '1', max);
        countB(chess, indexZ, indexX, '2', max);
        countB(chess, indexZ, indexX, '3', max);
        countB(chess, indexZ, indexX, '4', max);
    }

    public static void countR(char[][] chess, int indexZ, int indexX, int[] max) {
        countR(chess, indexZ, indexX, 'd', max);
        countR(chess, indexZ, indexX, 'u', max);
        countR(chess, indexZ, indexX, 'r', max);
        countR(chess, indexZ, indexX, 'l', max);
    }

    public static void countR(char[][] chess, int indexZ, int indexX, char direction, int[] max) {
        char temp = chess[indexZ][indexX];
        if (indexZ + 1 < 8 && direction == 'd') {
            if (chess[indexZ + 1][indexX] != 'B') {
                chess[indexZ][indexX] = '+';
                max[0] += 1;
                countR(chess, indexZ + 1, indexX, 'd', max);
            }
        }
        if (indexZ - 1 >= 0 && direction == 'u') {
            if (chess[indexZ - 1][indexX] != 'B') {
                chess[indexZ][indexX] = '+';
                countR(chess, indexZ - 1, indexX, 'u', max);
                max[0] += 1;
            }
        }
        if (indexX + 1 < 8 && direction == 'r') {
            if (chess[indexZ][indexX + 1] != 'B') {
                chess[indexZ][indexX] = '+';
                countR(chess, indexZ, indexX + 1, 'r', max);
                max[0] += 1;
            }
        }
        if (indexX - 1 >= 0 && direction == 'l') {
            if (chess[indexZ][indexX - 1] != 'B') {
                chess[indexZ][indexX] = '+';
                countR(chess, indexZ, indexX - 1, 'l', max);
                max[0] += 1;
            }
        }
    }

    public static void countB(char[][] chess, int indexZ, int indexX, char direction, int[] max) {
        if (indexZ + 1 < 8 && indexX + 1 < 8 && direction == '1') {
            if (chess[indexZ + 1][indexX + 1] != 'R') {
                chess[indexZ][indexX] = '+';
                countB(chess, indexZ + 1, indexX + 1, '1', max);
                max[0] += 1;
            }
        }
        if (indexZ - 1 >= 0 && indexX + 1 < 8 && direction == '2') {
            if (chess[indexZ - 1][indexX + 1] != 'R') {
                chess[indexZ][indexX] = '+';
                countB(chess, indexZ - 1, indexX + 1, '2', max);
                max[0] += 1;
            }
        }
        if (indexZ - 1 >= 0 && indexX - 1 >= 0 && direction == '3') {
            if (chess[indexZ - 1][indexX - 1] != 'R') {
                chess[indexZ][indexX] = '+';
                countB(chess, indexZ - 1, indexX - 1, '3', max);
                max[0] += 1;
            }
        }
        if (indexZ + 1 < 8 && indexX - 1 >= 0 && direction == '4') {
            if (chess[indexZ + 1][indexX - 1] != 'R') {
                chess[indexZ][indexX] = '+';
                countB(chess, indexZ + 1, indexX - 1, '4', max);
                max[0] += 1;
            }
        }
    }
}
