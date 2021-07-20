import java.util.Arrays;

/**
 * tags: #sorting
 */
public class LongestCommonPrefix14 {
    /*
    该题给出一组字符串，目标是找出这些字符串最长的共同前缀
    我们可以对这组字符串排序（如flow， flower，flight排序后会变为flight，flow，flower），
    这么一来，我们只需要比较首位两个字符串，找出他们的共同前缀即可
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }

    /*
    还有一种方法是逐字母地对比所有字符串
     */
    public String longestCommonPrefix_Vertical(String[] strs) {
        if (strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public String longestCommonPrefix_Horizon(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
