import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day11 {
    private int[][] originalGrid;
    private int flashes = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Day11 day11 = new Day11();
        day11.part2();
    }

    public Day11() throws FileNotFoundException {
        Scanner reader = null;
        reader = new Scanner(new File("N:/java/adventOfCode/2021/adventOfCode2021/Day11/src/octopus.txt"));

        originalGrid = new int[10][10];
        int r = 0;
        while (reader.hasNext()) {
            String line = reader.nextLine();
            for (int c = 0; c < line.length(); c++) {
                originalGrid[r][c] = Integer.parseInt(line.substring(c, c + 1));
            }
            r++;
        }
        reader.close();
    }
    public void part1() {
        int[][] grid = copyOriginalGrid();
        for (int day = 1; day <= 100; day++) {
            updateGrid(grid);
        }
        System.out.println(flashes);
    }

    public void part2() {
        int[][] grid = copyOriginalGrid();
        int step = 0;
        // update the grid until every single element equals 0.
        while (!allZeros(grid)) {
            updateGrid(grid);
            step++;
        }
        System.out.println(step);
    }

    public int[][] copyOriginalGrid() {
        int[][] copy = new int[originalGrid.length][originalGrid[0].length];
        for (int r = 0; r < copy.length; r++) {
            for (int c = 0; c < copy[0].length; c++) {
                copy[r][c] = originalGrid[r][c];
            }
        }
        return copy;
    }

    private void updateGrid(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c]++;
            }
        }
        // let's go look for those 10s.
        checkForTens(grid);
    }

    private void checkForTens(int[][] grid) {
        boolean flash = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] >= 10) {
                    grid[r][c] = 0;
                    flashes++;
                    flash = true;
                    incremenentNeighbors(grid, r, c);
                }
            }
        }
        if (flash == true)
            checkForTens(grid);
    }

    private void incremenentNeighbors(int[][] grid, int r, int c) {
        int[] delta = new int[] { -1, 0, 1 };
        for (int i = 0; i < delta.length; i++) {
            for (int j = 0; j < delta.length; j++) {
                if (i == 1 && j == 1)
                    continue;
                if (isEligibleForFlashIncrement(grid, r + delta[i], c + delta[j]))
                    grid[r + delta[i]][c + delta[j]]++;
            }
        }
    }
    private boolean isEligibleForFlashIncrement(int[][] grid, int r, int c) {
        return (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != 0);
    }


    private boolean allZeros(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != 0)
                    return false;
            }
        }
        return true;
    }
}
