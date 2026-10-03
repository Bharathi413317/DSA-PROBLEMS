class Pair{
    char ch;
    int indx;
    public Pair(char ch,int indx){
        this.ch=ch;
        this.indx=indx;
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Pair>st=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push(new Pair(c,i));
            }
            else{
                if(!st.isEmpty() && st.peek().ch=='('){
                    st.pop();
                }else{
                    st.push(new Pair(c,i));
                }
            }
        }int beforind=s.length();
        if(st.isEmpty()) return s.length();
        while(!st.isEmpty()){
            int k=st.peek().indx;
            
            ans=Math.max(ans,(beforind-k-1));
            beforind=k;
            st.pop();

        }
        if (beforind>0){
            return Math.max(ans,beforind);
        }
        
        return ans;

    }
}