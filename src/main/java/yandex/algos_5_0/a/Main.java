package yandex.algos_5_0.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A. Покраска деревьев
 * <p>
 * Вася и Маша участвуют в субботнике и красят стволы деревьев в белый цвет.
 * Деревья растут вдоль улицы через равные промежутки в 1 метр. Одно из деревьев обозначено числом ноль,
 * деревья по одну сторону занумерованы положительными числами 1, 2 и т.д., а в другую — отрицательными −1,−2 и т.д.
 * <p>
 * Ведро с краской для Васи установили возле дерева P, а для Маши — возле дерева Q.
 * Ведра с краской очень тяжелые и Вася с Машей не могут их переставить, поэтому они окунают кисть в ведро
 * и уже с этой кистью идут красить дерево. Краска на кисти из ведра Васи засыхает, когда он удаляется
 * от ведра более чем на V метров, а из ведра Маши — на M метров. Определите, сколько деревьев может быть покрашено.
 * <p>
 * Формат ввода
 * В первой строке содержится два целых числа P и V — номер дерева, у которого стоит ведро Васи
 * и на сколько деревьев он может от него удаляться.
 * <p>
 * Во второй строке содержится два целых числа Q и M — аналогичные данные для Маши.
 * <p>
 * Все числа целые и по модулю не превосходят 10<sup>8<sup/>.
 * <p>
 * <a href="https://contest.yandex.ru/contest/59539/problems/">Ссылка на заадчку</a>
 */
public class Main {
    public static void main(String[] args) {
        final int P;
        final int V;
        final int Q;
        final int M;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tempArray = bf.readLine().split(" ");
            P = Integer.parseInt(tempArray[0]);
            V = Integer.parseInt(tempArray[1]);
            tempArray = bf.readLine().split(" ");
            Q = Integer.parseInt(tempArray[0]);
            M = Integer.parseInt(tempArray[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int[] vInterval = makeInterval(P, V);
        int[] mInterval = makeInterval(Q, M);

        int result = checkInterval(vInterval, mInterval);
        System.out.println(result);
    }

    public static int[] makeInterval(int treePlace, int treeStep) {
        int[] newInterval = new int[2];
        newInterval[0] = treePlace - treeStep;
        newInterval[1] = treePlace + treeStep;
        return newInterval;
    }

    public static int checkInterval(int[] first, int[] second) {
        if (first[0] < second[0]) {
            if (first[1] <= second[1]) {
                if (first[1] < second[0]) {
                    return (first[1] - first[0]) + (second[1] - second[0]) + 2;
                } else {
                    return (second[1] - first[0]) + 1;
                }
            } else {
              return  first[1] - first[0] + 1;
            }
        }
        return checkInterval(second, first);
    }
}
