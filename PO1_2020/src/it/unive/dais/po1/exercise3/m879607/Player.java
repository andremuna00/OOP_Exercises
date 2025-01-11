package it.unive.dais.po1.exercise3.m879607;

import it.unive.dais.po1.exercise3.Board;
import it.unive.dais.po1.exercise3.GameException;
import it.unive.dais.po1.exercise3.Mark;

public class Player extends it.unive.dais.po1.exercise3.Player {
    /**
     * Plays a round of the game.
     *
     * @param board
     * @param mark
     * @throws GameException if the player was not able to play (e.g., because the board was already full)
     */
    @Override
    public void play(Board board, Mark mark) throws GameException {
        /*Check if there is a winner or the board is full*/
        if (board.winner() != null || board.isFull())
            throw new GameException("CannotPlay");

        /*  set the local variables
            x_best = the x position of the cell where we can win
            y_best = the y position of the cell where we can win
            max_l = needs to determinate in which cell we are near to win
            best_dir = indicates the direction where we can win
            stay = useful to block the other player from winning
         */
        int x_best = board.getDimension() / 2;
        int y_best = board.getDimension() / 2;
        int max_l = -1;
        String best_dir = null;
        Boolean stay = true;

        /* We need to analyze every single cell of the board and decide where is the best spot*/
        for (int i = 0; i < board.getDimension() && stay; i++) {
            for (int j = 0; j < board.getDimension() && stay; j++) {

                /*Check if we need only one move to win*/
                String l_own = CheckCell(i, j, board, mark);
                if ((Integer.parseInt(l_own.substring(3)) == 4 && board.getDimension() > 3) || (Integer.parseInt(l_own.substring(3)) == 2 && board.getDimension() == 3)) {
                    max_l = Integer.parseInt(l_own.substring(3));
                    x_best = i;
                    y_best = j;
                    best_dir = l_own.substring(0, 3);
                    stay = false;
                } else {
                    /*Check if the opponent is near to the win*/
                    String l_opp = CheckCell(i, j, board, mark == Mark.getCircle() ? Mark.getCross() : Mark.getCircle());
                    if ((Integer.parseInt(l_opp.substring(3)) >= 3 && board.getDimension() > 3) || (Integer.parseInt(l_opp.substring(3)) >= 2 && board.getDimension() == 3)) {
                        max_l = Integer.parseInt(l_opp.substring(3));
                        x_best = i;
                        y_best = j;
                        best_dir = l_opp.substring(0, 3);
                        stay = false;
                    }
                    /*otherwise check if the cell is a good spot (using the length)*/
                    else {
                        l_own = CheckCell(i, j, board, mark);
                        if (Integer.parseInt(l_own.substring(3)) > max_l) {
                            max_l = Integer.parseInt(l_own.substring(3));
                            x_best = i;
                            y_best = j;
                            best_dir = l_own.substring(0, 3);
                        }
                    }
                }
            }
        }

        /*if there is no good spot we choose a cell randomly*/
        if (max_l == -1) {
            while (!board.putMark(mark, x_best, y_best)) {
                x_best = (int) (Math.random() * board.getDimension());
                y_best = (int) (Math.random() * board.getDimension());
            }
        }
        /*otherwise we analyze the direction and we put the mark in the best cell*/
        else {
            int s = 0;
            /*when we find the direction we put the mark in the first empty cell*/
            if (best_dir.contains("r__"))
                while (!board.putMark(mark, x_best, y_best + s))
                    s++;
            else if (best_dir.contains("d__"))
                while (!board.putMark(mark, x_best + s, y_best))
                    s++;
            else if (best_dir.contains("d1_"))
                while (!board.putMark(mark, x_best + s, y_best + s))
                    s++;
            else if (best_dir.contains("d2_"))
                while (!board.putMark(mark, x_best + s, y_best - s))
                    s++;
            else if (best_dir.contains("l__"))
                while (!board.putMark(mark, x_best, y_best - s))
                    s++;
            else if (best_dir.contains("u__"))
                while (!board.putMark(mark, x_best - s, y_best))
                    s++;
            else if (best_dir.contains("d1u"))
                while (!board.putMark(mark, x_best - s, y_best - s))
                    s++;
            else if (best_dir.contains("d2u"))
                while (!board.putMark(mark, x_best - s, y_best + s))
                    s++;
        }
    }

