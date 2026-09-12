class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        int a = nums.length - k + 1;

        for (int i = 0; i < a; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for (int n : set) {
                hm.put(n, hm.getOrDefault(n, 0) + 1);
            }
        }

        int val = Integer.MIN_VALUE;

        for (int n : hm.keySet()) {
            if (hm.get(n) == 1) {
                val = Math.max(val, n);
            }
        }

        return val == Integer.MIN_VALUE ? -1 : val;
    }
}