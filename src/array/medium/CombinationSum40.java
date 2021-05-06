package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * tags: #backtracking
 */
public class CombinationSum40 {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        CombinationSum40 cs40 = new CombinationSum40();
        System.out.println(cs40.combinationSum2(nums, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }

    private void backtracking(int[] candidates, List<List<Integer>> result,
                              List<Integer> temp, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else if (remain > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue; // skip duplicates
                temp.add(candidates[i]);
                backtracking(candidates, result, temp, remain - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
