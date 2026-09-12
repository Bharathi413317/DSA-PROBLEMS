class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int half = n/2;

        char[] left = s.substring(0, half).toCharArray();
        Arrays.sort(left);
        String lefts = new String(left);

        String right = new StringBuilder(lefts).reverse().toString();

        String middle = (n%2 == 0) ? "" : String.valueOf(s.charAt(half));
        return lefts + middle + right;
    }
}
