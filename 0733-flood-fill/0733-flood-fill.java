class Solution {
    public void dfs(int r,int c,int [][]ans,int[][] image,int newcolor,int []delrow,int []delcol,int inicolor){
        ans[r][c]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=newcolor){
                dfs(nrow,ncol,ans,image,newcolor,delrow,delcol,inicolor);
            }

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor=image[sr][sc];
        int [][]ans=new int [image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                ans[i][j]=image[i][j];
            }
        }
        int [] delrow={-1,0,1,0};
        int [] delcol={0,1,0,-1};
        dfs(sr,sc,ans,image,color,delrow,delcol,inicolor);
        return ans;
    }
}