    /**
     * this function need to decide the best direction where we can put our mark
     *
     * @param i:     position x of the cell
     * @param j:     position y of the cell
     * @param board: the board of the game
     * @param m:     the mark we want to analyze
     * @return a string with the direction and the length in this format: "___[length]"
     */
    private String CheckCell(int i, int j, Board board, Mark m) {
        /*if the cell does not start with the interested mark return -1*/
        if (board.getMark(i, j) != m)
            return "___-1";

        /*checking all the direction and it return the length of the mark row*/
        int right = CheckCellDirection(i, j, board, m, 0, 1);
        int down = CheckCellDirection(i, j, board, m, 1, 0);
        int diag1 = CheckCellDirection(i, j, board, m, 1, 1);
        int diag2 = CheckCellDirection(i, j, board, m, 1, -1);
        int left = CheckCellDirection(i, j, board, m, 0, -1);
        int up = CheckCellDirection(i, j, board, m, -1, 0);
        int diag1up = CheckCellDirection(i, j, board, m, -1, -1);
        int diag2up = CheckCellDirection(i, j, board, m, -1, 1);

        /*setting the return value according to the max value*/
        if (right >= down && right >= diag1 && right >= diag2 && right >= left && right >= up && right >= diag1up && right >= diag2up) {
            return "r__" + right;
        } else if (down >= diag1 && down >= diag2 && down >= left && down >= up && down >= diag1up && down >= diag2up) {
            return "d__" + down;
        } else if (diag1 >= diag2 && diag1 >= left && diag1 >= up && diag1 >= diag1up && diag1 >= diag2up) {
            return "d1_" + diag1;
        } else if (diag2 >= left && diag2 >= up && diag2 >= diag1up && diag2 >= diag2up) {
            return "d2_" + diag2;
        } else if (left >= up && left >= diag1up && left >= diag2up) {
            return "l__" + left;
        } else if (up >= diag1up && up >= diag2up) {
            return "u__" + up;
        } else if (diag1up >= diag2up) {
            return "d1u" + diag1up;
        } else {
            return "d2u" + diag2up;
        }
    }

    /**
     * @param i:     position of the cell
     * @param j:     position of the cell
     * @param board: board of the game
     * @param m:     mark we have to check
     * @param op_i:  three possible value (-1, 0 ,1) if we want to analyze the up rows of the cell, the current rows of the cell or the down rows of the cell
     * @param op_j:  three possible value (-1, 0 ,1) if we want to analyze the up columns of the cell, the current columns of the cell or the down columns of the cell
     * @return -1 if it's impossible to win, otherwise the length of the row of mark
     */
    private int CheckCellDirection(int i, int j, Board board, Mark m, int op_i, int op_j) {
        /*count how many cells has the mark*/
        int counter = 0;

        /*for Gomoku board*/
        if (board.getDimension() > 3) {
            /*checking boards bounds*/
            if (i + 4 * op_i > board.getDimension() - 1 || i + 4 * op_i < 0 || j + 4 * op_j > board.getDimension() - 1 || j + 4 * op_j < 0)
                return -1;
            else {
                /*Cycle that count the mark*/
                for (int c = 0; c < 5; c++) {
                    if (board.getMark(i + c * op_i, j + c * op_j) == m)
                        counter++;
                    else if (board.getMark(i + c * op_i, j + c * op_j) != null)
                        return -1;
                }
            }
        }
        /*for TicTacToe board*/
        else {
            if (i + 2 * op_i > board.getDimension() - 1 || i + 2 * op_i < 0 || j + 2 * op_j > board.getDimension() - 1 || j + 2 * op_j < 0)
                return -1;
            else {
                for (int c = 0; c < 3; c++) {
                    if (board.getMark(i + c * op_i, j + c * op_j) == m)
                        counter++;
                    else if (board.getMark(i + c * op_i, j + c * op_j) != null)
                        return -1;

                }
            }

        }

        return counter;
    }

    /**
     * Returns the identifier of a player. Two players that have the same identifier must be equals.
     *
     * @return a string representing the identifier of the player
     */
    @Override
    public String getIdentifier() {
        return "NormalPlayer";
    }
}
