package leetcode;

import java.util.Arrays;

public class _2966_Divide_Array_Into_Arrays_With_Max_Difference {
    public static void main(String[] args) {
        divideArray(new int[]{15, 13, 12, 13, 12, 14, 12, 2, 3, 13, 12, 14, 14, 13, 5, 12, 12, 2, 13, 2, 2}, 2);
    }

    public static int[][] divideArray(int[] nums, int k) {
        int size = nums.length / 3;
        int[] array = nums;
        int[][] result = new int[size][3];
        Arrays.sort(array);
        for (int i = 0, h = 0; i < array.length; i = i + 3, h++) {
            byte m = 0;
            int j = i;
            if (array[j + 2] - array[j] > k) {
                return new int[0][0];
            }
            while (j < i + 3) {
                result[h][m] = array[j];
                j++;
                m++;
            }
        }
        return result;
    }
}
