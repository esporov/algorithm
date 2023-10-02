package leetcode.arrays_and_hashing;

public class _200_Number_of_Islands {

    //https://leetcode.com/problems/number-of-islands/

    // ["0","0","0","1","0"],
    // ["0","1","1","1","0"],
    // ["0","0","1","0","0"],
    // ["0","1","1","1","1"]

    public static void main(String[] args) {

        char[][] chars = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        numIslands(chars);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    markIsland(i, j, grid);
                    count+=1;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    private static void markIsland(int i, int j, char[][] grid) {
        grid[i][j] = '2';
        if (i > 0) {
            if (grid[i - 1][j] == '1') {
                markIsland(i - 1, j, grid);
            }
        }
        if (i < grid.length - 1) {
            if (grid[i + 1][j] == '1') {
                markIsland(i + 1, j, grid);
            }
        }

        if (j < grid[i].length - 1) {
            if (grid[i][j + 1] == '1') {
                markIsland(i, j + 1, grid);
            }
        }
        if (j > 0) {
            if (grid[i][j - 1] == '1') {
                markIsland(i, j - 1, grid);
            }
        }
    }
}
