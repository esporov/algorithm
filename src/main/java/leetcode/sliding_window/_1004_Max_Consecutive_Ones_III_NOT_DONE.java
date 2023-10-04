package leetcode.sliding_window;

//https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75

public class _1004_Max_Consecutive_Ones_III_NOT_DONE {

    public static void main(String[] args) {
        // longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
       // longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
        longestOnes(new int[]{0,0,0,1,1,1,1}, 0);
    }

    public static int longestOnes(int[] nums, int k) {
        int maxRep = 0;
        int count = k;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j == nums.length - 1 && nums[j] == 1) {
                    maxRep = Math.max(j + 1 - i, maxRep);
                }
                if (count == 0) {
                    if (nums[j] == 0) {
                        maxRep = Math.max(j - i, maxRep);
                        break;
                    } else {
                        continue;
                    }
                }
                if (nums[j] == 0) {
                    count--;
                }
                maxRep = Math.max(j + 1 - i, maxRep);
            }
            count = k;
        }
        System.out.println(maxRep);
        return maxRep;
    }
}
