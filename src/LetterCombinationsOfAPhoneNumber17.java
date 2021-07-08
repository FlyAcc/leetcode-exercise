import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * tags: #backtracking, #queue, #bfs
 */
public class LetterCombinationsOfAPhoneNumber17 {
    private static final String[] mapping = new String[]{"0", "1", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber17 l = new LetterCombinationsOfAPhoneNumber17();
        System.out.println(l.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() >= 1) {
            letterCombinations(digits, 0, new StringBuilder(), result);
        }
        return result;
    }

    private void letterCombinations(String digits, int curr, StringBuilder s, List<String> result) {
        if (curr == digits.length()) {
            result.add(s.toString());
            return;
        }

        String letters = mapping[digits.charAt(curr) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            if (i != 0) {
                s.deleteCharAt(s.length() - 1);
            }
            s.append(letters.charAt(i));
            letterCombinations(digits, curr + 1, new StringBuilder(s), result);
        }
    }

    public List<String> letterCombinations_bfs(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }
}
