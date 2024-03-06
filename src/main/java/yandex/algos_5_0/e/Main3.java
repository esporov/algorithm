package yandex.algos_5_0.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) {
        String[] line;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            line = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(helper(line));
    }

    public static String helper(String[] line) {
        int curProfit = Integer.parseInt(line[0]);
        int divisor = Integer.parseInt(line[1]);
        int days = Integer.parseInt(line[2]);
        int result = -1;
        String wrong = "-1";

        int temp = curProfit * 10 + 9;
        if (temp < divisor) {
            return wrong;
        }
        temp -= 9;

        for (int i = 0; i < 10 ; i ++) {
            temp += i;
            if (temp % divisor == 0) {
                result = temp;
                break;
            }
            temp -= i;
        }
        if (result == -1) {
            return wrong;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        for (int i = 0; i < days - 1; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
