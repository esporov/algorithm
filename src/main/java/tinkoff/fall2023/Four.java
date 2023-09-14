package tinkoff.fall2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Four {

    public static void main(String[] args) {
        String[] firstLine;
        String[] secondLine;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            firstLine = bf.readLine().split(" ");
            secondLine = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        money(firstLine, secondLine);
    }

    public static void money(String[] fistLine, String[] secondLine) {
        int moneyToHave = Integer.parseInt(fistLine[0]);
        List<Integer> bankList = new ArrayList<>();

        for (String str : secondLine) {
            bankList.add(Integer.parseInt(str));
            bankList.add(Integer.parseInt(str));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        List<Integer> moneyList = new ArrayList<>();

        for (int i = 0; i < bankList.size(); i++) {
            for (int j = i ; j < bankList.size(); j++) {

                sum += bankList.get(j);
                moneyList.add(bankList.get(j));
                map.put(sum, moneyList);

                if (sum > moneyToHave) {
                    sum = 0;
                    moneyList.clear();
                    continue;
                }
                if (map.containsKey(moneyToHave)) {
                    System.out.println(moneyList.size());
                    moneyList.forEach(g -> System.out.print(g+" "));
                    return;
                }
            }
            sum = 0;
            moneyList.clear();
        }
        System.out.println(-1);
    }
}
