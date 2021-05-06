package array.easy;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers448 {
    public static void main(String[] args) {
        FindDisappearedNumbers448 findDisappearedNumbers448 = new FindDisappearedNumbers448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers448.findDisappearedNumbers(nums));
    }

    /*
    my way: take extra space
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearList = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                disappearList.add(i);
            }
        }

        return disappearList;
    }

    /*
    由于元素取值为[1,n], 因此可以将元素值作为索引，把该索引位置的元素乘以-1作为标记。
    这么一来，最后数组中大于0的元素对应的索引值即为消失的元素。
     */
    public List<Integer> findDisappearedNumbers_1(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);
            // 注意：不要重复标记
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
