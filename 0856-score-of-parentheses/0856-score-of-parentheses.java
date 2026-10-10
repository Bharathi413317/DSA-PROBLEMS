class Solution {
    public int scoreOfParentheses(String s) {
       int ans=0;
       Stack<Integer>st=new Stack<>();
       for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch=='('){
                    st.push(i);
                }else{
                    int open=st.pop();
                    if(open+1==i){
                        ans+=(int)Math.pow(2,st.size());
                    }
                }
       }return ans;

    }
}