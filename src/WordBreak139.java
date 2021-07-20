import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class WordBreak139 {
    public static void main(String[] args) {
        WordBreak139 w = new WordBreak139();
        System.out.println(w.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        Boolean[] canBreakArr = new Boolean[l];
        return canBreak(s, wordDict, l - 1, canBreakArr);
    }

    private boolean canBreak(String s, List<String> wordDict, int pos, Boolean[] canBreakArr) {
        if (pos < 0) {
            return true;
        }

        for (String word : wordDict) {
            int l = word.length();
            if (pos - l + 1 < 0) {
                continue;
            }

            if (word.equals(s.substring(pos + 1 - l, pos + 1))) {
                if (pos - l < 0) {
                    return true;
                }

                if (canBreakArr[pos - l] == null) {
                    canBreakArr[pos - l] = canBreak(s, wordDict, pos - l, canBreakArr);
                }

                if (canBreakArr[pos - l]) {
                    return true;
                }
            }
        }

        return false;
    }
}
