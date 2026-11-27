
class Solution {
    public int maxProfit(int[] prices) {
         int []bestifselltoday=new int[prices.length];
         int []bestifselltodayorbefore=new int[prices.length];
         int minsf=prices[0];
         for(int i=1;i<prices.length;i++){
            if(prices[i]<minsf){
                minsf=prices[i];
            }
            bestifselltoday[i]=prices[i]-minsf;
            bestifselltodayorbefore[i]=Math.max(bestifselltoday[i],bestifselltodayorbefore[i-1]);
         }
         int []bestifbuytoday=new int[prices.length];
         int []bestifbuytodayorbefore=new int[prices.length];
         int maxsf=prices[prices.length-1];
         for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>maxsf){
                maxsf=prices[i];
            }
            bestifbuytoday[i]=maxsf-prices[i];
            bestifbuytodayorbefore[i]=Math.max( bestifbuytoday[i],bestifbuytodayorbefore[i+1]);
         }
         int ans=0;
         for(int i=0;i<prices.length;i++){
            ans=Math.max(ans,bestifselltodayorbefore[i]+bestifbuytodayorbefore[i]);
         }
         return ans;
    }
}

   