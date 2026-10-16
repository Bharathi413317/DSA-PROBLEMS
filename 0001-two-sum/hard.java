class Solution {
    public int sumCounts(int[] nums) {
        int mod = 1000000007;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int j = i; j < nums.length; j++) {
                hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);

                long distinct = hm.size();
                count = (count + distinct * distinct) % mod;
            }
        }

        return (int) count;
    }
}
