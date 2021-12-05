import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5{

    private static ArrayList<String> input;

    public static void main(String[] args) {
        new Day5();
        part2();
    }
    public Day5() {
        Scanner reader = null;
        try {
            reader = new Scanner(new File("N:/java/adventOfCode/2021/adventOfCode2021/Day5/src/vents.txt"));
        } catch (Exception e) {
            System.out.println("file not found");
        }
        input = new ArrayList<String>();
        while (reader.hasNext())
            input.add(reader.nextLine());

        reader.close();
    }

    public static void part1() {
        int[][] map = new int[1000][1000];
        int x1, x2, y1, y2;
        for (String line : input) {
            String[] p1 = line.substring(0, line.indexOf(" ")).split(",");
            String[] p2 = line.substring(line.lastIndexOf(" ") + 1).split(",");
            x1 = Integer.parseInt(p1[0]);
            y1 = Integer.parseInt(p1[1]);
            x2 = Integer.parseInt(p2[0]);
            y2 = Integer.parseInt(p2[1]);
            if (x1 == x2) {
                int lowY = Math.min(y1, y2);
                int highY = Math.max(y1, y2);
                for (int y = lowY; y <= highY; y++) {
                    map[x1][y]++;
                }
            } else if (y1 == y2) {
                int lowX = Math.min(x1, x2);
                int highX = Math.max(x1, x2);
                for (int x = lowX; x <= highX; x++) {
                    map[x][y1]++;
                }
            }
        }

        int count = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] >= 2) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void part2() {
        int[][] map = new int[1000][1000];
        int x1, x2, y1, y2;
        for (String line : input) {
            String[] p1 = line.substring(0, line.indexOf(" ")).split(",");
            String[] p2 = line.substring(line.lastIndexOf(" ") + 1).split(",");
            x1 = Integer.parseInt(p1[0]);
            y1 = Integer.parseInt(p1[1]);
            x2 = Integer.parseInt(p2[0]);
            y2 = Integer.parseInt(p2[1]);

            if (y1 == y2) {
                int lowX = Math.min(x1, x2);
                int highX = Math.max(x1, x2);
                for (int x = lowX; x <= highX; x++) {
                    map[y1][x]++;
                }
            } else if (x1 == x2) {
                int lowY = Math.min(y1, y2);
                int highY = Math.max(y1, y2);
                for (int y = lowY; y <= highY; y++) {
                    map[y][x1]++;
                }
            } else {

                int slope = (y2 - y1) / (x2 - x1);
                if (slope == 1) {

                    if (x1 < x2) {
                        int y = y1;
                        for (int x = x1; x <= x2; x++) {
                            map[y][x]++;
                            y++;
                        }
                    } else if (x2 < x1) {
                        int y = y2;
                        for (int x = x2; x <= x1; x++) {
                            map[y][x]++;
                            y++;
                        }
                    }
                } else if (slope == -1) {
                    if (x1 < x2) {
                        int y = y1;
                        for (int x = x1; x <= x2; x++) {
                            map[y][x]++;
                            y--;
                        }
                    } else if (x2 < x1) {
                        int y = y2;
                        for (int x = x2; x <= x1; x++) {
                            map[y][x]++;
                            y--;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] >= 2) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
