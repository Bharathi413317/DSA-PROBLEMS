class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
         List<List<Integer>>ans=new ArrayList<>();
         Set<Integer>hs=new HashSet<>();
         for(int num: nums){
            hs.add(num);
        }int l=lower;
        int r=upper;
        while(l<=r){
            while(l<=r && hs.contains(l)){
                l++;
            }int start=l;
            if(l>r) break;
            while(l<=r && !hs.contains(l)){
                l++;
            }int end=l-1;
            List<Integer>temp=new ArrayList<>();
            temp.add(start);
            temp.add(end);
            ans.add(temp);
        }return ans;
    }
}
