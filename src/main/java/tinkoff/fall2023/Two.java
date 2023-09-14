package tinkoff.fall2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Two {
    public static void main(String[] args) {
        String str;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            str = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*sheriff("ftheriherffazfszkisrrs");
        sheriff("rifftratatashe");
        sheriff("heriffheriff");
        sheriff("theegorillaiswatching");
        sheriff("sherifsherifsherifsherifsheriffsherif");*/

        sheriff(str);
    }

    public static void sheriff(String str) {
        if (str.length() < 7) {
            System.out.println(0);
            return;
        }
        Map<Character, Integer> map = new HashMap<>(Map.of(
                's', 0,
                'h', 0,
                'e', 0,
                'r', 0,
                'i', 0,
                'f', 0
        ));

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case 's', 'h', 'e', 'r', 'i', 'f' -> map.put(c, map.get(c) + 1);
                default -> {
                }
            }
        }

        int min = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == 0) {
                System.out.println(0);
                return;
            }
            if (min == -1) {
                min = value;
            }
            if (value < min) {
                min = value;
            }
        }

        if (map.get('f') >= min * 2) {
            System.out.println(min);
        } else {
            System.out.println(map.get('f') / 2);
        }
    }
}
