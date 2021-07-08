import java.util.ArrayList;
import java.util.List;

/**
 * tags: #backtracking
 */
public class GenerateParentheses22 {
    public List<String> generateParenthesis_Backtracking(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 1, 0, "(", result);
        return result;
    }

    private void generateParenthesis(int n, int leftCount, int rightCount, String s, List<String> result) {
        if (leftCount == n && rightCount == n) {
            result.add(s);
            return;
        }

        if (leftCount < n) {
            generateParenthesis(n, leftCount + 1, rightCount, s + "(", result);
        }

        if (rightCount < leftCount) {
            generateParenthesis(n, leftCount, rightCount + 1, s + ")", result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
