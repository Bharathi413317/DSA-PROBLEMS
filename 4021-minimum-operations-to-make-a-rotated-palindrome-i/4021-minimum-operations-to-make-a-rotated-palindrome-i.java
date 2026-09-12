class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cost=i;
            for(int j=0;j<n/2;j++){
                int k=n-j-1;
                int indx1=(j+i)%n;
                int indx2=(k+i)%n;

                int a=s.charAt(indx1)-'a';
                int b=s.charAt(indx2)-'a';

                int diff1=(a-b+26)%26;
                int diff2=(b-a+26)%26;
                cost+=Math.min(diff1,diff2);
            }ans=Math.min(ans,cost);
        }return ans;
    }
}