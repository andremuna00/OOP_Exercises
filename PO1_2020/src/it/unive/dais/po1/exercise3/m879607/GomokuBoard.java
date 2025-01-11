package it.unive.dais.po1.exercise3.m879607;

import it.unive.dais.po1.exercise3.Board;
import it.unive.dais.po1.exercise3.GameException;
import it.unive.dais.po1.exercise3.Mark;

public class GomokuBoard extends it.unive.dais.po1.exercise3.Board {
    /**
     * Creates a square board
     *
     * @param dimension the dimension of the square board
     */
    public GomokuBoard(int dimension) {
        super(dimension);
    }

    @Override
    public Board clone() {
        GomokuBoard g = new GomokuBoard(this.getDimension());

        for (int i = 0; i < getDimension(); i++) {
            for (int j = 0; j < getDimension(); j++) {
                try {
                    g.putMark(getMark(i, j), i, j);
                } catch (GameException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return g;
    }

    /**
     * Check if the last move (where the current instance represents the last status of the
     * board, and parameter previous represents the previous status of the board) was legal,
     * that is, a mark (of the given type) was added to one cell of the board that was
     * previously empty
     *
     * @param previous the status of the board before the last move
     * @param m        the mark that should have been added to the board
     * @return true if and only if the last move was valid
     * @throws GameException if the current and previous boards are not compatible
     */
    @Override
    protected boolean isValidMove(Board previous, Mark m) throws GameException {
        int count = 0;
        for (int i = 0; i < getDimension(); i++) {
            for (int j = 0; j < getDimension(); j++) {
                if (previous.getMark(i, j) != this.getMark(i, j)) {
                    if (previous.getMark(i, j) != null || this.getMark(i, j) != m) {
                        throw new GameException("Not valid move");
                    }
                    count++;
                }
            }
        }
        if (count != 1) {
            throw new GameException("Not valid move");
        } else
            return true;
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    @Override
    public Mark winner() {
        for (int i = 0; i < getDimension(); i++) {
            for (int j = 0; j < getDimension(); j++) {
                if (checkrow(i, j) != null)
                    return checkrow(i, j);
                if (checkcoloumn(i, j) != null)
                    return checkcoloumn(i, j);
                if (checkfirstdiagonal(i, j) != null)
                    return checkfirstdiagonal(i, j);
                if (checkseconddiagonal(i, j) != null)
                    return checkseconddiagonal(i, j);
            }
        }
        return null;
    }

    private Mark checkrow(int i, int j) {
        if (j + 4 > getDimension() - 1)
            return null;
        Mark aux = getMark(i, j);
        for (int c = 0; c < 5; c++)
            if (aux != getMark(i, j + c))
                return null;

        return aux;
    }

    private Mark checkcoloumn(int i, int j) {
        if (i + 4 > getDimension() - 1)
            return null;
        Mark aux = getMark(i, j);
        for (int c = 0; c < 5; c++)
            if (aux != getMark(i + c, j))
                return null;

        return aux;
    }

    private Mark checkfirstdiagonal(int i, int j) {
        if (j + 4 > getDimension() - 1 || i + 4 > getDimension() - 1)
            return null;
        Mark aux = getMark(i, j);
        for (int c = 0; c < 5; c++)
            if (aux != getMark(i + c, j + c))
                return null;

        return aux;
    }

    private Mark checkseconddiagonal(int i, int j) {
        if (j - 4 < 0 || i + 4 > getDimension() - 1)
            return null;
        Mark aux = getMark(i, j);
        for (int c = 0; c < 5; c++)
            if (aux != getMark(i + c, j - c))
                return null;

        return aux;
    }
}
