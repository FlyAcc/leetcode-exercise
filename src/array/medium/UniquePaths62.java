package array.medium;

/**
 * tags: #dp
 */
public class UniquePaths62 {
    public static void main(String[] args) {
        int m = 3, n = 2;
        UniquePaths62 up = new UniquePaths62();
        System.out.println(up.uniquePaths_Backtracking(m, n));
        System.out.println(up.uniquePaths(m, n));
        m = 3;
        n = 7;
        System.out.println(up.uniquePaths_Backtracking(m, n));
        System.out.println(up.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < n) {
                paths[0][i] = 1;
            }

            if (i < m) {
                paths[i][0] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }

    public int uniquePaths_Backtracking(int m, int n) {
        return backtrack(m, n, 0, 0, 0);
    }

    private int backtrack(int m, int n, int row, int column, int count) {
        if (row == m - 1 && column == n - 1) {
            return count + 1;
        } else if (row >= m || column >= n) {
            return count;
        }

        count = backtrack(m, n, row + 1, column, count);
        count = backtrack(m, n, row, column + 1, count);
        return count;
    }
}
