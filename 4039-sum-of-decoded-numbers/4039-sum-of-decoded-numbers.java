class Solution {

    public long decode(long a) {

        long width = a % 10;
        long depth = a / 10;

        long x = 0;
        long y = 0;

        List<Long> lst = new ArrayList<>();

        while (depth > 0) {
            lst.add(depth % 10);
            depth = depth / 10;
        }

        int count = 0;

        for (int i = lst.size() - 1; i >= 0; i--) {

            if (count != width) {
                x = x * 10 + lst.get(i);
                count++;
            } 
            else {
                y = y * 10 + lst.get(i);
            }
        }

        long ans = 1;
        long mod = 1000000007;

        x = x % mod;

        while (y > 0) {

            if (y % 2 == 1) {
                ans = (ans * x) % mod;
            }

            x = (x * x) % mod;
            y = y / 2;
        }

        return ans;
    }

    public int sumDecoded(long[] nums) {

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = (sum + decode(nums[i])) % 1000000007;
        }

        return (int) sum;
    }
}