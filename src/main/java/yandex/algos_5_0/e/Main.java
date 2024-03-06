package yandex.algos_5_0.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        String[] line;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            line = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(helper(line));
    }

    public static BigInteger helper(String[] line) {

        BigInteger curProfit = BigInteger.valueOf(Integer.parseInt(line[0]));
        BigInteger divisor = BigInteger.valueOf(Integer.parseInt(line[1]));
        int days = Integer.parseInt(line[2]);
        boolean even = divisor.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO);
        Deque<BigInteger> stack = new ArrayDeque<>();
        stack.addFirst(curProfit);
        BigInteger result = BigInteger.ZERO;

        BigInteger wrong = BigInteger.valueOf(-1);

        while (days != 0) {
            if (!stack.isEmpty()) {
                BigInteger temp = BigInteger.ZERO;
                while (true) {
                    temp = stack.removeFirst().multiply(BigInteger.TEN).add(BigInteger.valueOf(9));

                    if (temp.compareTo(divisor) < 0) {
                        if (stack.isEmpty()) {
                            return wrong;
                        }
                        continue;
                    }
                    temp = temp.subtract(BigInteger.valueOf(9));
                    break;
                }

                int tempEven = 0;
                int tempOdd = 1;
                int i = even ? tempEven : tempOdd;

                while (i < 10) {
                    temp = temp.add(BigInteger.valueOf(i));
                    if (temp.remainder(divisor).equals(BigInteger.ZERO)) {
                        stack.addFirst(temp);
                    }

                    temp = temp.subtract(BigInteger.valueOf(i));
                    i += 2;
                }
                if (!stack.isEmpty()) {
                    if (!stack.getFirst().remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                        return wrong;
                    }
                } else return wrong;
            } else return wrong;

            days--;
            result = stack.getFirst();
        }
        return result;
    }
}
