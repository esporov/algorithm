package yandex.algos_5_0.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int a;
        int b;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String[] temp = bf.readLine().split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int result = sum(a, b);
        System.out.println(result);
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
