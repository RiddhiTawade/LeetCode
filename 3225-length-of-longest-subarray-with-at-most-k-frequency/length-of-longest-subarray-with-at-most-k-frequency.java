import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            int value = nums[right];

            // Increase frequency
            map.put(value, map.getOrDefault(value, 0) + 1);

            // If frequency becomes greater than k
            while (map.get(value) > k) {

                int leftValue = nums[left];

                map.put(leftValue, map.get(leftValue) - 1);

                left++;
            }

            // Calculate current window length
            int length = right - left + 1;

            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }
}