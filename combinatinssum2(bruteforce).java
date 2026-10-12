class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>>ans=new HashSet<>();
        findcombinations(candidates,0,target,new ArrayList<>(),ans);
        return new ArrayList<>(ans);
    }public static void findcombinations(int[] arr,int idx,int target,List<Integer>curr,Set<List<Integer>>ans){
        if(target<0|| arr.length==idx){
           
          if(target==0){
            ans.add(new ArrayList<>(curr));
           

          }return;
          }
         
          if(arr[idx]<=target){
             curr.add(arr[idx]);
          findcombinations(arr,idx+1,target-arr[idx],curr,ans);
          curr.remove(curr.size()-1);
          }
          findcombinations(arr,idx+1,target,curr,ans);

    }
}
