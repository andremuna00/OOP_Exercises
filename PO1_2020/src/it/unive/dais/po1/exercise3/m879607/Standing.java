package it.unive.dais.po1.exercise3.m879607;

import it.unive.dais.po1.exercise3.GameException;
import it.unive.dais.po1.exercise3.Player;
import it.unive.dais.po1.exercise3.Result;

import java.util.Collection;

public class Standing extends it.unive.dais.po1.exercise3.Standing {

    private Collection<String> res;
    private Collection<Player> players;

    /**
     * Return the players in the order of the standing (e.g., at index 0 there is the player
     * that is first in the ranking)
     *
     * @return the players ordered by their ranking
     */
    @Override
    public Player[] getStanding() {
        Player[] stand = new Player[players.size()];
        int[] points = new int[players.size()];
        int i = 0;

        for (Player p : players) {
            points[i] = getPointsOfPlayer(p);
            stand[i] = p;
            i++;
        }

        for (int j = 2; j < points.length; j++) {
            int key = points[j];
            Player ps = stand[i];
            i = j - 1;
            while (i > 0 && points[i] > key) {
                points[i + 1] = points[i];
                stand[i + 1] = stand[i];
                i = i - 1;
            }
            points[i + 1] = key;
            stand[i + 1] = ps;
        }
        return stand;
    }

    /**
     * Returns the point of a given player
     *
     * @param p a player
     * @return the points obtained by the given player
     */
    @Override
    public int getPointsOfPlayer(Player p) {

        if (!players.contains(p))
            return 0;
        int sum = 0;
        for (String s : res) {
            if (s.contains(p.getIdentifier())) {
                sum += Integer.getInteger(s.substring(p.getIdentifier().length() + 1));
            }

        }
        return sum;
    }

    /**
     * Records the result of a played game
     *
     * @param player1 the first player of the game
     * @param player2 the second player of the game
     * @param result  the result of the game
     * @throws GameException if the game was not possible (e.g., the two players are indeed the same)
     */
    @Override
    public void recordResult(Player player1, Player player2, Result result) throws GameException {
        if (player1.equals(player2))
            throw new GameException("players equals");

        if (!players.contains(player1))
            players.add(player1);
        if (!players.contains(player2))
            players.add(player2);

        if (result.draw != null) {
            res.add(player1.getIdentifier() + " " + Tournament.drawPoints);
            res.add(player2.getIdentifier() + " " + Tournament.drawPoints);
        }
        if (result.player1 != null) {
            res.add(player1.getIdentifier() + " " + Tournament.winPoints);
        }
        if (result.player2 != null) {
            res.add(player2.getIdentifier() + " " + Tournament.winPoints);
        }

    }
}
