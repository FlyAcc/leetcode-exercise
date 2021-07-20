/**
 * 该题将罗马数字转为普通整数，关键在于罗马数字中如果前面一个字母代表
 * 的数字大于后边的，那么是加法，如VI=5+1=6；反之，如果小于，那么是减法，
 * 如IV=-1+5=4
 * https://leetcode.com/problems/roman-to-integer
 */
public class RomanToInteger13 {
    public static void main(String[] args) {
        RomanToInteger13 r = new RomanToInteger13();
        System.out.println(r.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int result = getInt(s.charAt(s.length() - 1));
        if (s.length() == 1) {
            return result;
        }

        // 这里我使用了双指针，实际罗马数字不会出现IIV这种情况，
        // 也就是说最多两位，因此可以使用i，i+1
        int left = s.length() - 1;
        int right = left - 1;
        while (right >= 0) {
            int leftInt = getInt(s.charAt(left));
            int rightInt = getInt(s.charAt(right));
            if (rightInt < leftInt) {
                result -= rightInt;
            } else {
                left = right;
                result += rightInt;
            }
            right--;
        }

        return result;
    }

    private int getInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
