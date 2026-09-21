class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            int value = num % k;

            long[] newDp = new long[k];

            // Start a new subarray containing only num
            newDp[value]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                int newRemainder = (int) (((long) r * value) % k);

                newDp[newRemainder] += dp[r];
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}
