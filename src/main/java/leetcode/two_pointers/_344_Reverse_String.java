package leetcode.two_pointers;

public class _344_Reverse_String {

    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }

    public static void reverseString(char[] s) {
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
