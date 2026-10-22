class Solution {
    // Helper method to convert single roman symbol to integer
    private int romanSymbolToInteger(char ch) {
        if (ch == 'I') return 1;
        else if (ch == 'V') return 5;
        else if (ch == 'X') return 10;
        else if (ch == 'L') return 50;
        else if (ch == 'C') return 100;
        else if (ch == 'D') return 500;
        else if (ch == 'M') return 1000;
        else return 0; // default
    }

    public int romanToInt(String s) {
        int ans = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int val = romanSymbolToInteger(ch);

            if (val < prev) {
                ans -= val;
            } else {
                ans += val;
            }
            prev = val;
        }

        return ans;
    }
}
