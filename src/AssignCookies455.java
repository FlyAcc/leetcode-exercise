import java.util.Arrays;

/**
 * tags: #sorting, #greedy
 */
public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int max = 0;
        while (i < g.length && j < s.length) {
            if (s[j++] >= g[i]) {
                i++;
                max++;
            }
        }

        return max;
    }
}
