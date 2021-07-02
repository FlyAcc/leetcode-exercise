/**
 * tags: #DP
 */
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        LongestPalindromicSubstring5 l = new LongestPalindromicSubstring5();
        System.out.println(l.longestPalindrome("babad"));
        System.out.println(l.longestPalindrome("ac"));
        System.out.println(l.longestPalindrome("aa"));
        System.out.println(l.longestPalindrome("cbbd"));
        System.out.println(l.longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = longestPalindrome(s, i, i);
            int length2 = longestPalindrome(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int longestPalindrome(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome_DP(String s) {
        int l = s.length();
        if (l <= 1) {
            return s;
        }

        boolean[][] palindrome = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            palindrome[i][i] = true;
        }

        int start = 0, end = 0, longest = 0;
        for (int length = 2; length <= l; length++) {
            int i = 0, j = length - 1;
            while (j < l) {
                palindrome[i][j] = (j - i == 1 || palindrome[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                if (palindrome[i][j] && (j - i) > longest) {
                    end = j;
                    start = i;
                    longest = end - start;
                }
                i++;
                j++;
            }
        }

        return s.substring(start, end + 1);
    }

    public String longestPalindrome_Brutal(String s) {
        int l = s.length();
        if (l <= 1) {
            return s;
        }

        int start = 0;
        int longest = 1;
        for (int left = 0; left + longest < l; left++) {
            for (int right = l - 1; right > left + longest - 1; right--) {
                if (isPalindromic(s, left, right)) {
                    longest = right - left + 1;
                    start = left;
                    break;
                }
            }
        }

        return s.substring(start, start + longest);
    }

    private boolean isPalindromic(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
