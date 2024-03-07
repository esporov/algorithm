package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sequential-digits/

/**
 * Example 1:
 * <p>
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * <p>
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 */
public class _1291_Sequential_Digits {

    public static void main(String[] args) {
        System.out.println(sequentialDigits(178546104, 812704742));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        byte lowDig = dig(low);
        StringBuilder sb = new StringBuilder();

        List<Integer> result = new ArrayList<>();
        byte curDig = lowDig;
        int current = makeMinNum(low, curDig, sb);
        if (current == -1) {
            curDig++;
            current = makeMinNum(curDig);
        }
        if (current == 0) {
            return result;
        }

        while (current <= high) {
            result.add(current);
            if (current == 123456789) {
                return result;
            }
            current = makeNewNum(current, curDig, sb);
            if (current == -1) {
                if (current < high) {
                    curDig = (byte) (curDig + 1);
                    current = makeMinNum(curDig);
                }
            }
        }
        return result;
    }

    private static int makeMinNum(int num, byte dig, StringBuilder sb) {
        int min = makeMinNum(dig);
        while (min < num) {
            min = makeNewNum(min, dig, sb);
            if (min == -1) {
                break;
            }
        }
        return min;
    }

    private static int makeMinNum(byte dig) {
        return switch (dig) {
            case 2 -> 12;
            case 3 -> 123;
            case 4 -> 1234;
            case 5 -> 12345;
            case 6 -> 123456;
            case 7 -> 1234567;
            case 8 -> 12345678;
            case 9 -> 123456789;
            case 10, 11 -> 0;
            default -> -1;
        };
    }

    private static int makeNewNum(int num, byte dig, StringBuilder sb) {
        String curStr = String.valueOf(num);
        if ('9' - curStr.charAt(dig - 1) != 0) {
            for (int i = 0; i < dig; i++) {
                byte b = (byte) (curStr.charAt(i) - '0' + 1);
                sb.append(b);
            }
            int result = Integer.parseInt(sb.toString());
            sb.delete(0, sb.length());
            return result;
        } else {
            return -1;
        }
    }

    private static byte dig(int num) {
        byte dig = 0;
        int cur = num;
        while (cur != 0) {
            cur = cur / 10;
            dig++;
        }
        return dig;
    }
}
