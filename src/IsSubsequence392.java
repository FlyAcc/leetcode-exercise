import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * tags: #two-pointer, #binary-search
 */
public class IsSubsequence392 {
    public static void main(String[] args) {
        IsSubsequence392 i = new IsSubsequence392();
        System.out.println(i.isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                i--;
            }
            j--;
        }

        return i < 0;
    }

    public boolean isSubsequence_BinarySearch(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}
