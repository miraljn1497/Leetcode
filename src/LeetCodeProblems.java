import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LeetCodeProblems {

    //
    public static List<int[]> findIndices(int[] nums, int target) {
        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] == target)
                        .mapToObj(j -> new int[]{i, j}))
                .toList(); // Or .collect(Collectors.toList()); in older Java versions
    }

    // Remove Duplicate from Sorted Array 2

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 0; // Index for the modified array (elements to keep)

        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i]; // Add the current element and increment k
            }
        }
        return k; // k is the number of unique elements (modified array size)
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0 || nums.length == 0) {
            return; // No rotation needed
        }
        k = k % n; // Handle k > n

        // Method 2: In-place reversal (More efficient)
        reverse(nums, 0, n - k - 1); // Reverse the first part
        reverse(nums, n - k, n - 1); // Reverse the second part
        reverse(nums, 0, n - 1);    // Reverse the entire array
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If the current day's price is higher than the previous day's price,
            // it means we can make a profit by buying on the previous day and selling on the current day.
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential overflow

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1;
    }

}



