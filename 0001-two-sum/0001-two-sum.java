class Solution {
    public int[] twoSum(int[] nums, int target) {
        int k = nums.length;
        int[] arr = new int[2];

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                int sum = nums[i] + nums[j];
               if (target == sum) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;  
                }
            }
        }
        return arr; 
    }
}
 