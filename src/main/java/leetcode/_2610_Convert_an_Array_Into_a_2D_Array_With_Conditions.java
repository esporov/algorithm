package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class _2610_Convert_an_Array_Into_a_2D_Array_With_Conditions {

    public static void main(String[] args) {
        findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1});
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int temp = map.get(nums[i]) + 1;
                map.put(nums[i], temp);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator;
        Map.Entry<Integer, Integer> entry;
        while (map.size() != 0) {
            List<Integer> list = new ArrayList<>();
            iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = iterator.next();
                if (entry.getValue() > 0) {
                    list.add(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                } else {
                    iterator.remove();
                }
            }
            if (list.size() != 0) {
                result.add(list);
            }
        }
        return result;
    }
}
