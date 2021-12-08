import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Short.parseShort;
import static java.lang.Integer.parseInt;

public class Day7 {

    public static void main(String[] args) throws FileNotFoundException {
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day7/src/crabs.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        int sum = 0;
        String[] datas = new String[0];
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            datas = data.split(",");
            sum = sum(datas, datas.length);
        }
        int usedFeul = 0;
        for (int i=0;i<sum*2;i++){
            int guessedFeul = 0;
            for (int j=0;j<datas.length;j++){
                if (parseInt(datas[j]) > i){
                    guessedFeul += parseInt(datas[j]) - i;
                }else{
                    guessedFeul += i-parseInt(datas[j]);
                }
            }
            if (usedFeul == 0){
                usedFeul = guessedFeul;
            }else if(guessedFeul < usedFeul){
                usedFeul = guessedFeul;
            }
            System.out.println(i+": " + guessedFeul);
        }
        System.out.println(usedFeul);
    }

    public static void part2() throws FileNotFoundException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day7/src/crabs.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        int sum = 0;
        String[] datas = new String[0];
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            datas = data.split(",");
            sum = sum(datas, datas.length);
        }
        int usedFeul = 0;
        for (int i=0;i<sum*2;i++){
            int guessedFeul = 0;
            for (int j=0;j<datas.length;j++){
                int steps = 0;
                if (parseInt(datas[j]) > i){
                    steps += parseInt(datas[j]) - i;
                }else{
                    steps += i-parseInt(datas[j]);
                }
                for (int k =1;k<=steps;k++){
                    guessedFeul +=k;
                }
            }

            if (usedFeul == 0){
                usedFeul = guessedFeul;
            }else if(guessedFeul < usedFeul){
                usedFeul = guessedFeul;
            }
            System.out.println(i+": " + guessedFeul);
        }
        System.out.println(usedFeul);
    }


    private static int sum(String[] data, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += parseInt(data[i]);
        }
        return sum/length;
    }
}
