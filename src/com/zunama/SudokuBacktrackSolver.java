package com.zunama;

public class SudokuBacktrackSolver implements SudokuSolver {

    private int[][] grid;

    public SudokuBacktrackSolver(int[][] grid) {
        this.grid = grid;
    }

    @Override
    public boolean solve() {

        Position newPos = findAssignedPosition();

        if (newPos == null)
            return true;

        for (int num = 1; num < 10; num++) {

            if (safeToUse(newPos, num)) {
                setPosition(newPos, num);

                if (solve())
                    return true;

                setPosition(newPos, 0);
            }
        }

        return false;
    }

    private boolean safeToUse(Position pos, int num) {

        return safeInRow(pos, num) &&
                safeInColumn(pos, num) &&
                safeInBox(pos, num);
    }

    private boolean safeInRow(Position pos, int num) {

        for (int col = 0; col < 9; col++) {
            if (grid[pos.getRow()][col] == num)
                return false;
        }

        return true;
    }

    private boolean safeInColumn(Position pos, int num) {

        for (int row = 0; row < 9; row++) {
            if (grid[row][pos.getColumn()] == num)
                return false;
        }

        return true;
    }

    private boolean safeInBox(Position pos, int num) {

        int startRow = pos.getRow() - pos.getRow() % 3;
        int startCol = pos.getColumn() - pos.getColumn() % 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[startRow + row][startCol + col] == num)
                    return false;
            }
        }

        return true;
    }

    private void setPosition(Position pos, int num) {
        grid[pos.getRow()][pos.getColumn()] = num;
    }

    private Position findAssignedPosition() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++)
                if (grid[x][y] == 0)
                    return new Position(x, y);
        }

        return null;
    }

    @Override
    public int[][] getGrid() {
        return grid;
    }

    private class Position {
        private int row;
        private int column;

        private Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        private int getRow() {
            return row;
        }

        private int getColumn() {
            return column;
        }
    }
}
