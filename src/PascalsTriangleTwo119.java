import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleTwo119 {
    public static void main(String[] args) {
        PascalsTriangleTwo119 p = new PascalsTriangleTwo119();
        System.out.println(p.getRow(5));
    }

    /*
   我这种方法是使用两个list，当前的list需要用到上一个list，然而实际上没有这个必要
   见getRow()
    */
    public List<Integer> getRow_Brutal(int rowIndex) {
        List<Integer> rowPrev = new ArrayList<>();
        rowPrev.add(1);
        if (rowIndex == 0) {
            return rowPrev;
        }

        List<Integer> row = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            row.clear();
            row.add(1);
            for (int j = 0; j < rowPrev.size() - 1; j++) {
                row.add(rowPrev.get(j) + rowPrev.get(j + 1));
            }
            row.add(1);

            rowPrev = new ArrayList<>(row);
        }

        return row;
    }

    /*
    我们不需要使用两个list，这是因为下一层的数可以通过本层的数构造出来，
    对于1，2，1，实际就是将1，2，1向右移动一个单位变为0，1，2，1，两者相加为1，3，3，1
    这种方法有个技巧, 需要自底向上构造
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 0);
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            // IMPORTANT! Bottom up!
            // 这里row[j]发生了改变，如果我们从j=0开始，
            // 那么下一次循环使用的row[j-1]（也就是上一次的row[j]）是不正确的
            for (int j = i; j > 0; j--) {
                row[j] = row[j - 1] + row[j];
            }
        }
        return Arrays.asList(row);
    }
}
