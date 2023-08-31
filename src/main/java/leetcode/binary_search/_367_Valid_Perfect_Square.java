package leetcode.binary_search;

//https://leetcode.com/problems/valid-perfect-square/

public class _367_Valid_Perfect_Square {

    public static void main(String[] args) {

        System.out.println(isPerfectSquare(2147483647));
    }

    public static boolean isPerfectSquare(int num) {

        long first = 1;
        long last = num;
        long mid;
        long res;

        while (first <= last) {
            mid = first + (last - first) / 2;
            res = mid * mid;
            if (res == num) {
                return true;
            }
            if (res > num) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return false;
    }
}
