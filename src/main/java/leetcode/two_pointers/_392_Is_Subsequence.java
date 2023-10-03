package leetcode.two_pointers;

//https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75

public class _392_Is_Subsequence {
    public static void main(String[] args) {

    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        for (int i = 0, j = 0; i < t.length() && j < s.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                if (j == s.length() - 1) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
