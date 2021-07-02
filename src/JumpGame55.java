/**
 * tags: #DP
 */
public class JumpGame55 {
    public static void main(String[] args) {
        JumpGame55 j = new JumpGame55();
        System.out.println(j.canJump(new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}));
        System.out.println(j.canJump_BottomUp(new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1,
                2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}));
        System.out.println(j.canJump_BottomUp(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump_BottomUp(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }

        boolean[] arr = new boolean[n];
        arr[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] && nums[i] >= j - i) {
                    arr[i] = true;
                    break;
                }
            }
        }

        return arr[0];
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        boolean[] arr = new boolean[nums.length - 1];
        canJump(nums, nums.length - 1, arr);
        return arr[0];
    }

    private void canJump(int[] nums, int destination, boolean[] arr) {
        for (int i = destination - 1; i >= 0; i--) {
            if (arr[i]) {
                return;
            }

            if (nums[i] >= destination - i) {
                arr[i] = true;
                canJump(nums, i, arr);
            }
        }
    }
}
