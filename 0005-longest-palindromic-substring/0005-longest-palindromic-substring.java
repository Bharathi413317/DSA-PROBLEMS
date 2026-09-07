class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s; // If the string is null or has 1 character, it's already a palindrome.
        }
        
        String longest = "";
        
        // Function to expand around center
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (single character center)
            String oddPalindrome = expandAroundCenter(s, i, i);
            // Even length palindrome (two character center)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            
            // Update longest palindrome
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        
        return longest;
    }

    // Helper method to expand around a given center and return the longest palindrome
    public static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // Return the palindrome substring
    }
        
    }
