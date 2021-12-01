import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day1 {

    public static void main(String[] args) {
        part2();
    }
    private static void part1(){
        try {
            int prev = 0;
            int counter = 0;
            File myObj = new File("N:/java/adventOfCode/Day1/src/measurements.txt");
            Scanner myReader = null;

            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int data = myReader.nextInt();
                if (data > prev) {counter++;}
                System.out.println("prev: " + prev + " current: " + data);
                prev = data;

            }
            myReader.close();
            System.out.println(counter-1);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    private static void part2(){
        try {
            int prev = 0;
            int counter = 0;
            int line1,line2,line3,line4;
            File myObj = new File("N:/java/adventOfCode/Day1/src/measurements.txt");
            Scanner myReader = null;

            myReader = new Scanner(myObj);
            line1 = myReader.nextInt();
            line2 = myReader.nextInt();
            line3 = myReader.nextInt();
            while (myReader.hasNextLine()) {
                line4 = myReader.nextInt();
                if ((line1+line2+line3)<(line2+line3+line4)){counter++;}
                System.out.println("prev: " + (line1+line2+line3) + " current: " + (line2+line3+line4));
                line1 = line2;
                line2 = line3;
                line3 = line4;
            }
            myReader.close();
            System.out.println(counter);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
};

