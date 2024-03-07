package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1235_Maximum_Profit_in_Job_Scheduling {
    public static void main(String[] args) {

    }

    //Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int l = 0;
//        int lFinish = lStart + 1;
        int[] lInterval = new int[2];

        int r = l + 1;
//        int rFinish = rStart + 1;
        int[] rInterval = new int[2];

        for (int i = 0; i < endTime.length; i++) {
            while (r < endTime.length) {
                if (startTime[r] > endTime[l]) {
                    set1.add(l);
                    set1.add(r);
                    r++;
                }
            }
            l++;
        }
        return 0;
    }

}
