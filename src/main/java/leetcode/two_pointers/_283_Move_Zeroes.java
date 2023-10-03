package leetcode.two_pointers;

//https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _283_Move_Zeroes {

    public static void main(String[] args) {

        moveZeroes2(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    temp = nums[j];
                    nums[j] = 0;
                    nums[i] = temp;
                    break;
                }
            }
        }
    }
}
