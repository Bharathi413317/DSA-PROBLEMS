

class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        if (n > m) return false;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            prefix[i] = j;
            if (j < m) j++;
        }

       
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && s.charAt(i) != t.charAt(j)) {
                j--;
            }
            suffix[i] = j;
            if (j >= 0) j--;
        }

       
        for (int i = 0; i < n; i++) {
            int left = (i == 0) ? -1 : prefix[i - 1];
            int right = (i == n - 1) ? m : suffix[i + 1];

            if (left + 1 < right) {
                return true;
            }
        }

        return false;
    }
}
