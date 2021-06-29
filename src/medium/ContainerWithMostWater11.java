package medium;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater11 cwmw = new ContainerWithMostWater11();
        System.out.println(cwmw.maxArea(height));
        height = new int[]{4, 3, 2, 1, 4};
        System.out.println(cwmw.maxArea(height));
        height = new int[]{1, 1};
        System.out.println(cwmw.maxArea(height));
    }

    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
