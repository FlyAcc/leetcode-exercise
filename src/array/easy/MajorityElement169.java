package array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * tags: #HashMap, #Boyer-Moore-Voting
 */
public class MajorityElement169 {
    public static void main(String[] args) {
        MajorityElement169 majorityElement = new MajorityElement169();
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement.majorityElement(nums));
        System.out.println(majorityElement.majorityElement_BmVoting1(nums));
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement.majorityElement(nums));
        System.out.println(majorityElement.majorityElement_BmVoting1(nums));
    }

    public int majorityElement_BmVoting1(int[] nums) {
        // first pass to find the candidate
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            count += candidate == nums[i] ? 1 : -1;
        }

        // second pass to check if the candidate is the majority element
        count = 0;
        for (int num : nums) {
            if (candidate == num) {
                count++;
                if (count > nums.length / 2) {
                    break;
                }
            }
        }

        if (count < nums.length / 2) {
            throw new IllegalArgumentException();
        }

        return candidate;
    }

    public int majorityElement_BmVoting(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException();
        }

        return candidate;
    }

    /*
    该题简单来说就是寻找出现次数超过n/2的数，因此我们可以用hashmap将每个元素记录下来，最后便可得知每个元素出现的次数
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numToTime = new HashMap<>();
        for (int num : nums) {
            int time = numToTime.get(num) == null ? 1 : numToTime.get(num) + 1;
            if (time > nums.length / 2) {
                return num;
            }
            numToTime.put(num, time);
        }

        throw new IllegalArgumentException();
    }
}
