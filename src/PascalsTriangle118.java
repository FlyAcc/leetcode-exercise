import java.util.ArrayList;
import java.util.List;

/**
 * tags: #DP
 */
public class PascalsTriangle118 {
    public List<List<Integer>> generate_DP(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        // Arrays.asList() is slower, why?
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> curr = new ArrayList<>(i);
            List<Integer> last = triangle.get(i - 2);
            for (int j = -1; j < i - 1; j++) {
                if (j == -1 || j == i - 2) {
                    curr.add(1);
                } else {
                    curr.add(last.get(j) + last.get(j + 1));
                }
            }
            triangle.add(curr);
        }
        return triangle;
    }
}
