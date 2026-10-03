class Solution {
    public int maximumGap(String skill, String station) {

        int n = skill.length();

        int[] front = new int[n];
        int[] back = new int[n];

        // Left to Right
        int count = 0;

        for (int i = 0; i < n; i++) {

            char ch = skill.charAt(i);

            while (station.charAt(count) != ch) {
                count++;
            }

            front[i] = count;

            count++;
        }

        // Right to Left
        int cou = station.length() - 1;

        for (int i = n - 1; i >= 0; i--) {

            char ch = skill.charAt(i);

            while (station.charAt(cou) != ch) {
                cou--;
            }

            back[i] = cou;

            cou--;
        }

        // Find maximum gap
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {

            int gap = back[i + 1] - front[i];

            if (gap > ans) {
                ans = gap;
            }
        }

        return ans;
    }
}