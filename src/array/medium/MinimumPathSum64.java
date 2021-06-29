package array.medium;

import java.util.Arrays;

/**
 * tags: #dp
 */
public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum64 mps = new MinimumPathSum64();
        System.out.println(mps.minPathSum_Backtracking(grid));
        System.out.println(mps.minPathSum_BottomUp(grid));
        System.out.println(mps.minPathSum_Memo(grid));
        grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(mps.minPathSum_Backtracking(grid));
        System.out.println(mps.minPathSum_BottomUp(grid));
        System.out.println(mps.minPathSum_Memo(grid));
    }

    /*
    top-down + memorization
     */
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        if (memo[row][col] != 0) return memo[row][col];

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if (row < grid.length - 1) rowInc = minPathSumHelper(grid, row + 1, col, memo);
        if (col < grid[0].length - 1) colInc = minPathSumHelper(grid, row, col + 1, memo);
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
    }

    public int minPathSum_Memo(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        memo[0][0] = grid[0][0];
        return minPathSum_Memo(grid, memo, m - 1, n - 1);
    }

    private int minPathSum_Memo(int[][] grid, int[][] memo, int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] >= 0) {
            return memo[i][j];
        }

        memo[i][j] = Math.min(minPathSum_Memo(grid, memo, i - 1, j), minPathSum_Memo(grid, memo, i, j - 1)) + grid[i][j];
        return memo[i][j];
    }

    public int minPathSum_BottomUp(int[][] grid) {
        if (grid.length == 0) {
            throw new IllegalArgumentException();
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] minPathSums = new int[m][n];
        minPathSums[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    int minLeft = Integer.MAX_VALUE, minTop = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        minLeft = minPathSums[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        minTop = minPathSums[i][j - 1];
                    }
                    minPathSums[i][j] = Math.min(minLeft, minTop) + grid[i][j];
                }
            }
        }

        return minPathSums[m - 1][n - 1];
    }

    public int minPathSum_Backtracking(int[][] grid) {
        return backtrack(grid, grid.length, grid[0].length, 0, 0, Integer.MAX_VALUE, grid[0][0]);
    }

    private int backtrack(int[][] grid, int m, int n, int x, int y, int minSum, int sum) {
        if (sum > minSum || x == m - 1 && y == n - 1) {
            return Math.min(minSum, sum);
        }

        if (x + 1 < m) {
            sum += grid[x + 1][y];
            minSum = backtrack(grid, m, n, x + 1, y, minSum, sum);
            sum -= grid[x + 1][y];
        }

        if (y + 1 < n) {
            sum += grid[x][y + 1];
            minSum = backtrack(grid, m, n, x, y + 1, minSum, sum);
        }

        return minSum;
    }
}
