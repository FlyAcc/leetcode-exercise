package array.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * tags: #backtracking
 */
public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets78 subsets = new Subsets78();
        System.out.println(subsets.subsets_Backtracking(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            ListIterator<List<Integer>> iterator = result.listIterator();
            while (iterator.hasNext()) {
                List<Integer> newSubset = new ArrayList<>(iterator.next());
                newSubset.add(num);
                iterator.add(newSubset);
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(num);
            result.add(temp);
        }
        result.add(new ArrayList<>());
        return result;
    }

    public List<List<Integer>> subsets_Backtracking(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    // a concise version
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        // options
        for (int i = start; i < nums.length; i++) {
            // pick one
            tempList.add(nums[i]);
            // keep track
            backtrack(list, tempList, nums, i + 1);
            // backtracking
            tempList.remove(tempList.size() - 1);
        }
    }

    // a version that accord with the backtracking pseudo code
    private void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int level) {
        // result should include empty list[]
        // since we need to backtrack(temp#remove()), so we should make a copy of temp
        // there is not any constraint, so we simply accept the sub-result
        result.add(new ArrayList<>(temp));

        // it is a leaf node
        if (level == nums.length) {
            // we don't need to check whether the leaf node is a good node
            return;
        }

        for (int i = level; i < nums.length; i++) {
            // make a choice
            temp.add(nums[i]);
            // solve it
            backtracking(result, temp, nums, i + 1);
            // backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
