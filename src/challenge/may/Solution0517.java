package challenge.may;

import java.util.Arrays;
import java.util.Comparator;

public class Solution0517 {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "ab", "ac", "bd", "abc", "abd", "abdd"};
        Solution0517 s = new Solution0517();
        System.out.println(s.longestStrChain(words));
        words = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(s.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int longest = 1;
        for (int i = 0; i + longest <= words.length; i++) {
            int count = 1;
            int start = i;
            int next = i + 1;
            String predecessor = words[i];
            while (next < words.length) {
                if (words[next].length() > predecessor.length() + 1) {
                    break;
                } else if (words[next].length() == predecessor.length() + 1) {
                    if (isPredecessor(predecessor, words[next])) {
                        count++;
                        predecessor = words[next];
                    }
                }
                next++;
            }
            longest = Math.max(count, longest);
        }

        return longest;
    }

    private boolean isPredecessor(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;
        boolean firstTime = true;
        while (p1 < s1.length()) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                if (firstTime) {
                    firstTime = false;
                    p2++;
                    if (s1.charAt(p1) != s2.charAt(p2)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            p1++;
            p2++;
        }

        return true;
    }
}
