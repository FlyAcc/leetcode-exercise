package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * tags: #backtracking
 */
public class CombinationSum39 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        CombinationSum39 cs39 = new CombinationSum39();
        System.out.println(cs39.combinationSum(nums, 7));
        nums = new int[]{1, 2};
        System.out.println(cs39.combinationSum(nums, 4));
    }

    public List<List<Integer>> combinationSum_Backtracking(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        // it is a leaf node and a good leaf
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        /* not a leaf node, so keep tracking*/
        else if (remain > 0) {
            for (int i = start; i < nums.length; i++) {
                // take a choice
                tempList.add(nums[i]);
                // solve it
                // not i + 1 because we can reuse same elements
                // not 0 to avoid duplicate result, like 1,1,2 and 1,2,1
                backtrack(list, tempList, nums, remain - nums[i], i);
                // backtrack
                tempList.remove(tempList.size() - 1);
            }
        }

        // remain < 0
        // it is a leaf node and a bad node
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking_MyVersion(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtracking_MyVersion(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp,
                                        int level) {
        for (int i = level; i < candidates.length; i++) {
            temp.add(candidates[i]);
            int a = isTarget(temp, target);
            if (a == 0) {
                Collections.sort(temp);
                if (!result.contains(temp)) {
                    result.add(new ArrayList<>(temp));
                }
            } else if (a < 0) {
                backtracking_MyVersion(candidates, target, result, temp, level);
            }

            temp.remove((Object) candidates[i]);
        }
    }

    private int isTarget(List<Integer> nums, int target) {
        return nums.stream().reduce(0, Integer::sum) - target;
    }
}
