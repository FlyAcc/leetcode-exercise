package algorithm.recursion;

public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        String s = "ABBAABBA";
        System.out.println(ip.isPalindrome(s));
        s = "ABBAABBAAA";
        System.out.println(ip.isPalindrome(s));
        s = "ASSDFTGGTFDSSA";
        System.out.println(ip.isPalindrome(s));
        s = "ASSDFTGFGTFDSSA";
        System.out.println(ip.isPalindrome(s));
        s = "";
        System.out.println(ip.isPalindrome(s));
        s = null;
        System.out.println(ip.isPalindrome(s));
        s = "A";
        System.out.println(ip.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        return isPalindrome(s, 0, s.length() - 1);
    }

    public boolean isPalindrome(String s, int left, int right) {
        // base case: the string' length is 1, then it must be palindrome
        if (left >= right) {
            return true;
        }

        // break: move the left pointer one step forward and right pointer one step backward
        // solve the complex problem: combine the results
        return s.charAt(left) == s.charAt(right) && isPalindrome(s, left + 1, right - 1);
    }
}
