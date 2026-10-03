class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        generate("",0,0,n,ans);
        return ans;
    }
    public void generate(String s,int ob,int cb,int n,List<String>ans){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        if(ob<n){
            generate(s+"(",ob+1,cb,n,ans);
        }if(cb<ob){
            generate(s+")",ob,cb+1,n,ans);
        }
    }
}