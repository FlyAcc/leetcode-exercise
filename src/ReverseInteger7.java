/**
 * tags: #reverse
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger7 {
    /*
    reverse问题我们可以将数据转为字符串，不过由于这边输入的是int，我们
    可以使用取余数的方式逐位逐位的读取，然后通过r * 10 + tail的方式构造整数。
     */
    public int reverse(int x) {
        int r = 0;
        // 注意这里是不等于0，考虑整数的情况
        while (x != 0) {
            int tail = x % 10;
            int temp = r * 10 + tail;
            // 由于reverse可能会溢出（溢出后数据会发生变化），因此我们比较一下数据的相等性
            // 注意这里(temp - tail) / 10用除法，也是避免溢出
            if ((temp - tail) / 10 != r) {
                return 0;
            }
            r = temp;
            x /= 10;
        }

        return r;
    }

    public int reverse_1(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        if (x < 0) sb.append("-");
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0 && x < 0) {
                break;
            }
            sb.append(s.charAt(i));
        }

        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse_2(int x) {
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        if (x < 0) {
            sb.deleteCharAt(0);
        }

        try {
            int r = Integer.parseInt(sb.reverse().toString());
            return x < 0 ? -r : r;
        } catch (Exception e) {
            return 0;
        }
    }
}
