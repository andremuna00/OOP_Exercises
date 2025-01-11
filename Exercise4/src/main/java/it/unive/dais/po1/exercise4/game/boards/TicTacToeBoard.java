package it.unive.dais.po1.exercise4.game.boards;

import it.unive.dais.po1.exercise4.game.GameException;
import it.unive.dais.po1.exercise4.game.Mark;
import org.springframework.stereotype.Component;

@Component("TicTacToe Board")
public class TicTacToeBoard extends Board {
    /**
     * Contains the board of the current game
     */
    private Mark[][] board= new Mark[3][3];

    /**
     * Creates a square board
     */
    public TicTacToeBoard() {
        super(3);
    }

    @Override
    protected boolean isValidMove(Board previous, Mark m) throws GameException {
        boolean first = true;
        if (this.getDimension() != previous.getDimension())
            throw new GameException("Cannot compare two boards of different dimensions");
        for (int x = 0; x < this.getDimension(); x++)
            for (int y = 0; y < this.getDimension(); y++)
                if (this.getMark(x, y) != previous.getMark(x, y))
                    if (this.getMark(x, y) == m) {
                        if (first)
                            first = false;
                        else return false;
                    }
        return !first;
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    @Override
    public Mark winner() {
        for(int i=0;i<3;i++){
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

    @Override
    public Board clone() {
        TicTacToeBoard board = new TicTacToeBoard();
        for (int i = 0; i < this.getDimension(); i++)
            for (int j = 0; j < this.getDimension(); j++)
                try {
                    board.putMark(this.getMark(i, j), i, j);
                } catch (GameException e) {
                    throw new RuntimeException("Impossible to clone the board");
                }

        return board;
    }
}
