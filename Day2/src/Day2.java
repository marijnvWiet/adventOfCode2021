import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day2 {


    public static void main(String[] args) throws FileNotFoundException {
        part2();
    }


    private static void part1() throws FileNotFoundException {
        int forward = 0;
        int depth = 0;
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day2/src/commando's.txt");
        Scanner myReader = null;

        myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splittedData = data.split(" ");

            switch (splittedData[0]) {
                case "up":
                    depth -= parseInt(splittedData[1]);
                    break;
                case "down":
                    depth += parseInt(splittedData[1]);
                    break;
                case "forward":
                    forward += parseInt(splittedData[1]);
                    break;
                default:
                    System.out.println("error");

                    break;
            }
        }
        System.out.println(depth * forward);
    }

    private static void part2() throws FileNotFoundException {
        int forward = 0;
        int depth = 0;
        int aim = 0;
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day2/src/commando's.txt");
        Scanner myReader = null;

        myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splittedData = data.split(" ");

            switch (splittedData[0]) {
                case "up":
                    aim -= parseInt(splittedData[1]);
                    break;
                case "down":
                    aim += parseInt(splittedData[1]);
                    break;
                case "forward":
                    forward += parseInt(splittedData[1]);
                    depth += parseInt(splittedData[1])*aim;
                    break;
                default:
                    System.out.println("error");

                    break;
            }
        }
        System.out.println(depth * forward);
    }
}

