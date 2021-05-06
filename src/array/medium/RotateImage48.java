package array.medium;

import java.util.Arrays;

public class RotateImage48 {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage48 rotateImage = new RotateImage48();
        System.out.println(Arrays.deepToString(image));
        rotateImage.rotate(image);
        System.out.println(Arrays.deepToString(image));
        image = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate_TransposeAndReverse(image);
        System.out.println(Arrays.deepToString(image));
    }

    /*
    将一个矩阵旋转90°，即依次将matrix[i][j]→matrix[j][n-1-i]
    观察到matrix[i][j]→matrix[j][n-1-i]→matrix[n-1-i][n-1-j]→matrix[n-1-j][i]→matrix[i][j]
    （通过画图也可以发现元素的置换是四个元素之间的相互替换），因此每次置换需要四次值交换操作。
    另外，由于i=a的置换过程等价于i=n-1-a的置换过程，因此为避免将已经置换过的元素又还原，我们需要在
    (n-1)/2元素处停下（即<(n+1)/2或<=(n-1)/2）
    同理，对于j也是一样，j<(n+1)/2，然而j=(n-1)/2的置换过程
    matrix[i][(n-1)/2]→matrix[(n-1)/2][n-1-i]→matrix[n-1-i][(n-1)/2]→matrix[(n-1)/2][i]→matrix[i][(n-1)/2]
    等价于i=(n-1)/2的置换过程
    matrix[(n-1)/2][j]→matrix[j][(n-1)/2]→matrix[(n-1)/2][n-1-j]→matrix[n-1-j][(n-1)/2]→matrix[(n-1)/2][j],
    为避免置换后的元素被还原，j要小于n/2（考虑到n可能为奇偶数）
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    // rotate the matrix 90 degree clockwise = transpose + reflect
    public void rotate_TransposeAndReverse(int[][] matrix) {
        int n = matrix.length;
        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reflect the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
