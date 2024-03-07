package yandex.algos_5_0.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int count;
        int nextLine;
        long max = 0;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            count = Integer.parseInt(bf.readLine());
            for (int i = 0; i < count; i++) {
                nextLine = Integer.parseInt(bf.readLine());
                max += spaceNumber(nextLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(max);
    }

    public static int spaceNumber(int num) {
        if (num == 0) {
            return 0;
        }
        int max = 0;
        int cur = num;
        while (cur != 0) {
            if (cur >= 4) {
                max = cur / 4;
                cur = cur % 4;
                continue;
            }
            if (cur > 1) {
                max += 2;
                break;
            }
            if (cur == 1) {
                max += 1;
                break;
            }
        }
        return max;
    }
}
