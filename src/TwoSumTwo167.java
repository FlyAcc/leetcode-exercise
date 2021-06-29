import java.util.HashMap;
import java.util.Map;

/**
 * tags: #two-pointer, #HashMap
 */
public class TwoSumTwo167 {
    public int[] twoSum_HashMap(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i + 1, map.get(target - numbers[i])};
            }
        }

        throw new IllegalArgumentException();
    }

    public int[] twoSum_TwoPointer(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException();
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }
}
