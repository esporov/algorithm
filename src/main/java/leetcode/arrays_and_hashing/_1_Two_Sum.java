package leetcode.arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {

    public static void main(String[] args) {

        twoSumMap(new int[]{3, 2, 4}, 6);
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (result - nums[j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
