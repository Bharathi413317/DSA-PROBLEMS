class Solution {
    public String removeOuterParentheses(String s) {
       Stack<Character>st=new Stack<>();
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(ch=='('){
               if(st.isEmpty()){
                st.push(ch);
               }else{
                st.push(ch);
                sb.append(ch);
               }
        }else{
            st.pop();
            if(!st.isEmpty()){
                sb.append(ch);
            }
        }
       }return sb.toString();
    }
}