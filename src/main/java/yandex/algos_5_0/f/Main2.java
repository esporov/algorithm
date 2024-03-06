package yandex.algos_5_0.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) {
        String[] line;
        int count;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            count = Integer.parseInt(bf.readLine());
            line = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(helper(line));
    }

    public static String helper(String[] line) {
        StringBuilder sb = new StringBuilder(line.length - 1);
        boolean isCurEven;
        int cur = Integer.parseInt(line[0]);
        if (cur % 2 == 0) {
            isCurEven = true;
        } else isCurEven = false;
        for (int i = 0; i < line.length - 1; i++) {
            int next = Integer.parseInt(line[i + 1]);
            if (isCurEven) {
                if (next % 2 == 0) {
                    sb.append("x");
                    isCurEven = true;
                } else {
                    sb.append("+");
                    isCurEven = false;
                }
            } else {
                if (next % 2 == 0) {
                    sb.append("+");
                } else {
                    sb.append("x");

                }
                isCurEven = false;
            }
        }
        return sb.toString();
    }
}
