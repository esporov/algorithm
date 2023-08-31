package leetcode.two_pointers;

public class _125_Valid_Palindrom {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        str = str.toLowerCase();
        System.out.println('z' - 'a');
        System.out.println(('9')-'0');
        str = "race a car";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        String str = s.toLowerCase();

        for (int i = 0, j = str.length() - 1; i <= j; ) {
            char left = str.charAt(i);

            if (left - 'a' <= 25 && left - 'a' >= 0 || left - '0' <= 9 && left - '0' >= 0 ) {
            }else {
                i++;
                continue;
            }
            char right  = str.charAt(j);
            if (right - 'a' <= 25 && right - 'a' >= 0 || right - '0' <= 9 && right - '0' >= 0 ) {
            }else {
                j--;
                continue;
            }

            if (left - 'a' == right - 'a') {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

}
