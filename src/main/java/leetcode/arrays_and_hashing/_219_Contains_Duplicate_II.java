package leetcode.arrays_and_hashing;

//https://leetcode.com/problems/contains-duplicate-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j
 * in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class _219_Contains_Duplicate_II {

    public static void main(String[] args) {
//        containsNearbyDuplicate(new int[]{0, 1, 2, 3, 2, 5}, 3);
//        containsNearbyDuplicateMap(new int[]{1,2,3,1,2,3}, 2);
        containsNearbyDuplicateMap(new int[]{1, 0, 1, 1}, 1);
    }

    public static boolean containsNearbyDuplicateMap(int[] nums, int k) {
        if (k == 0 || nums.length <= 1) {
            return false;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                var list = map.get(nums[i]);
                list.add(i);
                if (list.size() >= 2) {
                    int left = 0;
                    int right = 1;
                    while (left < list.size() - 1) {
                        int b = list.get(left);
                        while (right < list.size()) {
                            int a = list.get(right);
                            if (a - b <= k) {
                                return true;
                            } else {
                                break;
                            }
//                            right++;
                        }
                        left++;
                        right += left;
                    }

                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums.length <= 1) {
            return false;
        }

        int left = 0;
        int right = 1;

        while (left < nums.length - 1) {
            while (right < nums.length && right - left <= k) {
                if (nums[right] == nums[left]) {
                    return true;
                }
                right++;
            }
            left++;
            right += left;
        }
        return false;
    }
}
