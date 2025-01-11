package it.unive.dais.po1.exercise2.m879607;

import it.unive.dais.po1.exercise1.Mark;
import it.unive.dais.po1.exercise2.Board;

public class TicTacToeBoard extends Board {
    /**
     * Contains the board of the current game
     */
    private Mark[][] board = new Mark[3][3];

    /**
     * Creates a square board
     */
    public TicTacToeBoard() {
        super(3);
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    @Override
    public it.unive.dais.po1.exercise2.Mark winner() {
        for (int i = 0; i < 3; i++) {
            //cols
            if ((getMark(i, 0)) == (getMark(i, 1)) && (getMark(i, 1)) == (getMark(i, 2)) && (getMark(i, 0)) != null)
                return getMark(i, 0);
            //rows
            if ((getMark(0, i)) == (getMark(1, i)) && (getMark(1, i)) == (getMark(2, i)) && (getMark(0, i)) != null)
                return getMark(0, i);
        }
        //diag
        if ((getMark(1, 1)) == (getMark(0, 0)) && (getMark(0, 0)) == (getMark(2, 2)) || (getMark(2, 0)) == (getMark(1, 1)) && (getMark(1, 1)) == (getMark(0, 2)))
            if (getMark(1, 1) != null)
                return getMark(1, 1);
            else
                return null;
        else
            return null;
    }
}
