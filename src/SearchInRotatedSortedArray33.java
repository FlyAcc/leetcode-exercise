/**
 * tags: #binary-search
 */
public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        SearchInRotatedSortedArray33 s = new SearchInRotatedSortedArray33();
        System.out.println(s.search(new int[]{1}, 1));
    }

    /*
    旋转后的数组可分为两个部分，每个部分都是升序，由于不是完全的升序，因此我们无法直接使用二分查找。
    我们可以进行一点简单的处理：若target可能在右半部分，我们可以将左半部分设为-∞；若target在左半部分，那么将
    右半部分设为+∞，这么一来我们便可以使用二分查找。
    https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple
     */
    public int search_Inf(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            // 注意不能是mid = （low+high)/2
            int mid = (low + high) >>> 1;
            int midVal;
            // nums[mid]和target是否在同个部分
            if (nums[mid] < nums[0] == target < nums[0]) {
                midVal = nums[mid];
            } else {
                midVal = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /*
    旋转后的数组必有一半是升序的->(low,mid)或(mid,high)必有一部分升序
    https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14472/Java-AC-Solution-using-once-binary-search
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target)
                return mid;

            // 以下判断target在哪个部分
            // (low,mid)升序
            if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
