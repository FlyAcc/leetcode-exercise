package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * tags: #HashSet
 */
public class LongestSubstringNoRepeat3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubstringNoRepeat3 ls = new LongestSubstringNoRepeat3();
        System.out.println(ls.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int longest = 1;
        int start = 0;
        int end = 1;
        while (s.length() - start > longest) {
            for (int i = start; i <= end - 1; i++) {
                if (s.charAt(i) == s.charAt(end)) {
                    if (++start == end) {
                        end++;
                    }
                    break;
                } else if (i == end - 1) {
                    end++;
                    break;
                }
            }
            longest = Math.max(longest, end - start);
        }

        return longest;
    }

    /*
    基本的思路是使用set来存储（无重复字符的）substring，同时使用双指针，一个标识substring的开头，
    另一个标识新的待检查（是否重复）的字符。如果不重复，则将该字符添加进set里；否则从set中移除substring的首字符。
    和我的方法相比，使用了set来判断是否contain，节省了时间
     */
    public int lengthOfLongestSubstring_Set(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
