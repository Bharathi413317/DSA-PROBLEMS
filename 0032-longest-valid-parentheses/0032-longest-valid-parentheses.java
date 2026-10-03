class Pair{
    char ch;
    int ind;
    Pair(char ch,int ind){
        this.ch=ch;
        this.ind=ind;
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Pair>st=new Stack<>();
         int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(new Pair(ch,i));
            }else{
                if(!st.isEmpty() && st.peek().ch=='('){
                    st.pop();
                }else{
                    st.push(new Pair(ch,i));
                }
            }
        }
       

        int bi=s.length();
        if(st.isEmpty()) return s.length();
        while(!st.isEmpty()){
            int k=st.peek().ind;
            ans=Math.max(ans,bi-k-1);
            bi=k;
            st.pop();
              
        }
        if(bi>0){
            return Math.max(ans,bi);
        }return ans;
      
    }
}