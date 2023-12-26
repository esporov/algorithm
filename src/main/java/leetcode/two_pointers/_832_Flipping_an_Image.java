package leetcode.two_pointers;

/**
 * <a href="https://leetcode.com/problems/flipping-an-image/">Ссылочка</a>
 *
 * <p><strong>Example 1:</strong>
 *
 * <p> image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * <p> Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p> Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * <p> Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
public class _832_Flipping_an_Image {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int l = 0;
            int r = image[i].length - 1;
            while (l <= r) {
                int tempL = image[i][r];
                int tempR = image[i][l];
                tempL = (tempL == 1) ? 0 : 1;
                tempR = (tempR == 1) ? 0 : 1;
                image[i][l] = tempL;
                image[i][r] = tempR;
                l++;
                r--;
            }
        }
        return image;
    }
}
