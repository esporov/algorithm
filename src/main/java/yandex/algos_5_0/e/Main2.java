package yandex.algos_5_0.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main2 {

    public static void main(String[] args) {
        String[] line;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            line = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(helper(line));
    }

    public static int helper(String[] line) {
        int curProfit = Integer.parseInt(line[0]);
        int divisor = Integer.parseInt(line[1]);
        int days = Integer.parseInt(line[2]);
        boolean even = divisor % 2 == 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(curProfit);
        int result = 0;
        return 0;
    }
}
