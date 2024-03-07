package leetCodeContest._20_01_24;


import java.util.*;

//100181. Divide an Array Into Subarrays With Minimum Cost I
public class _1 {

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{10,3,1,1}));
    }

    public static int minimumCost(int[] nums) {
        SortedMap<Integer, Integer> map = new TreeMap<>(Integer::compareTo);
        int j = 0;
        int sum = nums[0];
        for (int num : nums) {
            map.put(num, j++);
        }

        int tempIndex = map.get(nums[0]);
        j = 1;


            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (j == 3) {
                    break;
                }
                if (entry.getValue() > tempIndex) {
                    sum = sum + entry.getKey();
                    tempIndex = entry.getValue();
                    j++;
                }
            }

        return sum;
    }
}
