class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1,k,n,0,new ArrayList<>());
        return ans;
        
    }public void backtrack(int start,int k,int n,int sum,List<Integer>path){
        if(path.size()==k){
            if(sum==n){
                ans.add(new ArrayList<>(path));
            }return;
        }if(sum>n){
            return;
        }for(int i=start;i<=9;i++){
            path.add(i);
            backtrack(i+1,k,n,sum+i,path);
            path.remove(path.size()-1);

        }
    }
}
