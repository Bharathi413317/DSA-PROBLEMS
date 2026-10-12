class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min=Integer.MAX_VALUE;
        int k=-1;
        for(int i=0;i<drones.length;i++){
            int a=Math.abs(drones[i][0]-target[0]);
            int b=Math.abs(drones[i][1]-target[1]);
            if(a+b <= drones[i][2]){
                if(a+b<min){
                    min=a+b;
                    k=i;
                }
            }
        }return k;
    }
}