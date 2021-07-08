import java.util.Arrays;

/**
 * tags: #binary-search
 */
public class FindFirstNLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        FindFirstNLastPositionOfElementInSortedArray34 f = new FindFirstNLastPositionOfElementInSortedArray34();
        System.out.println(Arrays.toString(f.searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 8)));
    }

    /*
    该题数组存在重复元素，需要找出target的范围（对于[1,2,2,3]来说，2的范围是（1，2）
    由于需要找出range，因此我们可以使用两次bs，分别找出start和end
     */
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int start = -1, end = -1;
        // 找出最左边的target
        while (low <= high) {
            int mid = (low + high) >>> 1;
            // 由于需要找出最左边的，因此我们找到了target别不直接break
            // 而是向左继续搜索，直至low>high(此时可以确保全部搜索完毕）
            if (nums[mid] == target) {
                start = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // 找出最右边的target
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                low = mid + 1;
                end = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{start, end};
    }
}
