package leetcode.two_pointers;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/description/">Ссылочка</a>
 *
 * <p><strong>Example 1:</strong>
 *
 * <p> Input: s = "Let's take LeetCode contest"
 * <p> Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * <p><strong>Example 2:</strong>
 *
 * <p>Input: s = "Mr Ding"
 * <p>Output: "rM gniD"
 */

public class _557_Reverse_Words_in_a_String_III {
    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");

    }

    public static String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for (String str : array) {
            char[] charArray = str.toCharArray();
            reverseWord(charArray);
            sb.append(String.valueOf(charArray));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void reverseWord(char[] s) {
        int l = 0;
        int r = s.length-1;
        char temp;
        while (l <= r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
