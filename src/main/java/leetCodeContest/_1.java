package leetCodeContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1 {

    public static void main(String[] args) {

        System.out.println((canBeEqual("bnxw", "bwxn")));
    }

    public static boolean canBeEqual(String s1, String s2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add(Arrays.toString(s1.toCharArray()));
        list2.add(Arrays.toString(s2.toCharArray()));


        for (int i = 0; i <= 1; i ++) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            char temp = c1[i];
            c1[i] = c1[i + 2];
            c1[i + 2] = temp;
            list1.add(Arrays.toString(c1));

            char temp2 = c2[i];
            c2[i] = c2[i + 2];
            c2[i + 2] = temp2;
            list2.add(Arrays.toString(c2));
        }

        for (String str1 : list1) {
            for (String str2 : list2) {
                if (str1.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
