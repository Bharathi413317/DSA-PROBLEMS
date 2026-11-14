class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int n = nums.size();

        for (int len = l; len <= r; len++) {
            int left = 0;
            int sum = 0;

            for (int right = 0; right < n; right++) {
                sum += nums.get(right);

                if (right - left + 1 == len) {
                    if (sum > 0) {
                        ans = Math.min(ans, sum);
                    }

                    sum -= nums.get(left);
                    left++;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}