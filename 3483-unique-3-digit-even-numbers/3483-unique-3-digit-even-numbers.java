class Solution {
    public int totalNumbers(int[] digits) {
        int []arr=new int[10];
        for(int d:digits){
            arr[d]++;
        }HashSet<Integer>hs=new HashSet<>();
        for(int i=100;i<=999;i+=2){
              int a= i/100;
              int b= (i/10)%10;
              int c= i%10;
              int []temp=arr.clone();
              if(temp[a]>0) temp[a]--;
              else continue;

               if(temp[b]>0) temp[b]--;
              else continue;

               if(temp[c]>0) temp[c]--;
              else continue;

              hs.add(i);
        }return hs.size();
    }
}