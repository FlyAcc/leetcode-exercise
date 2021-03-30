package algorithm;

import java.util.Arrays;

/**
 * naive pattern search algorithm的缺点是每次搜索都需要从头开始（i开始，然后到j匹配/不匹配；新一轮搜索又从
 * i+1开始），而之所以这么做的原因遍历过的部分可能仍存在部分匹配的可能（考虑这种情况：给定字符串AAAA，pattern：AAA。
 * 匹配结果应该有两个，分别是0和1（起始index），其中1-2是我们遍历过的部分）。
 * 这种做法无疑是耗时且没必要的。遍历过的部分可能存在部分匹配的情况是pattern存在相同的prefix和suffix，上一个匹配
 * 过的部分的suffix可以作为下一个匹配的prefix。因此kmp通过预处理pattern，找出这样的prefix（proper prefix），并使用一个
 * 辅助数组（lps：longest proper prefix which is also suffix）记录pattern每个元素对应的最长prefix长度。
 * 使用kmp进行pattern search时，我们不再重新遍历已经遍历过的部分，而是通过lps数组判断之前遍历过的部分是否仍存在部分匹配的情况。
 */
public class KMP_Pattern_Search {
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        System.out.println(Arrays.toString(new KMP_Pattern_Search().calculateLps(pat)));
        System.out.println(Arrays.toString(new KMP_Pattern_Search().kmp(txt, pat)));
    }

    private int[] kmp(String text, String pattern) {
        int i = 0, j = 0, k = 0;
        int[] lps = calculateLps(pattern);
        int[] result = new int[text.length() - pattern.length()];
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    result[k++] = i - j;
                    // 上一个数对应的lps，若为0即该后缀无对应前缀
                    j = lps[j - 1];
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return result;
    }

    private int[] calculateLps(String pattern) {
        int[] lps = new int[pattern.length()];
        int longest = 0;
        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(longest)) {
                lps[i++] = ++longest;
            } else {
                if (longest == 0) {
                    lps[i++] = 0;
                } else {
                    longest = lps[longest - 1];
                }
            }
        }

        return lps;
    }

    void kmpSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int[] lps = new int[m];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, m, lps);

        int i = 0; // index for txt[]
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("Found a pattern at index " + (i - j));
                j = lps[j - 1];
            }
            // mismatch after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    void computeLPSArray(String pat, int M, int[] lps) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
                    // Also, note that we do not increment i here
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
