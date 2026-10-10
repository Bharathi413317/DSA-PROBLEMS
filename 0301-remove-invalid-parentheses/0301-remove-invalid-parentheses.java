class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();
        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(s);
        vis.add(s);

        boolean found = false;

        while (!q.isEmpty()) {

            String str = q.poll();

            if (isValid(str)) {
                ans.add(str);
                found = true;
            }

            
          
            if (found) {
                continue;
            }

            for (int i = 0; i < str.length(); i++) {

              
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }

                String next = str.substring(0, i) + str.substring(i + 1);

                if (!vis.contains(next)) {
                    vis.add(next);
                    q.offer(next);
                }
            }
        }

        return ans;
    }

    public boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}