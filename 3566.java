import java.math.BigInteger;

class Solution {

    public boolean checkEqualPartitions(int[] nums, long target) {

        int n = nums.length;

        BigInteger total = BigInteger.ONE;

        for (int x : nums) {
            total = total.multiply(BigInteger.valueOf(x));
        }

        BigInteger t = BigInteger.valueOf(target);

        if (!total.equals(t.multiply(t))) {
            return false;
        }

        int totalMasks = 1 << n;

        for (int mask = 1; mask < totalMasks - 1; mask++) {

            long product = 1;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    if (product > target / nums[i]) {
                        valid = false;
                        break;
                    }

                    product *= nums[i];

                    if (product > target || target % product != 0) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid && product == target) {
                return true;
            }
        }

        return false;
    }
}
