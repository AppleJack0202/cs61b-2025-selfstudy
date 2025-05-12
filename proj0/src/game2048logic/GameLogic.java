package game2048logic;

import Jama.Matrix;
import game2048rendering.Side;
import static game2048logic.MatrixUtils.rotateLeft;
import static game2048logic.MatrixUtils.rotateRight;

/**
 * @author  Josh Hug
 */
public class GameLogic {
    /** Moves the given tile up as far as possible, subject to the minR constraint.
     *
     * @param board the current state of the board
     * @param r     the row number of the tile to move up
     * @param c -   the column number of the tile to move up
     * @param minR  the minimum row number that the tile can land in, e.g.
     *              if minR is 2, the moving tile should move no higher than row 2.
     * @return      if there is a merge, returns the 1 + the row number where the merge occurred.
     *              if no merge occurs, then return 0.
     */
    public static int moveTileUpAsFarAsPossible(int[][] board, int r, int c, int minR) {
        // TODO: Fill this in in tasks 2, 3, 4
        while(r > minR && board[r-1][c] == 0){
            board[r-1][c] = board[r][c];
            board[r][c] = 0;
            r--;
        }
        if (r > minR && board[r][c] == board[r-1][c]) {
            board[r-1][c] = 2 * board[r][c];
            board[r][c] = 0;
            return r;
        }
        return 0;
    }

    /**
     * Modifies the board to simulate the process of tilting column c
     * upwards.
     *
     * @param board     the current state of the board
     * @param c         the column to tilt up.
     */
    public static void tiltColumn(int[][] board, int c) {
        // TODO: fill this in in task 5
        int minR = 0;
        for(int i = 1; i < board.length; i++) {
            int mergerow = moveTileUpAsFarAsPossible(board, i, c, minR);
            if (mergerow > 0) {
                minR = mergerow;
            }
        }
    }

    /**
     * Modifies the board to simulate tilting all columns upwards.
     *
     * @param board     the current state of the board.
     */
    public static void tiltUp(int[][] board) {
        // TODO: fill this in in task 6
        for(int c = 0; c < board.length; c++) {
            tiltColumn(board, c);
        }
    }

    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    public static void tilt(int[][] board, Side side) {
        // TODO: fill this in in task 7
        if (side == Side.EAST) {
            MatrixUtils.rotateLeft(board);
            tiltUp(board);
            MatrixUtils.rotateRight(board);
        } else if (side == Side.WEST) {
            MatrixUtils.rotateRight(board);
            tiltUp(board);
            MatrixUtils.rotateLeft(board);
        } else if (side == Side.SOUTH) {
            MatrixUtils.rotateLeft(board);
            MatrixUtils.rotateLeft(board);
            tiltUp(board);
            MatrixUtils.rotateRight(board);
            MatrixUtils.rotateRight(board);
        } else {
            tiltUp(board);
        }
    }
}
