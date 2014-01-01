package com.zunama;

public class Main {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 8, 3, 0, 9, 5, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 9, 0, 0, 0, 3, 0, 8},
                {1, 0, 0, 0, 5, 0, 0, 0, 9},
                {0, 0, 0, 1, 0, 4, 0, 0, 0},
                {7, 0, 0, 0, 6, 0, 0, 0, 1},
                {6, 0, 5, 0, 0, 0, 4, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 8, 0, 1, 9, 0, 0}
        };

        SudokuSolver solver = new SudokuBacktrackSolver(grid);

        if (solver.solve()) {
            System.out.println("Solution:");
            printGrid(solver.getGrid());
        } else
            System.out.println("Unable to solve puzzle.");


    }

    private static void printGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
