package leetcode.Merge_Intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class _56_Merge_Intervals {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(test)));

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1 , arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> resultArray = new ArrayList<>();

        int[] curInterval = intervals[0];
        resultArray.add(curInterval);

        for (int[] interval : intervals) {
            int curBegin = curInterval[0];
            int curEnd = curInterval[1];
            int nexBegin = interval[0];
            int nextEnd = interval[1];

            if (curEnd >= nexBegin) {
                curInterval[1] = nextEnd;
            } else {
                curInterval = interval;
                resultArray.add(curInterval);
            }
        }
        return resultArray.toArray(new int[resultArray.size()][]);
    }
}
