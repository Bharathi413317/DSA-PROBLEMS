class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
          int min=0;
          int max=lights[0];
          for(int i=1;i<lights.length;i++){
            if(lights[i]>max){
                max=lights[i];
            }
          }for(int i=0;i<arrivalTime.length;i++){
               int k=arrivalTime[i]%period;
               if(k>=max){
                min=Math.max(min,period-k);
               }
          }return min;
    }
}