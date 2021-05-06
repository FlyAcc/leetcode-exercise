package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * tags: #backtracking
 */
public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations46 p = new Permutations46();
        System.out.println(p.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {
            if (temp.contains(num)) {
                continue;
            }

            temp.add(num);
            backtrack(nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
