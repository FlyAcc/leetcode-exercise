package medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
        String s = "eaaaabaaec";
        PartitionLabels763 pl = new PartitionLabels763();
        System.out.println(pl.partitionLabels(s));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(1);
            return result;
        }

        int n = s.length();
        int first = 0;
        int second = 1;
        StringBuilder temp = new StringBuilder(s.substring(0, 1));
        while (first + temp.length() < n) {
            if (second == n) {
                result.add(temp.length());
                first += temp.length();
                second = first + 1;
                temp = new StringBuilder(Character.toString(s.charAt(first)));
            } else if (temp.toString().contains(Character.toString(s.charAt(second++)))) {
                temp.append(s, first + temp.length(), second);
            }
        }
        result.add(temp.length());

        return result;
    }

    public List<Integer> partitionLabels_Greedy(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
