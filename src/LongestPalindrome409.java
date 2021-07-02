import java.util.HashSet;
import java.util.Set;

/**
 * 该题使用字符串的字符构造回文，求回文最大的长度。
 * 最大长度 = 重复的字符数*2+单个的字符数（最大为1）
 * tags: #Set
 */
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>(s.length());
        int dupCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                dupCount++;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return dupCount * 2 + (set.size() > 0 ? 1 : 0);
    }
}
