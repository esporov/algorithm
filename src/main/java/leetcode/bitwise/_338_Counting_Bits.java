package leetcode.bitwise;

//https://leetcode.com/problems/counting-bits/

/*
*   0. (Совсем плохо) Для каждого числа делим на 2 пока число не станет нулём и считаем кол-во встреченных единичек.
* O(n * log(n)) - по времени
*
*   1. (Не очень хорошо) - применяем метод O(1), независимо считающий биты в числе
*
*   2. (Оптимальное решение) - ДП. Сводим задачу к решению для меньшего N.
* Заполняем массив с количеством битов - берем значение уже заполненное этого массива и корректируем.
* 2 Варианта:
*   a) Откидываем (заменяем нулём) последний единичный бит
*   count[x] = count[x & (x-1)] +1
*
*   б) Убираем (вырезаем) из числа последний бит
*   count[x >> 1]
*
* 11101 x
*  1110 x >> 1
*
*   count[x] = count[x >> 1] + (x & 1)
*
*   число 5
*   2^4     2^3     2^2     2^1     2^0
*   16      8       4       2       1
*                   1       0       1
* */


import java.util.Arrays;

public class _338_Counting_Bits {
    public static void main(String[] args) {

        System.out.println(1/2);
        countBits(5);
    }

    public static int[] countBits(int n) {
        int[] array = new int[n+1];

        for (int i = 0; i <= n; i++) {
            int a = array[i >> 1];  // выкидываем последний бит числа
            int b = (i & 1);        // последний бит числа
//            array[i] = array[i >> 1] + (i & 1);
            array[i] = a + b;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
