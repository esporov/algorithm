package leetcode.arrays_and_hashing;

//https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75

public class _334_Increasing_Triplet_Subsequence {

    public static void main(String[] args) {
        increasingTriplet(new int[]{1, 5, 0, 4, 1, 3});
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstMin) {
                firstMin = num;
            }
            if (num <= secondMin && num > firstMin) {
                secondMin = num;
            }
            if (num > secondMin) {
                return true;
            }
        }
        return false;

    }
}


