class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0) return 0;
        int result = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                if(j > 0 && board[i][j - 1] == 'X') continue;
                if(i > 0 && board[i-1][j] == 'X') continue;
                result++;
            }
        }
        return result;
    }
}
