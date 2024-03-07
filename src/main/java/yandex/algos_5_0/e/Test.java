package yandex.algos_5_0.e;

import java.math.BigInteger;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем входные данные
        BigInteger n = scanner.nextBigInteger(); // изначальная прибыль
        BigInteger k = scanner.nextBigInteger(); // количество учредителей компании
        BigInteger d = scanner.nextBigInteger(); // количество дней

        scanner.close();

        // Приписываем по одной цифре в конец числа, чтобы прибыль в каждый из дней была кратна k
        StringBuilder result = new StringBuilder(String.valueOf(n));

        for (BigInteger i = BigInteger.ONE; i.compareTo(d) <= 0; i = i.add(BigInteger.ONE)) {
            boolean found = false;
            for (int j = 1; j <= 9; j++) {
                // Добавляем к числу новую цифру
                BigInteger newProfit = new BigInteger(result.toString() + j);
                // Проверяем, делится ли новая прибыль на k
                if (newProfit.remainder(k).equals(BigInteger.ZERO)) {
                    result.append(j);
                    found = true;
                    break;
                }
            }
            // Если не удалось найти подходящую цифру, выводим -1 и завершаем программу
            if (!found) {
                System.out.println(-1);
                return;
            }
        }

        // Выводим результат
        System.out.println(result);
    }
}
