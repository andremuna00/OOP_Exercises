package it.unive.dais.po1.exercise1;

/**
 * This class represents a player of the game
 *
 * @since 1.0
 */
public class Player {

    /**
     * It represents hte mark of the player
     */
    private Mark mark;

    /**
     * Intializes a player using the given Mark
     *
     * @param mark the mark of the player
     */
    public Player(Mark mark) {
        this.mark = mark;
    }

    /**
     * Plays a round of the game.
     *
     * @param board
     * @return true if the player was able to
     */
    public boolean play(TicTacToeBoard board) {

        boolean CorrectInsert = false;

        while (!board.isFull() && !CorrectInsert) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (board.put(mark, x, y))
                CorrectInsert = true;
        }

        return CorrectInsert;
    }
}
