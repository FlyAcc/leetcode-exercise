package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 该题和{@link Permutations46}相比，区别在于存在重复的元素。因此有几点要注意：
 * 1. 每次选择元素时，不能把已选元素添加进去
 * 2. 对于{1，1，2}这种含重复元素的数组，添加了1[index=0]->1->2, 1[index=0]->2->1, 不要
 * 再重复添加1[index=1]->1->2
 * tags: #backtracking
 */
public class PermutationsTwo47 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        PermutationsTwo47 pt = new PermutationsTwo47();
        System.out.println(pt.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result,
                           List<Integer> temp, List<Integer> indices) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; ) {
            if (indices.contains(i)) {
                i++;
                continue;
            }

            temp.add(nums[i]);
            indices.add(i);
            backtrack(nums, result, temp, indices);
            temp.remove(temp.size() - 1);
            indices.remove(indices.size() - 1);

            int j = i;
            while (++i < nums.length && nums[i] == nums[j]) ;
        }
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 使用used数组避免重复选择已选元素，同时通过i > 0 && nums[i] == nums[i - 1] && !used[i - 1]减去重复的分支
                // 对于[1,1,2]来说，第一个元素选了首位1，就不需要再选择第二个1了，否则会出现重复的结果
                // 当为同一层时，used[i-1]为false；非同一层时为true
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
