package leetcode.two_pointers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/reverse-string/description/
public class _345_Reverse_Vowels_of_a_String {
    public static void main(String[] args) {
        reverseVowels("leetcode");
    }


    public static String reverseVowelsTwoPointer(String s) {
        Set<Character> set = new HashSet<>() {{
            add('a');
            add('A');
            add('e');
            add('E');
            add('i');
            add('I');
            add('o');
            add('O');
            add('u');
            add('U');
        }};
        char[] charArray = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (!set.contains(charArray[l])) {
                l++;
                continue;
            }
            if (!set.contains(charArray[r])) {
                r--;
                continue;
            }
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            r--;
            l++;
        }
        return String.valueOf(charArray);
    }

    public static String reverseVowels(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U':
                    stack.addFirst(s.charAt(i));
                    break;
            }
        }
        char[] result = new char[s.length()];
        for (int i = 0; i < result.length; i++) {
            switch (s.charAt(i)) {
                case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U':
                    result[i] = stack.pollFirst();
                    break;
                default:
                    result[i] = s.charAt(i);
            }
        }
        return String.valueOf(result);
    }
}
