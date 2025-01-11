package it.unive.dais.po1.exercise3.m879607;

import it.unive.dais.po1.exercise3.*;
import it.unive.dais.po1.exercise3.Player;
import it.unive.dais.po1.exercise3.m879607.Standing;

import java.util.Collection;

public class Tournament extends it.unive.dais.po1.exercise3.Tournament {
    public static int drawPoints;
    public static int winPoints;
    /**
     * Build up a tournament
     *
     * @param players    the players involved in the tournament
     * @param board      the board to play the tournament
     * @param drawPoints number of points to be given to a player for a draw
     * @param winPoints  number of points to be given to a player for a win
     * @throws GameException
     */
    public Tournament(Collection<Player> players, Board board, int drawPoints, int winPoints) throws GameException {
        super(players, board, drawPoints, winPoints);
        if(drawPoints<0||winPoints<0)
            throw new GameException("negative points");
        this.drawPoints=drawPoints;
        this.winPoints=winPoints;
    }

    /**
     * Plays the tournament and returns the standing
     *
     * @return the standing of the tournament
     * @throws GameException if something goes wrong while playing the tournament
     */
    @Override
    public Standing play() throws GameException {
        Standing s = new Standing();
        for (Player p1:players) {
            for (Player p2:players) {
                if(!p1.equals(p2)) {
                    Board b = new GomokuBoard(16);
                    Game g = new Game(p1, p2, b);
                    Result r = g.play();
                    s.recordResult(p1, p2, r);
                }
            }

        }
        return s;
    }
}
