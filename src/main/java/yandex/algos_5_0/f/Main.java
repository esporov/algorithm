package yandex.algos_5_0.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String[] line;
        int count;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            count = Integer.parseInt(bf.readLine());
            line = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(helper(count, line));
    }

    public static String helper(int count, String[] line) {
        int[] numArray = new int[line.length];
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < line.length; i++) {
            numArray[i] = Integer.parseInt(line[i]);
            if (numArray[i] % 2 == 0) {
                evenCount++;
            } else oddCount++;
        }
        int plusCount = 0;
        int multiplyCount = 0;
        if (evenCount != 0 && oddCount != 0) {
            plusCount = evenCount - 1;

            if (oddCount % 2 == 0) {
                multiplyCount += oddCount - 1;
            } else {
                multiplyCount += oddCount - 1;

            }
            plusCount += 1;
        } else if (evenCount == 0) {
            multiplyCount = oddCount - 1;
        } else if (oddCount == 0) {
            plusCount = evenCount - 1;
        }

        StringBuilder sb = new StringBuilder(plusCount + multiplyCount);
        while (plusCount > 0) {
            sb.append("+");
            plusCount--;
        }
        while (multiplyCount > 0) {
            sb.append("x");
            multiplyCount--;
        }
        return sb.toString();
    }
}
