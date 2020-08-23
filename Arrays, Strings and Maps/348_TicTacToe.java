/*The key observation is that in order to win Tic-Tac-Toe you must have the entire row or column. Thus, we don't need to keep track of an entire n^2 board.
We only need to keep a count for each row and column. If at any time a row or column matches the size of the board then that player has won.
To keep track of which player, add 1 for Player1 and -1 for Player2. There are two additional variables to keep track of the count of the diagonals.
Each time a player places a piece we just need to check the count of that row, column, diagonal and anti-diagonal.*/

/***********************************************
 Time Complexity : O(n)
 Space Complexity : O(1)
 https://leetcode.com/problems/design-tic-tac-toe/
 https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand
 ***********************************************/

class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        int size = rows.length;

        rows[row]+= toAdd;
        cols[col]+= toAdd;

        // Diagonal: top left to bottom right
        if (row == col) {
            diagonal += toAdd;
        }

        // AntiDiagonal: top right to bottom left
        if(row + col == size - 1) {
            antiDiagonal += toAdd;
        }

        if(Math.abs(rows[row]) == size
                || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size
                || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */