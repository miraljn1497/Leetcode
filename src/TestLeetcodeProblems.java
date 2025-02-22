
import java.util.Arrays;
import java.util.List;

    public class TestLeetcodeProblems {

        public static void main(String[] args) {

            // findIndices
            testFindIndices(new int[]{2, 7, 11, 15}, 9); // Basic case
            testFindIndices(new int[]{3, 2, 4}, 6);       // Another basic case
            testFindIndices(new int[]{3, 3}, 6);           // Duplicate numbers
            testFindIndices(new int[]{}, 9);                // Empty array
            testFindIndices(new int[]{1, 2, 3, 4, 5}, 10); // No match
            testFindIndices(new int[]{-1, -2, -3, -4, -5}, -6); // Negative numbers
            testFindIndices(new int[]{1,2,1,2}, 3); // Multiple matches

            // removeDuplicates
            testRemoveDuplicates(new int[]{1, 1, 1, 2, 2, 3}); // Basic case
            testRemoveDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}); // More duplicates
            testRemoveDuplicates(new int[]{1, 2, 3, 4, 5}); // No duplicates
            testRemoveDuplicates(new int[]{}); // Empty array
            testRemoveDuplicates(new int[]{1,1,1}); // All duplicates

            // rotate
            testRotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3); // Basic case
            testRotate(new int[]{-1, -100, 3, 99}, 2); // Negative numbers
            testRotate(new int[]{1, 2, 3}, 4); // k > n
            testRotate(new int[]{1, 2, 3}, 0); // k = 0
            testRotate(new int[]{}, 2); // Empty array

            // maxProfit
            testMaxProfit(new int[]{7, 1, 5, 3, 6, 4}); // Basic case
            testMaxProfit(new int[]{1, 2, 3, 4, 5}); // Increasing prices
            testMaxProfit(new int[]{5, 4, 3, 2, 1}); // Decreasing prices
            testMaxProfit(new int[]{}); // Empty array
            testMaxProfit(new int[]{1,2,1,2,1,2}); // Zig-zag prices

            // binarySearchIterative
            testBinarySearchIterative(new int[]{2, 5, 7, 8, 11, 12}, 13); // Target not found
            testBinarySearchIterative(new int[]{2, 5, 7, 8, 11, 12}, 12); // Target found at the end
            testBinarySearchIterative(new int[]{2, 5, 7, 8, 11, 12}, 2); // Target found at the beginning
            testBinarySearchIterative(new int[]{2, 5, 7, 8, 11, 12}, 8); // Target found in the middle
            testBinarySearchIterative(new int[]{}, 5); // Empty array
            testBinarySearchIterative(new int[]{1}, 1); // Single element array

        }


        private static void testFindIndices(int[] nums, int target) {
            System.out.println("findIndices(" + Arrays.toString(nums) + ", " + target + "):");
            List<int[]> result = LeetCodeProblems.findIndices(nums, target);
            for (int[] pair : result) {
                System.out.print(Arrays.toString(pair) + " ");
            }
            System.out.println();
        }

        private static void testRemoveDuplicates(int[] nums) {
            System.out.println("removeDuplicates(" + Arrays.toString(nums) + "):");
            int k = LeetCodeProblems.removeDuplicates(nums);
            System.out.print(k + ", Modified Array: ");
            for (int i = 0; i < k; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }

        private static void testRotate(int[] nums, int k) {
            int[] original = Arrays.copyOf(nums, nums.length); // Keep a copy for printing
            System.out.println("rotate(" + Arrays.toString(original) + ", " + k + "):");
            LeetCodeProblems.rotate(nums, k);
            System.out.println(Arrays.toString(nums));
        }

        private static void testMaxProfit(int[] prices) {
            System.out.println("maxProfit(" + Arrays.toString(prices) + "):");
            int profit = LeetCodeProblems.maxProfit(prices);
            System.out.println(profit);
        }

        private static void testBinarySearchIterative(int[] arr, int target) {
            System.out.println("binarySearchIterative(" + Arrays.toString(arr) + ", " + target + "):");
            int index = LeetCodeProblems.binarySearchIterative(arr, target);
            System.out.println(index);
        }
    }

