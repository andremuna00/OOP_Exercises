package it.unive.dais.po1.exercise1;

/**
 * This class represents a tic tac toe board
 *
 * @since 1.0
 */
public class TicTacToeBoard {

    /**
     * Contains the board of the current game
     */
    private Mark[][] board= new Mark[3][3];

    /**
     * Puts a mark in a given cell
     *
     * @param c the mark to put in the board
     * @param x the x coordinate of the cell to be filled
     * @param y the y coordinate of the cell to be filled
     * @return true if the cell was empty, the game was not ended (e.g., no winner yet) and
     * it filled it, false otherwise
     */
    public boolean put(Mark c, int x, int y) {

        boolean correctPut = false;

        if(getMark(x,y)==null&&this.winner()==null) {
            board[x][y]=c;
            correctPut=true;
        }
        else
            correctPut=false;

        return correctPut;
    }

    /**
     * Returns the mark of a cell, null if empty
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @return the mark in the given cell, null if the cell is empty
     */
    public Mark getMark(int x, int y) {
            return board[x][y];
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    public Mark winner() {
        for(int i=0;i<3;i++) {
            //cols
            if ((getMark(i,0)) == (getMark(i,1)) && (getMark(i,1)) == (getMark(i,2)) && (getMark(i,0))!=null)
                return getMark(i,0);
            //rows
            if ((getMark(0,i)) == (getMark(1,i)) && (getMark(1,i)) == (getMark(2,i)) && (getMark(0,i))!=null)
                return getMark(0,i);
        }
        //diag
        if ((getMark(1,1)) == (getMark(0,0)) && (getMark(0,0)) == (getMark(2,2))||(getMark(2,0)) == (getMark(1,1)) && (getMark(1,1)) == (getMark(0,2)))
            if(getMark(1,1)!=null)
                return getMark(1,1);
            else
                return null;
        else
            return null;
    }

    /**
     * Returns true if the board is full
     *
     * @return true iff the board is full
     */
    public boolean isFull() {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                if(getMark(i,j)==null)
                    return false;
            }
        return true;
    }

}
