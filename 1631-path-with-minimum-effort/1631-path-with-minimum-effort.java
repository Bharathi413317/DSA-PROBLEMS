class Pair{
    int row;
    int col;
    int diff;
    Pair(int row,int col,int diff){
        this.row=row;
        this.col=col;
        this.diff=diff;
    }
}
class Solution {
    int max=Integer.MIN_VALUE;
    int ans=Integer.MAX_VALUE;
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
          TreeSet<Pair> ts = new TreeSet<>((a, b) -> {
    if (a.diff != b.diff)
        return Integer.compare(a.diff, b.diff);
    if (a.row != b.row)
        return Integer.compare(a.row, b.row);
    return Integer.compare(a.col, b.col);
});
        int [][]dis=new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 dis[i][j]=Integer.MAX_VALUE;
            }        
            
        }dis[0][0]=0;
        ts.add(new Pair(0,0,0));
        int []drow={1,0,-1,0};
        int []dcol={0,+1,0,-1};
        while(!ts.isEmpty()){
            Pair p=ts.pollFirst();
            int r=p.row;
            int c=p.col;
            int wt=p.diff;
            if(wt > dis[r][c]) continue;
             if(r==m-1 && c==n-1){
                ans=Math.min(ans,wt);
            }
            for(int i=0;i<4;i++){
                   int nr=r+drow[i];
                   int nc=c+dcol[i];
                    if(nr>=0 && nc>=0 && nr<m && nc<n ){
                        int newDiff = Math.max(p.diff,
                         Math.abs(heights[r][c] - heights[nr][nc]));
                         if(newDiff<dis[nr][nc]){
                            if(dis[nr][nc] !=Integer.MAX_VALUE){
                            ts.remove(new Pair(nr,nc,dis[nr][nc]));
                        }
                        dis[nr][nc]=newDiff;
                         ts.add(new Pair(nr,nc,dis[nr][nc]));
                         }
                    }
                  
            }

        }return ans;
        
    }
}