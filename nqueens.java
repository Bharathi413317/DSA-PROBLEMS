class Solution {
      List<List<String>>ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
      
        char [][]board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill( board[i],'.');

        }helper(0,board,ans);
        return ans;

    }public void helper(int row,char [][]board,List<List<String>>ans){
            if(row==board.length){
                ans.add(construct(board));
                return;

            }for(int col=0;col<board.length;col++){
                 if(issafe(col,row,board)){
                    board[row][col]='Q';
                    helper(row+1,board,ans);
                    board[row][col]='.';
                 }
            }
    }public boolean issafe(int col,int row,char [][]board){
        for(int i=0;i<row;i++){
             if(board[i][col]=='Q') return false;
        }   for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }return true;
    }
    public List<String>construct(char [][]board){
        List<String>temp=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            temp.add(new String(board[i]));
        }return temp;
    }
}
