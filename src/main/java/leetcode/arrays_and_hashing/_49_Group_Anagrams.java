package leetcode.arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class _49_Group_Anagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (String anagram : strs) {
            int[] char_count = new int[26];
            for (int i = 0; i < anagram.length(); i++) {
                char_count[anagram.charAt(i) - 'a'] += 1;
            }
            for (int num : char_count) {
                sb.append(num+13);
            }
            String code = sb.toString();
            if (!map.containsKey(code)) {
                map.put(code, List.of(anagram));
            } else {
                List<String> list = new ArrayList<>(map.get(code));
                list.add(anagram);
                map.put(code, list);
            }
            sb.delete(0, sb.length());
        }
        return new ArrayList<>(map.values());
    }


}
