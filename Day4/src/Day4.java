import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day4 extends bingoCard {
    public static void main(String[] args) throws FileNotFoundException {
        part1();
    }

    private static void part1() throws FileNotFoundException {
        bingoCard[] card = new bingoCard[100];
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day4/src/bingo.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);

        int counter = 0;

        boolean firstrow = true;
        int[] bingpNumbers = new int[50];
        String[] numbers = new String[100];
        while (myReader.hasNextLine()) {
            if (firstrow) {
                String data = myReader.nextLine();
                numbers = data.split(",");
                firstrow = false;
            } else {
                bingoCard bingoCard = new bingoCard();
                for (int i = 0; i < 5; i++) {
                    int[] row = new int[5];
                    for (int j = 0; j < 5; j++) {
                        int data = myReader.nextInt();
                        row[j] = data;
                    }
                    switch (i) {
                        case 0:
                            bingoCard.setRow1(row);
                            break;
                        case 1:
                            bingoCard.setRow2(row);
                            break;
                        case 2:
                            bingoCard.setRow3(row);
                            break;
                        case 3:
                            bingoCard.setRow4(row);
                            break;
                        case 4:
                            bingoCard.setRow5(row);
                            break;
                    }

                }
                card[counter] = bingoCard;
                counter++;
            }
            //System.out.println(data);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (card[j].done == 0) {
                    boolean ended = card[j].checkRows(parseInt(numbers[i]));
                    boolean ended2 = card[j].checkColums(parseInt(numbers[i]));
                    boolean ended3 = card[j].checkWholeCard();
                    //System.out.println(ended);
                    if (ended || ended2 || ended3) {
                        card[j].done = 1;
                        System.out.println(card[j]);
                        System.out.println((card[j].total() * parseInt(numbers[i])));
                    }
                }

        }
    }

}
}
