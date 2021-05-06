package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * tags: #backtracking, #dp
 */
public class PalindromePartitioning131 {
    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning131 pp = new PalindromePartitioning131();
        System.out.println(pp.partition(s));
        s = "a";
        System.out.println(pp.partition(s));
        s = "aabbccdd";
        System.out.println(pp.partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> temps, int begin) {
        if (begin == s.length()) {
            result.add(new ArrayList<>(temps));
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            String temp = s.substring(begin, i + 1);
            if (!isPalindrome(temp)) {
                continue;
            }
            temps.add(temp);
            backtrack(s, result, temps, i + 1);
            temps.remove(temps.size() - 1);
        }
    }

    /*
    可以使用dp优化: 若字符串s满足以下条件，那么s互文
    1）s.charAt(start)==s.charAt(end)
    2) s.substring(start+1, end-1)为互文
     */
    private boolean isPalindrome(String s) {
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
