package leetcode.two_pointers;

//https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75

public class _11_Container_With_Most_Water {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area = 0;

        while (left < right) {
            int width = right - left;
            area = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, area);
            if (height[left] == height[right]) {
                left++;
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
