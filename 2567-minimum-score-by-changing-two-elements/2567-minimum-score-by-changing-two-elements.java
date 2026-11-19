
class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        min = Math.min(min, nums[n-3] - nums[0]);
        min = Math.min(min, nums[n-2] - nums[1]);
        min = Math.min(min, nums[n-1] - nums[2]);

        return min;
    }
}
