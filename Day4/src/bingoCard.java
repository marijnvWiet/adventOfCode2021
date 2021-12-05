import java.util.Arrays;

public class bingoCard {
    public int[] row1 = new int[5];
    public int[] row2 = new int[5];
    public int[] row3 = new int[5];
    public int[] row4 = new int[5];
    public int[] row5 = new int[5];
    public int done =0;



    public bingoCard() {
    }

    public void setRow1(int[] row1) {
        this.row1 = row1;
    }

    public void setRow2(int[] row2) {
        this.row2 = row2;
    }

    public void setRow3(int[] row3) {
        this.row3 = row3;
    }

    public void setRow4(int[] row4) {
        this.row4 = row4;
    }

    public void setRow5(int[] row5) {
        this.row5 = row5;
    }

    public boolean checkRows(int number){
        int counter = 0;
        for (int i=0;i<5;i++){
            if (row1[i] == number){
                row1[i] = -1;
            }
            if (row1[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row2[i] == number){
                row2[i] = -1;
            }
            if (row2[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row3[i] == number){
                row3[i] = -1;
            }
            if (row3[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row4[i] == number){
                row4[i] = -1;
            }
            if (row4[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row5[i] == number){
                row5[i] = -1;
            }
            if (row5[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        return false;
    }

    public boolean checkColums(int number){
        for (int i = 0;i<5;i++){
            int counter = 0;
            if (row1[i] == number){
                row1[i] = -1;
            }
            if (row1[i] == -1){
                counter++;
            }
            if (row2[i] == number){
                row2[i] = -1;
            }
            if (row2[i] == -1){
                counter++;
            }
            if (row3[i] == number){
                row3[i] = -1;
            }
            if (row3[i] == -1){
                counter++;
            }
            if (row4[i] == number){
                row4[i] = -1;
            }
            if (row4[i] == -1){
                counter++;
            }
            if (row5[i] == number){
                row5[i] = -1;
            }
            if (row5[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }

        }
        return false;
    }

    public boolean checkWholeCard(){
        for (int i = 0;i<5;i++){
            int counter = 0;
            if (row1[i] == -1){
                counter++;
            }
            if (row2[i] == -1){
                counter++;
            }
            if (row3[i] == -1){
                counter++;
            }
            if (row4[i] == -1){
                counter++;
            }
            if (row5[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }

        }
        int counter = 0;
        for (int i=0;i<5;i++){
            if (row1[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row2[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row3[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row4[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }
        counter = 0;
        for (int i=0;i<5;i++){
            if (row5[i] == -1){
                counter++;
            }
            if (counter == 5){
                return true;
            }
        }

        return false;
    }


    public int total(){
        int total = 0;
        for (int i=0;i<5;i++){
            if (row1[i] != -1) {
                total += row1[i];
            }
            if (row2[i] != -1) {
                total += row2[i];
            }
            if (row3[i] != -1) {
                total += row3[i];
            }
            if (row4[i] != -1) {
                total += row4[i];
            }
            if (row5[i] != -1) {
                total += row5[i];
            }
        }
        return total;
    }
    @Override
    public String toString() {
        return
                "\n"+
                Arrays.toString(row1) + "\n" +
                Arrays.toString(row2) +"\n" +
                Arrays.toString(row3) +"\n" +
                Arrays.toString(row4) +"\n" +
                Arrays.toString(row5)+ "\n" ;
    }
}
