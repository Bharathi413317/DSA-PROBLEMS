import java.util.*;
class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> freqCount = new HashMap<>();

            int minFreq = Integer.MAX_VALUE;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int x = nums[j];

                int oldFreq = freq.getOrDefault(x, 0);

                if (oldFreq > 0) {
                    freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);

                    if (freqCount.get(oldFreq) == 0) {
                        freqCount.remove(oldFreq);
                    }
                }

                int newFreq = oldFreq + 1;
                freq.put(x, newFreq);

                freqCount.put(
                    newFreq,
                    freqCount.getOrDefault(newFreq, 0) + 1
                );

                maxFreq = Math.max(maxFreq, newFreq);

                minFreq = Math.min(minFreq, newFreq);

                while (minFreq <= maxFreq &&
                       !freqCount.containsKey(minFreq)) {
                    minFreq++;
                }

                if (freq.size() == 1) {
                    ans = Math.max(ans, j - i + 1);
                } 
                else if (freqCount.size() == 2 &&
                         maxFreq == 2 * minFreq) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}