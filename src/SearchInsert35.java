/**
 * tags: #binary-search
 */
public class SearchInsert35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        SearchInsert35 s = new SearchInsert35();
        System.out.println(s.searchInsert(nums, 7));
    }

    public int searchInsert_Simpler(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int hi = nums.length - 1;
        if (nums[low] > target) {
            return 0;
        }
        if (nums[hi] < target) {
            return hi + 1;
        }

        int mid = (low + hi) / 2;
        while (hi - low > 1) {
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                hi = mid;
            } else if (target > nums[mid]) {
                low = mid;
            }

            mid = (low + hi) / 2;
        }

        return nums[low] == target ? low : low + 1;
    }
}
