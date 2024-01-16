package leetcode.arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class _1704_Determine_if_String_Halves_Are_Alike {
    public static void main(String[] args) {

    }

    public static boolean halvesAreAlike(String s) {
        Map<Character, Integer> map = new HashMap<>() {{
            put('a', 0);
            put('e', 0);
            put('i', 0);
            put('o', 0);
            put('u', 0);
            put('A', 0);
            put('E', 0);
            put('I', 0);
            put('O', 0);
            put('U', 0);
        }};
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                count1++;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                count2++;
            }
        }
        if (count2 == count1) {
            return true;
        } else {
            return false;
        }
    }
}
