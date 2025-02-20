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

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle k > n

        if (k == 0) {
            return; // No rotation needed
        }


        // Method 2: In-place reversal (More efficient)
        reverse(nums, 0, n - k - 1); // Reverse the first part
        reverse(nums, n - k, n - 1); // Reverse the second part
        reverse(nums, 0, n - 1);     // Reverse the entire array
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int maxProfit(int[] prices) {
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


    public void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);

        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();


        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);

        System.out.print("Rotated array: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums3 = {1, 2};
        int k3 = 3;
        rotate(nums3, k3);
        System.out.print("Rotated array: ");

        int[] num4 = {1,1,1,2,2,3};
        int  unique = removeDuplicates(num4);
        System.out.print(unique);

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("Example 1 Profit: " + profit1);
    }
}
