/**
 * 该题判断给定的字符串是否为回文（允许删除一个字符），需要注意的是，
 * 当左边的字符不等于右边的字符，我们既可以删除左边的字符也可以删除右边的字符
 * tags: #two-pointer
 */
public class ValidPalindrome680 {
    public static void main(String[] args) {
        ValidPalindrome680 v = new ValidPalindrome680();
        System.out.println(v.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(v.validPalindrome("acb"));
    }

    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            // 分别删除左边及右边字符，判断结果
            if (s.charAt(l) != s.charAt(r))
                return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}
