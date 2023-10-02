package leetcode.Heap_Priority_Queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _215_Kth_Largest_Element_in_a_Array {

    public static void main(String[] args) {

        findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }


    public static int findKthLargest2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }


        int index;
        ArrayList<Integer>[] list = new ArrayList[(int) 10E5];
        for (int num : nums) {
            index = num;
            if (index < 0) {
                list[-index].add(num);
            } else {
                list[index * 2].add(num);
            }
        }
        return 0;
    }


    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2.compareTo(num1));
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.peek();
    }
}
