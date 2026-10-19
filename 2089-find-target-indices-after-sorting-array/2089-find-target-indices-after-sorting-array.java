class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
      List<Integer>lst=new ArrayList<>();
      Arrays.sort(arr);
      for(int i=0;i<arr.length;i++){
        if(arr[i]==target){
            lst.add(i);
        }
      }return lst;
    }
}
