// class Pair{
//     int first,second;
//     public Pair(int first,int second){
//         this.first=first;
//         this.second=second;
//     }
// }
// class Solution {
//     public void bfs(int r,int c,int [][]vis,char[][] grid){
//         vis[r][c]=1;
//         Queue<Pair>q=new LinkedList<Pair>();
//         q.add(new Pair(r,c));
//         int n=grid.length;
//         int m=grid[0].length;
//         int[] delRow = {-1, 0, 1, 0};
//         int[] delcol = {0, 1, 0, -1};
//         while(!q.isEmpty()){
//             int row=q.peek().first;
//             int col=q.peek().second;
//             q.remove();
//             for(int i=0;i<4;i++){
                
//                     int nrow=row+delRow[i];
//                     int ncol=col+delcol[i];
//                     if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
//                         vis[nrow][ncol]=1;
//                         q.add(new Pair(nrow,ncol));
//                     }
//                 }
            

//         }
//     }
//     public int numIslands(char[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         int [][]vis=new int[n][m];
//         int cnt=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(vis[i][j]==0 && grid[i][j]=='1'){
//                     cnt++;
//                     bfs(i,j,vis,grid);
//                 }

//             }
//         }
//         return cnt;

        
//     }
// }
class Solution {
    public void dfs(int r,int c,int [][]vis,char [][]grid){
        int n=grid.length;
        int m=grid[0].length;
        vis[r][c]=1;
        int []dr={-1,0,+1,0};
        int []dc={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=r+dr[i];
            int ncol=c+dc[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
            && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                dfs(nrow,ncol,vis,grid);
            }

        }
    }
  public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,vis,grid);
                }

            }
        }
        return cnt;

        
    }
}
