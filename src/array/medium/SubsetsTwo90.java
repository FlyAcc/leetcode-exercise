package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 2, 2};
        SubsetsTwo90 st = new SubsetsTwo90();
        System.out.println(st.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
