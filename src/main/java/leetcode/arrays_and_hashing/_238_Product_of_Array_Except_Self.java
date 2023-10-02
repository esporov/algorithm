package leetcode.arrays_and_hashing;

//https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75

public class _238_Product_of_Array_Except_Self {

    public static int[] productExceptSelf(int[] nums) {
        int max = 0;
        boolean hasZero = false;
        int numsOfZero = 0;

        for (int num : nums) {
            if (num != 0) {
                if (max == 0) {
                    max = 1;
                }
                max *= num;
            } else {
                hasZero = true;
                numsOfZero += 1;
            }
        }
        if (numsOfZero > 1) {
            max = 0;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (hasZero) {
                if (nums[i] == 0) {
                    result[i] = max;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = max / nums[i];
            }
        }
        return result;
    }
}
