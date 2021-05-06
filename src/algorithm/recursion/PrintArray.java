package algorithm.recursion;

public class PrintArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        PrintArray pa = new PrintArray();
        pa.printArray(nums);
    }

    public void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        printArray(arr, 0, arr.length);
    }

    private void printArray(int[] arr, int start, int end) {
        // base case: the array has only one element
        // we simply return and print the element
        if (start == end) {
            return;
        }

        // break the problem one step simpler: move the start pointer one step forward and print the array
        printArray(arr, start + 1, end);
        System.out.println(arr[start]);
    }
}
