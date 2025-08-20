class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int left = 0, right = k - 1;
        for(int i = left; i <= right; i++) {
            sum += nums[i];
        }

        double maxSum = sum;
        while(right < nums.length - 1) {
            left++; right++;
            sum += nums[right] - nums[left - 1];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum / k;
    }
}