class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int j=0;
        int i=0;
        int maxdis=0;
        // for(int i=0;i<len1;i++){
                while(i<len1 && j<len2 ){
                    if(nums1[i]<=nums2[j] ){
                
                    maxdis=Math.max(maxdis,j-i);
                    j++;
                    }
                  else{
                    i++;
                  }
                    
                } return  maxdis;
                 
    }
}