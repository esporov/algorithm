package leetcode.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class _217_Contains_Duplicate {


    public static boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
