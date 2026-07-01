class Solution {
    public String sortString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();

        while (ans.length() < s.length()) {

            // Smallest to Largest
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (map.containsKey(ch)) {
                    ans.append(ch);

                    map.put(ch, map.get(ch) - 1);

                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                }
            }

            // Largest to Smallest
            for (char ch = 'z'; ch >= 'a'; ch--) {
                if (map.containsKey(ch)) {
                    ans.append(ch);

                    map.put(ch, map.get(ch) - 1);

                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                }
            }
        }

        return ans.toString();
    }
}
