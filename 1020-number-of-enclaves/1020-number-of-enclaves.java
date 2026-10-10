class Node{
    int first;
    int second;
    public Node(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];
        int cnt=0;
        Queue<Node>q=new LinkedList<Node>();
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && vis[0][j]==0){
                q.add(new Node(0,j));
                vis[0][j]=1;
            }
            if(grid[n-1][j]==1 && vis[n-1][j]==0){
                q.add(new Node(n-1,j));
                vis[n-1][j]=1;
            }
        }for(int i=0;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                q.add(new Node(i,0));
                vis[i][0]=1;
            }if(grid[i][m-1]==1 && vis[i][m-1]==0){
                q.add(new Node(i,m-1));
                vis[i][m-1]=1;
            }
        }while (!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            int []delrow={-1,0,+1,0};
            int []delcol={0,+1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Node(nrow,ncol));
                    vis[nrow][ncol]=1;
                }

            }
        }for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }return cnt;

    }
}