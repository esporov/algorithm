package leetcode.arrays_and_hashing;

//https://leetcode.com/problems/maximum-odd-binary-number/description/?envType=daily-question&envId=2024-03-01
public class _2864_Maximum_Odd_Binary_Number {

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
    }
    public static String maximumOddBinaryNumber(String s) {
        int len = s.length();
        int max1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                max1++;
            }
        }
        StringBuilder sb = new StringBuilder(s.length());

        if (max1 > 1) {
            int temp = max1;
            while (temp != 1) {
                sb.append("1");
                temp--;
            }
            len = len - max1;
            while (len != 0) {
                sb.append("0");
                len--;
            }
            sb.append("1");
        }
        if (max1 == 1) {
            while (len != 1) {
                sb.append("0");
                len--;
            }
            sb.append("1");
        }
        return sb.toString();
    }
}
