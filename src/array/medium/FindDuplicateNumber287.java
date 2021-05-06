package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * tags: #sort, #set, #TortoiseAndHare
 */
public class FindDuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        FindDuplicateNumber287 fdn = new FindDuplicateNumber287();
        System.out.println(fdn.findDuplicate_ExtraSpace(nums));
        System.out.println(fdn.findDuplicate_InPlace(nums));
        nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(fdn.findDuplicate_ExtraSpace(nums));
        System.out.println(fdn.findDuplicate_InPlace(nums));
    }

    public int findDuplicate_ExtraSpace(int[] nums) {
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (temp[num] == 1) {
                return num;
            }

            temp[num]++;
        }

        throw new IllegalArgumentException();
    }

    public int findDuplicate_InPlace(int[] nums) {
        int n = 0;
        int num = nums[0];
        while (n < nums.length) {
            int temp = nums[num];
            nums[num] = num;
            num = temp;
            n++;
        }

        return num;
    }

    public int findDuplicate_Sort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    public int findDuplicate_Set(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

    public int findDuplicate_TAH(int[] nums) {
        // Find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the "entrance" to the cycle.
        // if a cycle is found, initialize a slow pointer to head, let last pointer to be at is position
        // move both slow and fast pointers one node at a time
        // the point at which they meet is the start of the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public int findDuplicate_Flag(int[] nums) {
        for (int n : nums) {
            if (nums[Math.abs(n)] < 0) {
                return Math.abs(n);
            } else {
                // multiply -1 as a flag
                nums[Math.abs(n)] *= -1;
            }
        }
        return -1;
    }
}
