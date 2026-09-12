class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       int []rc=new int[k];
       rc[0]=1;
       int ps=0;
       int c=0;
       for(int num:nums){
        ps+=num;
        int rmr=(ps%k+k)%k;
        c+=rc[rmr];
        rc[rmr]++;
     }return c;
    }
    
}