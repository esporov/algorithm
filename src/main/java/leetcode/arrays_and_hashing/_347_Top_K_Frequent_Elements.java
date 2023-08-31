package leetcode.arrays_and_hashing;

import java.util.*;
import java.util.stream.Stream;

public class _347_Top_K_Frequent_Elements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] lists = new List[nums.length+1];
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (lists[entry.getValue()] == null) {
                lists[entry.getValue()] = new ArrayList<>();
            }
            lists[entry.getValue()].add(entry.getKey());
        }

        for (int i = lists.length-1; i>0 ; i--) {

            if (lists[i] != null) {
                for (Integer num : lists[i]) {
                    if (result.size() != k) {
                        result.add(num);
                    }
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
