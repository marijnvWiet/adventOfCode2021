import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Long.parseLong;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {
        part2();
    }

    private static void part1() throws FileNotFoundException {
        int gamma = 0;
        int epsilon = 0;
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day3/src/consumption");
        Scanner myReader = null;
        for (int i = 0; i < 12; i++) {
            int counter1 = 0;
            int counter0 = 0;
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.charAt(i) == '1') {
                    counter1++;
                } else if (data.charAt(i) == '0') {
                    counter0++;
                }
            }
            System.out.println("1: " + counter1 + " 0: " + counter0);
            if (counter1 > counter0) {
                gamma |= 1 << 11 - i;
            } else {
                epsilon |= 1 << 11 - i;
            }
        }
        System.out.println(gamma * epsilon);
    }

    private static void part2() throws FileNotFoundException {
        String[] history = new String[1000];
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day3/src/consumption");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            history[counter] = data;
            counter++;

        }
        String[] gamma = history;
        for (int k = 0; k<12;k++) {
            int tel1 = 0;
            int tel0 = 0;
            int[] numbers1 = new int[1000];
            int[] numbers0 = new int[1000];
            for (int i = 0; i < 1000; i++) {
                if (gamma[i] != null) {
                    if (gamma[i].charAt(k) == '1') {
                        numbers1[i] = i;
                        tel1++;
                    }
                    if (gamma[i].charAt(k) == '0') {
                        numbers0[i] = i;
                        tel0++;
                    }
                }
            }
            System.out.println(k);
            System.out.println("tel0: " + tel0);
            System.out.println("tel1: " + tel1);
            if (tel1+tel0 == 2){
                break;
            }
            if (tel1 > tel0) {
                for (int i = 0; i < 1000; i++) {
                    if (numbers1[i] != 0) {
                        gamma[numbers1[i]] = null;
                    }
                }
            }else{
                for (int i = 0; i < 1000; i++) {
                    gamma[0] = null;
                    if (numbers0[i] != 0) {
                        gamma[numbers0[i]] = null;
                    }
                }
            }
        }
        for (int i = 0; i < 1000; i++) {
            gamma[0] = null;
            if (gamma[i] != null) {
                System.out.println(gamma[i]);
            }
        }



}

}



