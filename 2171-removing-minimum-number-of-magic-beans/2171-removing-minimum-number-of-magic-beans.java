class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long totalsum=0;
        for(int i: beans){
            totalsum+=i;
        }
        long max=0;
        for(int i=0;i<beans.length;i++){
            long curr=(long)beans[i]*(beans.length-i);
            max=Math.max(curr,max);
        }
        return totalsum-max;
    }
}