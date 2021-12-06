import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Short.parseShort;

public class Day6 {
     static ArrayList<Short> school = new ArrayList<Short>();

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        part1();
    }

    public static synchronized void part1() throws FileNotFoundException, InterruptedException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day6/src/fish.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] datas = data.split(",");
            for (String s : datas) {
                school.add(parseShort(s));
            }
        }
        myReader.close();
        myObj = null;
        for (int i =0;i<256;i++) {
            Day6 day6 = new Day6();
            day6.checkSchool();
        }
        System.out.println(school.size());
    }
    private void checkSchool(){
        ArrayList<Short> tempSchool = new ArrayList<Short>();
        for (int i=0;i<school.size();i++) {
            if (school.get(i) == 0){
                tempSchool.add((short) 8);

            }
            if (school.get(i) != 0){
                school.set(i, (short) (school.get(i) -1));

            }else{
                school.set(i, (short)6);
            }

        }
        school.addAll(tempSchool);
    }

}
