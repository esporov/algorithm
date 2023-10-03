package leetcode.two_pointers;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75

import java.util.HashMap;
import java.util.Map;

public class _1679_Max_Number_of_K_Sum_Pairs {

    public static void main(String[] args) {

        //   maxOperations(new int[]{3, 1, 3, 4, 3}, 6);
        maxOperations(new int[]{4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2);
        // maxOperations(new int[]{3,1,5,1,1,1,1,1,2,2,3,2,2}, 1);

    }

    public static int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = k - nums[i];
            if (map.containsKey(res)) {
                count++;
                if (map.get(res) == 1) {
                    map.remove(res);
                } else {
                    map.put(res, map.get(res) - 1);
                }
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
