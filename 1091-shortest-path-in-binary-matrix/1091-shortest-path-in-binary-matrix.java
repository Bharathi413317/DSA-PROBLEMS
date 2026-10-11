class Pair{
    int row;
    int col;
    int wt;
    Pair(int row,int col,int wt){
        this.row=row;
        this.col=col;
        this.wt = wt;
    }
}
class Solution {
  
      public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
  int [][]dis=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                 dis[i][j]=Integer.MAX_VALUE;
            }        
            
        }
        dis[0][0]=1;
         if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        TreeSet<Pair> ts = new TreeSet<>((a, b) -> {
    if (a.wt != b.wt)
        return Integer.compare(a.wt, b.wt);
    if (a.row != b.row)
        return Integer.compare(a.row, b.row);
    return Integer.compare(a.col, b.col);
});
      
        
        ts.add(new Pair(0,0,1));
        int []drow={1,1,0,-1,-1,-1,0,1};
        int []dcol={0,1,1,1,0,-1,-1,-1};
        while(!ts.isEmpty()){
            Pair p=ts.pollFirst();
            int r=p.row;
            int c=p.col;
            int wt=dis[r][c];
        
            for(int i=0;i<8;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0){
                    if(wt+1<dis[nr][nc]){
                        if(dis[nr][nc] !=Integer.MAX_VALUE){
                            ts.remove(new Pair(nr,nc,dis[nr][nc]));
                        }
                     dis[nr][nc]=wt+1;
                    
                    ts.add(new Pair(nr,nc,dis[nr][nc]));
                    }

                }
                
            }

        }if(dis[n-1][n-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dis[n-1][n-1];
       
    }
}