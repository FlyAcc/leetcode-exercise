package array.medium;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum64 mps = new MinimumPathSum64();
        System.out.println(mps.minPathSum_Backtracking(grid));
        System.out.println(mps.minPathSum(grid));
        grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(mps.minPathSum_Backtracking(grid));
        System.out.println(mps.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
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
