class Pair{
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public boolean atlantic(int [][]heights,int r,int c,boolean [][]vis){
        vis[r][c]=true; 
        if(r==heights.length-1 || c==heights[0].length-1){
            return true;

        }
        int []drow={1,0,-1,0};
        int []dcol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+drow[i];
            int nc=c+dcol[i];
            if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !vis[nr][nc]){
                if(heights[nr][nc]<=heights[r][c]){
                if(atlantic(heights,nr,nc,vis)){
                    return true;
                }
                }
            }

        }return false;
    } public boolean pacific(int [][]heights,int r,int c,boolean [][]vis){
        vis[r][c]=true; 
        if(r==0 || c==0){
            return true;

        }
        int []drow={1,0,-1,0};
        int []dcol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+drow[i];
            int nc=c+dcol[i];
            if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !vis[nr][nc]){
                if(heights[nr][nc]<=heights[r][c]){
                if(pacific(heights,nr,nc,vis)){
                    return true;
                }
                }
            }

        }return false;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        
        
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean [][]vis1=new boolean[m][n];
                boolean [][]vis2=new boolean[m][n];
                 if(atlantic(heights,i,j,vis1) && pacific(heights,i,j,vis2)){
                    List<Integer>lst=new ArrayList<>();
                    lst.add(i);
                    lst.add(j);
                    res.add(lst);
                 }
            }
        }return res;
         
    }
}      