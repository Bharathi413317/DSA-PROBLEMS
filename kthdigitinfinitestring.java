class Solution {
    public int kthDigit(long k) {

        // 1 to 9
        if (k <= 9) {
            return (int) k;
        }

        k -= 9;

        int digits = 2;
        long blocks = 9;

        // Find which digit-length group contains k
        while (true) {

            long totalDigits = blocks * 10L * digits;

            if (k <= totalDigits) {
                break;
            }

            k -= totalDigits;
            digits++;
            blocks *= 10;
        }

        // Find which block inside this group
        long blockIndex = (k - 1) / (10L * digits);

        // Position inside that block
        long position = (k - 1) % (10L * digits);

        // First number of this block
        long start = (long) Math.pow(10, digits - 1)
                   + blockIndex * 10;

        // Which number inside the block
        long numberIndex = position / digits;

        // Which digit inside that number
        int digitIndex = (int) (position % digits);

        long number;

        // Actual block number
        long blockNumber = start / 10;

        if (blockNumber % 2 == 0) {
            // Even block → increasing
            number = start + numberIndex;
        } else {
            // Odd block → decreasing
            number = start + 9 - numberIndex;
        }

        String s = Long.toString(number);

        return s.charAt(digitIndex) - '0';
    }
}
