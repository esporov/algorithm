package leetcode.other;


//https://leetcode.com/problems/add-digits/

public class _258_Add_Digits {

    public static void main(String[] args) {


        System.out.println(addDigits(10));

    }


    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int res = num;
        int temp = 0;
        StringBuilder sb = new StringBuilder();

        while (res >= 10) {
            sb.append(res);
            for (int i = 0; i < sb.length(); i++) {
                temp += sb.charAt(i)-'0';
            }
            res = temp;
            temp = 0;
            sb.delete(0, sb.length());
        }
        return res;
    }


}
