package leetcode.arrays_and_hashing;

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/

import java.util.ArrayList;
import java.util.List;

/**
 *There are n kids with candies. You are given an integer array candies, where each candies[i] represents
 * the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies
 * that you have.
 * <p>
 *Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
 * they will have the greatest number of candies among all the kids, or false otherwise.
 * <p>
 * Note that multiple kids can have the greatest number of candies.
 * <p>
 * Example 1:
 * <p>
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * <p>Output: [true,true,true,false,true]
 * <p>Explanation: If you give all extraCandies to:
 * <p>- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
 * <p>- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
 * <p>- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
 * <p>- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
 * <p>- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
 * <p> Example 2:
 * <p> Input: candies = [4,2,1,1,2], extraCandies = 1
 * <p> Output: [true,false,false,false,false]
 * <p>Explanation: There is only 1 extra candy.
 * <p> Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
 * <p> Example 3:
 * <p> Input: candies = [12,1,12], extraCandies = 10
 * <p> Output: [true,false,true]
*/

public class _1431_Kids_With_the_Greatest_Number_of_Candies {

    public static void main(String[] args) {

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= max) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
