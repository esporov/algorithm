package tinkoff.fall2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One {
    public static void main(String[] args) {
        String[] firstLine;
        String[] secondLine;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            firstLine = bf.readLine().split(" ");
            secondLine = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(mostExpensiveRevolver(firstLine, secondLine));
    }

    public static int mostExpensiveRevolver(String[] firstLine, String[] secondLine) {
        int numOfGuns = Integer.parseInt(firstLine[0]);
        int amount = Integer.parseInt(firstLine[1]);
        int result = 0;

        for (String numS : secondLine) {
            int numI = Integer.parseInt(numS);
            if (numI > result && numI <= amount) {
                result = numI;
            }
        }
        return result;
    }
}
