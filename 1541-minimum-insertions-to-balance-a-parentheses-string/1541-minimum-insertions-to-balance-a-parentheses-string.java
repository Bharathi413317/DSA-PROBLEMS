

class Solution {
    public int minInsertions(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else {
                if (i + 1 < sb.length() && sb.charAt(i + 1) == ')') {
                    if (!st.isEmpty()) {
                        st.pop();
                    } else {
                        count += 1;
                    }
                    i++;
                } else {
                    if (!st.isEmpty()) {
                        st.pop();
                        count += 1;
                    } else {
                        count += 2;
                    }
                }
            }
        }

        return count + 2 * st.size();
    }
}
