import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.io.*;
import java.util.*;

public class Day9 {
    static int rows = 100;
    static int numbers = 100;
    static int[][] grid = new int[rows][numbers];
    public static void main(String[] args) throws FileNotFoundException {
        part2();
    }

    private static void part1() throws FileNotFoundException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day9/src/heights.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String  data = myReader.nextLine();
            String[] datas = data.split("");
            for (int i =0;i<numbers;i++){
                grid[counter][i] = parseInt(datas[i]);
            }
            counter++;
        }
        Day9 day9 = new Day9();
        System.out.println(day9.checkGrid());
    }

    private void printGrid(){
        for (int i =0;i<rows;i++){
            for (int j=0;j<numbers;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    private int checkGrid() {
        int size = 1000;
        int[] list = new int[size];
        for (int i=0;i<size;i++){
            list[i] = -1;
        }
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numbers; j++){
                if (checkAbove(i,j) && checkDown(i,j) && checkLeft(i,j) && checkRight(i,j)){
                    list[counter] = grid[i][j];
                    counter++;
                }
            }
            System.out.println(Arrays.toString(list));
        }
        int total =0;
        for (int i=0;i<size;i++){
            if (list[i] != -1){
                total += list[i]+1;
            }
        }
        return total;
    }
    private boolean checkIndex(int index, int[][] array){
        try {
            if (array[index][0] == 0) {
                return true;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    private boolean checkAbove(int row, int number){
        if (checkIndex(row-1,grid)) {
            return grid[row - 1][number] > grid[row][number];
            }
        return true;
    }
    private boolean checkDown(int row, int number){
        if (checkIndex(row+1,grid)) {
            return grid[row +1][number] > grid[row][number];
        }
        return true;
    }
    private boolean checkLeft(int row, int number){
        if (number>0) {
            return grid[row][number-1] > grid[row][number];
        }
        return true;
    }
    private boolean checkRight(int row, int number){
        if (number+1<numbers) {
            return grid[row][number+1] > grid[row][number];
        }
        return true;
    }


    private static void part2(){
        System.out.println(largestBasinsRisk(new File("N:/java/adventOfCode/2021/adventOfCode2021/Day9/src/heights.txt")));
    }
    public static int largestBasinsRisk(File file)
    {
        ArrayList<String> lines = new InputScannerString(file).getResult();
        int linelength = lines.get(0).length();
        int[][] map = new int[lines.size()+2][linelength+2];

        // make border
        for(int x = 0; x < linelength+2; x++)
        {
            map[0][x] = 9;
            map[lines.size()+1][x] = 9;
        }
        for(int y = 1; y < lines.size()+1; y++)
        {
            map[y][0] = 9;
            map[y][linelength+1] = 9;
        }

        // put values
        for (int y = 1; y < lines.size()+1; y++)
        {
            String line = lines.get(y-1);
            for (int x = 1; x < linelength+1; x++)
            {
                map[y][x] = Character.getNumericValue(line.charAt(x-1));
            }
        }

        // count
        int[] sizes = new int[] {0,0,0};

        for(int y = 0; y < linelength+2; y++)
        {
            for(int x = 0; x < lines.size()+2; x++)
            {
                int size = next(x,y,map);

                if (size > sizes[0])
                {
                    sizes[0] = size;
                    Arrays.sort(sizes);
                }
            }
        }

        return sizes[0] * sizes[1] * sizes[2];
    }
    static int next(int x, int y, int[][] map)
    {
        if (map[x][y] == 9) return 0;
        map[x][y] = 9;
        return 1 + next(x+1,y,map) + next(x-1,y,map) + next(x,y+1,map) + next(x,y-1,map);
    }

}
class InputScannerString {
    private ArrayList<String> result = new ArrayList<String>();

    public InputScannerString(File input){
        try (Scanner in = new Scanner((new FileReader(input)))) {
            while (in.hasNext()) {
                result.add(in.nextLine());
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public ArrayList<String> getResult() { return result; }
}